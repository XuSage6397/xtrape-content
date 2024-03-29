package com.xtrape.content.fileInfo.controller;

import java.util.List;
import java.util.Set;

import com.xtrape.context.XtrapeContext;
import com.xtrape.context.XtrapeContextHolder;
import jakarta.servlet.http.HttpServletResponse;

import com.xtrape.common.core.annotation.Log2;
import com.xtrape.common.core.enums.BusinessType;
import com.xtrape.common.core.exception.ServiceException;
import com.xtrape.common.core.utils.poi.ExcelUtil;
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
import com.xtrape.content.fileInfo.domain.SysFileInfo;
import com.xtrape.content.fileInfo.service.ISysFileInfoService;

/**
 * 文件管理Controller
 * 
 * @author xtrape
 * @date 2021-12-29
 */
@RestController
@RequestMapping("/fileInfo")
public class SysFileInfoController extends BaseController
{
    @Autowired
    private ISysFileInfoService sysFileInfoService;

    @Autowired
    private ISysPermissionService permissionService;

    /**
     * 查询文件管理列表
     */
    @PreAuthorize("@ss.hasPermi('cms:fileInfo:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysFileInfo sysFileInfo)
    {
        XtrapeContext requestContext = XtrapeContextHolder.take();

        startPage();
        //判断用户权限
        String createBy = sysFileInfo.getCreateBy();
        if (createBy==null&&"".equals(createBy)){
            throw new ServiceException("获取列表createBy参数为空");
        }
        // 角色集合
        Set<String> roles = permissionService.getRolePermission(requestContext.getMember());
//        if (RequestContextHolder.isAdmin(getUserId())||roles.contains("admin")||roles.contains("cms")){
//            sysFileInfo.setCreateBy("");
//        }
        List<SysFileInfo> list = sysFileInfoService.selectSysFileInfoList(sysFileInfo);
        return getDataTable(list);
    }

    /**
     * 导出文件管理列表
     */
    @PreAuthorize("@ss.hasPermi('cms:fileInfo:export')")
    @Log2(title = "文件管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysFileInfo sysFileInfo)
    {
        List<SysFileInfo> list = sysFileInfoService.selectSysFileInfoList(sysFileInfo);
        ExcelUtil<SysFileInfo> util = new ExcelUtil<SysFileInfo>(SysFileInfo.class);
        util.exportExcel(response, list, "文件管理数据");
    }

    /**
     * 获取文件管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('cms:fileInfo:query')")
    @GetMapping(value = "/{fileId}")
    public AjaxResult getInfo(@PathVariable("fileId") Long fileId)
    {
        return AjaxResult.success(sysFileInfoService.selectSysFileInfoByFileId(fileId));
    }

    /**
     * 新增文件管理
     */
    @PreAuthorize("@ss.hasPermi('cms:fileInfo:add')")
    @Log2(title = "文件管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysFileInfo sysFileInfo)
    {
        return toAjax(sysFileInfoService.insertSysFileInfo(sysFileInfo));
    }

    /**
     * 修改文件管理
     */
    @PreAuthorize("@ss.hasPermi('cms:fileInfo:edit')")
    @Log2(title = "文件管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysFileInfo sysFileInfo)
    {
        return toAjax(sysFileInfoService.updateSysFileInfo(sysFileInfo));
    }

    /**
     * 删除文件管理
     */
    @PreAuthorize("@ss.hasPermi('cms:fileInfo:remove')")
    @Log2(title = "文件管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{fileIds}")
    public AjaxResult remove(@PathVariable Long[] fileIds)
    {
        return toAjax(sysFileInfoService.deleteSysFileInfoByFileIds(fileIds));
    }
}
