package com.xtrape.content.comment.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xtrape.content.comment.domain.CmsComment;
import com.xtrape.content.comment.domain.CmsCommentLike;

/**
 * 评论管理Service接口
 * 
 * @author ning
 * @date 2022-01-21
 */
public interface ICmsCommentService extends IService<CmsComment>
{
    /**
     * 首页查询留言列表
     */
    public List<CmsComment> selectCommentList(CmsComment cmsComment);

    /**
     * 首页新增点赞
     */
    public int addCmsCommentLike(CmsCommentLike cmsCommentLike);

    /**
     * 首页删除点赞
     */
    public int delCmsCommentLike(CmsCommentLike cmsCommentLike);

    /**
     * 查询评论管理
     * 
     * @param id 评论管理主键
     * @return 评论管理
     */
    public CmsComment selectCmsCommentById(String id);

    /**
     * 查询评论管理列表
     * 
     * @param cmsComment 评论管理
     * @return 评论管理集合
     */
    public List<CmsComment> selectCmsCommentList(CmsComment cmsComment);

    /**
     * 新增评论管理
     * 
     * @param cmsComment 评论管理
     * @return 结果
     */
    public int insertCmsComment(CmsComment cmsComment);

    /**
     * 修改评论管理
     * 
     * @param cmsComment 评论管理
     * @return 结果
     */
    public int updateCmsComment(CmsComment cmsComment);

    /**
     * 批量删除评论管理
     * 
     * @param ids 需要删除的评论管理主键集合
     * @return 结果
     */
    public int deleteCmsCommentByIds(Long[] ids);

    /**
     * 删除评论管理信息
     * 
     * @param id 评论管理主键
     * @return 结果
     */
    public int deleteCmsCommentById(Long id);
}
