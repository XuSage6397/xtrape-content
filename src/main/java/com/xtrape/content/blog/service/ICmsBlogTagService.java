package com.xtrape.content.blog.service;

import com.xtrape.content.blog.domain.CmsBlogTag;

import java.util.List;

/**
 * @program: xtrape-Vue
 * @Author: WangNing
 * @Description: 〈${DESCRIPTION}〉
 * @Date: 2022/1/2 23:22
 */
public interface ICmsBlogTagService {
    /**
     * 批量新增
     */
    public int batchBlogTag(List<CmsBlogTag> blogTagList);
    /**
     * 通过blogID删除blog标签关联
     */
    public int deleteBlogTagByBlogId(String blogId);
    /**
     * 批量删除blog标签关联
     */
    public int deleteBlogTag(String[] ids);
    /**
     * 查询标签列表
     */
    public List<CmsBlogTag> selectBlogTagList(String blogId);
}
