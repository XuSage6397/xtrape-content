package com.xtrape.content.tag.controller;

import java.util.List;
import java.util.Set;
import jakarta.servlet.http.HttpServletResponse;

import com.xtrape.common.core.annotation.Log;
import com.xtrape.common.core.enums.BusinessType;
import com.xtrape.common.core.utils.poi.ExcelUtil;
import com.xtrape.common.security.utils.SecurityUtils;
import com.xtrape.common.security.web.controller.BaseController;
import com.xtrape.common.core.web.page.TableDataInfo;
import com.xtrape.content.tag.service.ICmsTagService;
import com.xtrape.system.service.ISysPermissionService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.xtrape.common.core.web.domain.AjaxResult;
import com.xtrape.content.tag.domain.CmsTag;

/**
 * 标签管理Controller
 * 
 * @author ning
 * @date 2022-01-02
 */
@RestController
@RequestMapping("/tag")
public class CmsTagController extends BaseController
{
    @Autowired
    private ICmsTagService cmsTagService;

    @Autowired
    private ISysPermissionService permissionService;

    /**
     * 查询标签管理列表
     */
    @PreAuthorize("@ss.hasPermi('cms:tag:list')")
    @GetMapping("/list")
    public TableDataInfo list(CmsTag cmsTag)
    {
        startPage();
        // 角色集合
        Set<String> roles = permissionService.getRolePermission(getLoginUser().getUser());
        if (!SecurityUtils.isAdmin(getUserId())&&!roles.contains("admin")&&!roles.contains("cms")){
            cmsTag.setCreateBy(getUsername());
        }
        List<CmsTag> list = cmsTagService.selectCmsTagList(cmsTag);
        return getDataTable(list);
    }

    /**
     * 导出标签管理列表
     */
    @PreAuthorize("@ss.hasPermi('cms:tag:export')")
    @Log(title = "标签管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CmsTag cmsTag)
    {
        List<CmsTag> list = cmsTagService.selectCmsTagList(cmsTag);
        ExcelUtil<CmsTag> util = new ExcelUtil<CmsTag>(CmsTag.class);
        util.exportExcel(response, list, "标签管理数据");
    }

    /**
     * 获取标签管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('cms:tag:query')")
    @GetMapping(value = "/{tagId}")
    public AjaxResult getInfo(@PathVariable("tagId") Long tagId)
    {
        return AjaxResult.success(cmsTagService.selectCmsTagByTagId(tagId));
    }

    /**
     * 新增标签管理
     */
    @PreAuthorize("@ss.hasPermi('cms:tag:add')")
    @Log(title = "标签管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CmsTag cmsTag)
    {
        cmsTag.setCreateBy(getUsername());
        return toAjax(cmsTagService.insertCmsTag(cmsTag));
    }

    /**
     * 修改标签管理
     */
    @PreAuthorize("@ss.hasPermi('cms:tag:edit')")
    @Log(title = "标签管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CmsTag cmsTag)
    {
        cmsTag.setUpdateBy(getUsername());
        return toAjax(cmsTagService.updateCmsTag(cmsTag));
    }

    /**
     * 删除标签管理
     */
    @PreAuthorize("@ss.hasPermi('cms:tag:remove')")
    @Log(title = "标签管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{tagIds}")
    public AjaxResult remove(@PathVariable Long[] tagIds)
    {
        return toAjax(cmsTagService.deleteCmsTagByTagIds(tagIds));
    }
}
