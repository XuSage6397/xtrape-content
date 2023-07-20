package com.xtrape.content.comment.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xtrape.content.comment.domain.CmsCommentLike;

import java.util.List;

/**
 * @program: xtrape-Vue
 * @Author: WangNing
 * @Description: 〈${DESCRIPTION}〉
 * @Date: 2022/1/22 20:08
 */
public interface CmsCommentLikeMapper extends BaseMapper<CmsCommentLike> {
    /**
     * 查询列表
     */
    public List<CmsCommentLike> selectCmsCommentLikeList(CmsCommentLike cmsCommentLike);
    /**
     * 新增
     */
    public int addCmsCommentLike(CmsCommentLike cmsCommentLike);
    /**
     * 删除关联
     */
    public int deleteCmsCommentLike(CmsCommentLike cmsCommentLike);
}
