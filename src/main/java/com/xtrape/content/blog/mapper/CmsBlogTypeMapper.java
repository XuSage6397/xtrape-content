package com.xtrape.content.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xtrape.content.blog.domain.CmsBlogType;

import java.util.List;

/**
 * @program: xtrape-Vue
 * @Author: WangNing
 * @Description: 〈blog分类关联 数据层〉
 * @Date: 2022/1/2 23:37
 */
public interface CmsBlogTypeMapper extends BaseMapper<CmsBlogType> {
    /**
     * 批量新增
     */
    public int batchBlogType(List<CmsBlogType> blogTypeList);
    /**
     * 通过blogID删除blog文件关联
     */
    public int deleteBlogTypeByBlogId(String blogId);
    /**
     * 批量删除blog文件关联
     */
    public int deleteBlogType(String[] ids);
    /**
     * 查询博客列表
     */
    public List<CmsBlogType> selectBlogTypeList(String blogId);
    /**
     * 通过typeId删除blog文件关联
     */
    public int deleteBlogTypeByTypeId(String typeId);
    /**
     * 通过typeId统计blog数量
     */
    public int countBlogByTypeId(String typeId);
}
