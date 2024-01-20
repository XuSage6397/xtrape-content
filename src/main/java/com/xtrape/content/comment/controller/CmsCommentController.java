package com.xtrape.content.comment.controller;

import java.util.List;

import com.xtrape.common.core.web.domain.R;
import com.xtrape.common.core.web.page.PaginationEntity;
import com.xtrape.context.XtrapeContextHolder;
import jakarta.servlet.http.HttpServletResponse;

import com.xtrape.common.core.annotation.Log2;
import com.xtrape.common.core.enums.BusinessType;
import com.xtrape.common.core.utils.poi.ExcelUtil;
import com.xtrape.common.security.web.controller.BaseController;
import com.xtrape.common.core.web.page.TableDataInfo;
import com.xtrape.content.comment.domain.CmsCommentLike;
import com.xtrape.content.comment.service.ICmsCommentService;
import com.xtrape.system.service.ISysPermissionService;
import org.springframework.http.HttpHeaders;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.xtrape.common.core.web.domain.AjaxResult;
import com.xtrape.content.comment.domain.CmsComment;

/**
 * 评论管理Controller
 * 
 * @author ning
 * @date 2022-01-21
 */
@RestController
@RequestMapping("/comment")
public class CmsCommentController extends BaseController
{
    @Autowired
    private ICmsCommentService cmsCommentService;

    @Autowired
    private ISysPermissionService permissionService;


    /**
     * 首页查询评论列表
     */
    @GetMapping("/list")
    public TableDataInfo cmsList(CmsComment cmsComment)
    {
        startPage();
        List<CmsComment> list = cmsCommentService.selectCommentList(cmsComment);
        TableDataInfo tableDataInfo = new TableDataInfo();
        return getDataTable(list);
    }

    /**
     * 首页新增评论
     */
    @PostMapping("/addComment")
    public AjaxResult addComment(@RequestBody CmsComment cmsComment, @RequestHeader HttpHeaders headers) {
        String portal = headers.getFirst(XtrapeContextHolder.HEADER_KEY_PORTAL);
        String member = headers.getFirst(XtrapeContextHolder.HEADER_KEY_MEMBER);
        cmsComment.setType("0");
        cmsComment.setUserId(member);
        String parentId = cmsComment.getParentId();
        if (parentId!=null){
            CmsComment comment = cmsCommentService.selectCmsCommentById(parentId);
            if (comment.getMainId()!=null){
                cmsComment.setMainId(comment.getMainId());
            }else {
                cmsComment.setMainId(parentId);
            }
        }
        return toAjax(cmsCommentService.insertCmsComment(cmsComment));
    }

    /**
     * 首页新增点赞
     */
    @PostMapping("/cms/addCmsCommentLike")
    public AjaxResult addCmsCommentLike(@RequestBody CmsCommentLike cmsCommentLike)
    {
        return toAjax(cmsCommentService.addCmsCommentLike(cmsCommentLike));
    }

    /**
     * 首页删除点赞
     */
    @Log2(title = "删除评论点赞", businessType = BusinessType.DELETE)
    @PostMapping("/cms/delCmsCommentLike")
    public AjaxResult delCmsCommentLike(@RequestBody CmsCommentLike cmsCommentLike)
    {
        return toAjax(cmsCommentService.delCmsCommentLike(cmsCommentLike));
    }



    /**
     * 导出评论管理列表
     */
    @PreAuthorize("@ss.hasPermi('cms:comment:export')")
    @Log2(title = "评论管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CmsComment cmsComment)
    {
        List<CmsComment> list = cmsCommentService.selectCmsCommentList(cmsComment);
        ExcelUtil<CmsComment> util = new ExcelUtil<CmsComment>(CmsComment.class);
        util.exportExcel(response, list, "评论管理数据");
    }

    /**
     * 获取评论管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('cms:comment:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(cmsCommentService.selectCmsCommentById(id));
    }

    /**
     * 新增评论管理
     */
    @PreAuthorize("@ss.hasPermi('cms:comment:add')")
    @Log2(title = "评论管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CmsComment cmsComment)
    {
        return toAjax(cmsCommentService.insertCmsComment(cmsComment));
    }

    /**
     * 修改评论管理
     */
    @PreAuthorize("@ss.hasPermi('cms:comment:edit')")
    @Log2(title = "评论管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CmsComment cmsComment)
    {
        return toAjax(cmsCommentService.updateCmsComment(cmsComment));
    }

    /**
     * 删除评论管理
     */
    @PreAuthorize("@ss.hasPermi('cms:comment:remove')")
    @Log2(title = "评论管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(cmsCommentService.deleteCmsCommentByIds(ids));
    }
}
