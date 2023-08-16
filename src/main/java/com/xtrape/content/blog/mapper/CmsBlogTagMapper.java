package com.xtrape.content.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xtrape.content.blog.domain.CmsBlogTag;
import com.xtrape.content.blog.domain.CmsBlogType;

import java.util.List;

/**
 * @program: xtrape-Vue
 * @Author: WangNing
 * @Description: 〈blog标签关联 数据层〉
 * @Date: 2022/1/2 23:12
 */
public interface CmsBlogTagMapper extends BaseMapper<CmsBlogTag> {
    /**
     * 批量新增
     */
    public int batchBlogTag(List<CmsBlogTag> blogTagList);
    /**
     * 通过blogID删除blog文件关联
     */
    public int deleteBlogTagByBlogId(String blogId);
    /**
     * 批量删除blog文件关联
     */
    public int deleteBlogTag(String[] ids);
    /**
     * 查询文件列表
     */
    public List<CmsBlogTag> selectBlogTagList(String blogId);
    /**
     * 通过tagId删除blog文件关联
     */
    public int deleteBlogTagByTagId(String tagId);
    /**
     * 通过tagId统计blog数量
     */
    public int countBlogByTagId(String tagId);
}
