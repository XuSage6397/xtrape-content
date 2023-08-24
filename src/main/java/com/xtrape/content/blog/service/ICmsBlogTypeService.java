package com.xtrape.content.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xtrape.content.blog.domain.CmsBlogType;

import java.util.List;

/**
 * @program: xtrape-Vue
 * @Author: WangNing
 * @Description: 〈${DESCRIPTION}〉
 * @Date: 2022/1/2 23:42
 */
public interface ICmsBlogTypeService extends IService<CmsBlogType> {
    /**
     * 批量新增
     */
    public int batchBlogType(List<CmsBlogType> blogTypeList);
    /**
     * 通过blogID删除blog分类关联
     */
    public int deleteBlogTypeByBlogId(String blogId);
    /**
     * 批量删除blog分类关联
     */
    public int deleteBlogType(String[] ids);
    /**
     * 查询分类列表
     */
    public List<CmsBlogType> selectBlogTypeList(String blogId);
}
