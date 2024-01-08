package com.xtrape.content.type.controller;

import java.util.List;
import java.util.Set;

import com.xtrape.context.XtrapeContext;
import jakarta.servlet.http.HttpServletResponse;

import com.xtrape.common.core.annotation.Log2;
import com.xtrape.common.core.enums.BusinessType;
import com.xtrape.common.core.utils.poi.ExcelUtil;
import com.xtrape.context.XtrapeContextHolder;
import com.xtrape.common.security.web.controller.BaseController;
import com.xtrape.common.core.web.page.TableDataInfo;
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
import com.xtrape.content.type.domain.CmsType;
import com.xtrape.content.type.service.ICmsTypeService;

/**
 * 分类管理Controller
 * 
 * @author ning
 * @date 2022-01-02
 */
@RestController
@RequestMapping("/type")
public class CmsTypeController extends BaseController
{
    @Autowired
    private ICmsTypeService cmsTypeService;

    @Autowired
    private ISysPermissionService permissionService;

    /**
     * 查询分类管理列表
     */
    @PreAuthorize("@ss.hasPermi('cms:type:list')")
    @GetMapping("/list")
    public TableDataInfo list(CmsType cmsType)
    {
        XtrapeContext requestContext = XtrapeContextHolder.take();

        startPage();
        // 角色集合
        Set<String> roles = permissionService.getRolePermission(requestContext.getMember());
//        if (!RequestContextHolder.isAdmin(getUserId())&&!roles.contains("admin")&&!roles.contains("cms")){
//            cmsType.setCreateBy(getUserName());
//        }
        List<CmsType> list = cmsTypeService.selectCmsTypeList(cmsType);
        return getDataTable(list);
    }

    /**
     * 导出分类管理列表
     */
    @PreAuthorize("@ss.hasPermi('cms:type:export')")
    @Log2(title = "分类管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CmsType cmsType)
    {
        List<CmsType> list = cmsTypeService.selectCmsTypeList(cmsType);
        ExcelUtil<CmsType> util = new ExcelUtil<CmsType>(CmsType.class);
        util.exportExcel(response, list, "分类管理数据");
    }

    /**
     * 获取分类管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('cms:type:query')")
    @GetMapping(value = "/{typeId}")
    public AjaxResult getInfo(@PathVariable("typeId") String typeId)
    {
        return AjaxResult.success(cmsTypeService.selectCmsTypeByTypeId(typeId));
    }

    /**
     * 新增分类管理
     */
    @PreAuthorize("@ss.hasPermi('cms:type:add')")
    @Log2(title = "分类管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CmsType cmsType)
    {
        XtrapeContext requestContext = XtrapeContextHolder.take();
        cmsType.setCreateBy(requestContext.getNickname());
        return toAjax(cmsTypeService.insertCmsType(cmsType));
    }

    /**
     * 修改分类管理
     */
    @PreAuthorize("@ss.hasPermi('cms:type:edit')")
    @Log2(title = "分类管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CmsType cmsType)
    {
        XtrapeContext requestContext = XtrapeContextHolder.take();
        cmsType.setUpdateBy(requestContext.getNickname());
        return toAjax(cmsTypeService.updateCmsType(cmsType));
    }

    /**
     * 删除分类管理
     */
    @PreAuthorize("@ss.hasPermi('cms:type:remove')")
    @Log2(title = "分类管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{typeIds}")
    public AjaxResult remove(@PathVariable String[] typeIds)
    {
        return toAjax(cmsTypeService.deleteCmsTypeByTypeIds(typeIds));
    }

    /**
     * 取消按钮-删除分类图片
     */
    @PreAuthorize("@ss.hasPermi('cms:type:edit')")
    @PostMapping("/cancel")
    public AjaxResult cancel(@RequestBody CmsType cmsType)
    {
        return toAjax(cmsTypeService.cancel(cmsType));
    }

}
