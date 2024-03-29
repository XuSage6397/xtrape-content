package com.xtrape.content.blog.controller;

import com.xtrape.common.core.annotation.Log2;
import com.xtrape.common.core.enums.BusinessType;
import com.xtrape.common.core.utils.StringUtils;
import com.xtrape.common.core.utils.poi.ExcelUtil;
import com.xtrape.common.core.utils.uuid.UUID;
import com.xtrape.common.core.web.domain.AjaxResult;
import com.xtrape.common.core.web.page.TableDataInfo;
import com.xtrape.common.security.web.controller.BaseController;
import com.xtrape.content.blog.domain.CmsBlog;
import com.xtrape.content.blog.service.ICmsBlogService;
import com.xtrape.content.feign.SystemFeignService;
import com.xtrape.content.fileInfo.service.ISysFileInfoService;
import com.xtrape.content.tag.domain.CmsTag;
import com.xtrape.content.tag.service.ICmsTagService;
import com.xtrape.content.type.domain.CmsType;
import com.xtrape.content.type.service.ICmsTypeService;
import com.xtrape.context.XtrapeContext;
import com.xtrape.context.XtrapeContextHolder;
import com.xtrape.system.service.ISysPermissionService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;


/**
 * 文章管理Controller
 *
 * @author ning
 * @date 2022-01-01
 */
@Slf4j
@RestController
@RequestMapping("/blog")
public class CmsBlogController extends BaseController {
    @Autowired
    private ICmsBlogService cmsBlogService;

    @Autowired
    private ICmsTypeService cmsTypeService;

    @Autowired
    private ICmsTagService cmsTagService;

    @Autowired
    private ISysPermissionService permissionService;

    @Autowired
    private ISysFileInfoService sysFileInfoService;

    @Autowired
    SystemFeignService systemFeignService;

    /**
     * 首页查询文章列表
     */
    @GetMapping("/cmsList")
    public TableDataInfo cmsList(CmsBlog cmsBlog) {
        startPage();
        //状态为发布
        cmsBlog.setStatus("1");
        List<CmsBlog> list = cmsBlogService.selectCmsBlogList(cmsBlog);
        return getDataTable(list);
    }

    /**
     * 首页获取文章详细信息
     */
    @GetMapping(value = {"/detail/", "/detail/{id}"})
    public AjaxResult getInfoDetail(@PathVariable(value = "id", required = false) String id) {
        AjaxResult ajax = AjaxResult.success();
        CmsType cmsType = new CmsType();
        CmsTag cmsTag = new CmsTag();
        ajax.put("types", cmsTypeService.selectCmsTypeList(cmsType));
        ajax.put("tags", cmsTagService.selectCmsTagList(cmsTag));
        if (StringUtils.isNotNull(id)) {
            ajax.put(AjaxResult.DATA_TAG, cmsBlogService.selectCmsBlogById(id));
        }
        return ajax;
    }

    /**
     * 首页按分类查询文章列表
     */
    @GetMapping("/cmsListByType/{id}")
    public TableDataInfo cmsListByTypeId(@PathVariable(value = "id", required = false) String id) {
        startPage();
        List<CmsBlog> list = cmsBlogService.selectCmsBlogListByTypeId(id);
        return getDataTable(list);
    }

    /**
     * 首页按标签查询文章列表
     */
    @GetMapping("/cmsListByTag/{id}")
    public TableDataInfo cmsListByTagId(@PathVariable(value = "id", required = false) String id) {
        startPage();
        List<CmsBlog> list = cmsBlogService.selectCmsBlogListByTagId(id);
        return getDataTable(list);
    }

    /**
     * 首页查询推荐文章列表
     */
    @GetMapping("/cmsListRecommend")
    public TableDataInfo cmsListRecommend(CmsBlog cmsBlog) {
        startPage();
        //状态为发布
        cmsBlog.setStatus("1");
        List<CmsBlog> list = cmsBlogService.selectCmsBlogListRecommend(cmsBlog);
        return getDataTable(list);
    }

    /**
     * 首页增加阅读量
     */
    @GetMapping("/addBlogViews/{id}")
    public AjaxResult addBlogViews(@PathVariable(value = "id", required = false) String id) {
        CmsBlog cmsBlog = cmsBlogService.selectCmsBlogById(id);
        Long views = cmsBlog.getViews();
        views += Long.parseLong("1");
        cmsBlog.setViews(views);
        cmsBlogService.updateCmsBlog(cmsBlog);
        return AjaxResult.success(id);
    }

    /**
     * 随笔页查询文章列表
     */
    @GetMapping("/cmsEssayList")
    public TableDataInfo cmsEssayList(CmsBlog cmsBlog) {
        startPage();
        //状态为发布
        cmsBlog.setStatus("1");
        List<CmsBlog> list = cmsBlogService.selectCmsBlogList(cmsBlog);
        return getDataTable(list);
    }

    /**
     * 查询文章管理列表
     */
    @PreAuthorize("@ss.hasPermi('cms:blog:list')")
    @GetMapping("/list")
    public TableDataInfo list(CmsBlog cmsBlog) {
        XtrapeContext requestContext = XtrapeContextHolder.take();

        startPage();
        AjaxResult roleResult = systemFeignService.listMnemonicByMemberPortal();
        log.info("systemFeignService: {}", roleResult);
        // 角色集合
        Collection<String> roles = requestContext.getRoles();
//        if (!roles.isEmpty()) {
//            // todo: 验证当前模块的权限和当前用户权限是否匹配。 注意： 模块权限在 System 中限制， 这里不需要验证。
//            cmsBlog.setCreateBy(requestContext.getNickname());
//        }
        List<CmsBlog> list = cmsBlogService.selectCmsBlogList(cmsBlog);
        return getDataTable(list);
    }

    /**
     * 导出文章管理列表
     */
    @PreAuthorize("@ss.hasPermi('cms:blog:export')")
    @Log2(title = "文章管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CmsBlog cmsBlog) {
        List<CmsBlog> list = cmsBlogService.selectCmsBlogList(cmsBlog);
        ExcelUtil<CmsBlog> util = new ExcelUtil<CmsBlog>(CmsBlog.class);
        util.exportExcel(response, list, "文章管理数据");
    }

    /**
     * 获取文章管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('cms:blog:query')")
    @GetMapping(value = {"/", "/{id}"})
    public AjaxResult getInfo(@PathVariable(value = "id", required = false) String id) {
        AjaxResult ajax = AjaxResult.success();
        CmsType cmsType = new CmsType();
        CmsTag cmsTag = new CmsTag();
        ajax.put("types", cmsTypeService.selectCmsTypeList(cmsType));
        ajax.put("tags", cmsTagService.selectCmsTagList(cmsTag));
        if (StringUtils.isNotNull(id)) {
            ajax.put(AjaxResult.DATA_TAG, cmsBlogService.selectCmsBlogById(id));
        }
        return ajax;
    }

    /**
     * 新增文章管理
     */
//    @PreAuthorize("@ss.hasPermi('cms:blog:add')")
    @Log2(title = "文章管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CmsBlog cmsBlog) {
        XtrapeContext requestContext = XtrapeContextHolder.take();

        cmsBlog.setCreateBy(requestContext.getMember());
        if (cmsBlog.getId() == null) {
            cmsBlog.setId(UUID.randomUUID(true).toString(true));
        }
        String blogId = cmsBlogService.insertCmsBlog(cmsBlog);
        if (blogId == null) {
            return AjaxResult.error();
        }
        return AjaxResult.success(blogId);
    }

    /**
     * 修改文章管理
     */
//    @PreAuthorize("@ss.hasPermi('cms:blog:edit')")
    @Log2(title = "文章管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CmsBlog cmsBlog) {
        XtrapeContext requestContext = XtrapeContextHolder.take();

        cmsBlog.setUpdateBy(requestContext.getNickname());
        //删除原首图
        CmsBlog oldBlog = cmsBlogService.selectCmsBlogById(cmsBlog.getId());
//        if (cmsBlog.getBlogPic().isEmpty() || !cmsBlog.getBlogPic().equals(oldBlog.getBlogPic())) {
//            if (!oldBlog.getBlogPic().isEmpty()) {
//                String blogPic = oldBlog.getBlogPic();
//                if (blogPic != null && !"".equals(blogPic)) {
//                    int newFileNameSeparatorIndex = blogPic.lastIndexOf("/");
//                    String FileName = blogPic.substring(newFileNameSeparatorIndex + 1).toLowerCase();
//                    sysFileInfoService.deleteSysFileInfoByFileObjectName(FileName);
//                }
//            }
//        }
        return toAjax(cmsBlogService.updateCmsBlog(cmsBlog));
    }

    /**
     * 删除文章管理
     */
    @PreAuthorize("@ss.hasPermi('cms:blog:remove')")
    @Log2(title = "文章管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids) {
        //删除原首图
        for (String id : ids) {
            CmsBlog oldBlog = cmsBlogService.selectCmsBlogById(id);
            if (!oldBlog.getBlogPic().isEmpty()) {
                String blogPic = oldBlog.getBlogPic();
                if (blogPic != null && !"".equals(blogPic)) {
                    int newFileNameSeparatorIndex = blogPic.lastIndexOf("/");
                    String FileName = blogPic.substring(newFileNameSeparatorIndex + 1).toLowerCase();
//                    sysFileInfoService.deleteSysFileInfoByFileObjectName(FileName);
                }
            }
        }
        return toAjax(cmsBlogService.deleteCmsBlogByIds(ids));
    }

    /**
     * 取消按钮-删除首图
     */
    @PreAuthorize("@ss.hasPermi('cms:blog:edit')")
    @PostMapping("/cancel")
    public AjaxResult cancel(@RequestBody CmsBlog cmsBlog) {
        String blogPic = cmsBlog.getBlogPic();
        if (blogPic != null && !"".equals(blogPic)) {
            String blogId = cmsBlog.getId();
            if (blogId == null) {
                int newFileNameSeparatorIndex = blogPic.lastIndexOf("/");
                String FileName = blogPic.substring(newFileNameSeparatorIndex + 1).toLowerCase();
                sysFileInfoService.deleteSysFileInfoByFileObjectName(FileName);
            } else {
                String Pic = cmsBlogService.selectCmsBlogById(blogId).getBlogPic();
                if (!blogPic.equals(Pic)) {
                    int newFileNameSeparatorIndex = blogPic.lastIndexOf("/");
                    String FileName = blogPic.substring(newFileNameSeparatorIndex + 1).toLowerCase();
                    sysFileInfoService.deleteSysFileInfoByFileObjectName(FileName);
                }
            }
        }
        return toAjax(1);
    }
}
