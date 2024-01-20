package com.xtrape.content.anon;

import com.xtrape.common.core.utils.StringUtils;
import com.xtrape.common.core.web.domain.AjaxResult;
import com.xtrape.common.core.web.domain.R;
import com.xtrape.common.core.web.page.PaginationEntity;
import com.xtrape.common.core.web.page.TableDataInfo;
import com.xtrape.common.security.web.controller.BaseController;
import com.xtrape.content.blog.domain.CmsBlog;
import com.xtrape.content.blog.domain.CmsBlogSearch;
import com.xtrape.content.blog.service.ICmsBlogService;
import com.xtrape.content.comment.domain.CmsComment;
import com.xtrape.content.comment.service.ICmsCommentService;
import com.xtrape.content.feign.SystemFeignService;
import com.xtrape.content.fileInfo.service.ISysFileInfoService;
import com.xtrape.content.tag.domain.CmsTag;
import com.xtrape.content.tag.service.ICmsTagService;
import com.xtrape.content.type.domain.CmsType;
import com.xtrape.content.type.service.ICmsTypeService;
import com.xtrape.system.service.ISysPermissionService;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/anon")
public class AnonController extends BaseController {
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

    @Autowired
    private ICmsCommentService cmsCommentService;
    /**
     * list
     */
    @PostMapping("/list")
    public TableDataInfo list(@RequestBody ListBlogParams params) {
        String[] categoryArray = params.getCategory().split(",");
        startPage(params);
        CmsBlogSearch cmsBlogSearch = new CmsBlogSearch();
        cmsBlogSearch.setCats(categoryArray);
        cmsBlogSearch.setStatuses(new int[] { 1 });
        cmsBlogSearch.setTypes(new int[] { 1 });
        cmsBlogSearch.setDialects(new String[] {params.getDialect()});
        if (params.getTop() != null) {
            cmsBlogSearch.setTops(new Integer[]{params.getTop()});
        }
        List<CmsBlog> list = cmsBlogService.inquire(cmsBlogSearch);
        return getDataTable(list);
    }

    /**
     * 查询评论管理列表
     */
    @PostMapping("/listComment")
    public R<PaginationEntity<CmsComment>> listComment(@RequestBody CmsComment cmsComment)
    {
//        XtrapeContext requestContext = XtrapeContextHolder.take();
        // 角色集合
//        Set<String> roles = permissionService.getRolePermission(requestContext.getMember());
//        if (!RequestContextHolder.isAdmin(getUserId())&&!roles.contains("admin")&&!roles.contains("cms")){
//            cmsComment.setCreateBy(getUserName());
//        }
        cmsComment.setDelFlag("0");
        startPage();
        List<CmsComment> list = cmsCommentService.selectCmsCommentList(cmsComment);
        TableDataInfo tableDataInfo = new TableDataInfo();
        PaginationEntity paginationEntity = new PaginationEntity();
        paginationEntity.setList(list);
        paginationEntity.setCount(tableDataInfo.getTotal());
        return R.ok(paginationEntity);
    }

    @GetMapping("/homepage/{lang}")
    public java.util.Map<String, Object> home(@PathVariable(value = "lang", required = false)String lang) {
        java.util.Map<String, Object> resultMap = new HashMap<>();

        return resultMap;
    }
    /**
     * 首页获取文章详细信息
     */
    @GetMapping(value = {"/pickup/{id}"})
    public AjaxResult pickup(@PathVariable(value = "id", required = false) String id) {
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
}
