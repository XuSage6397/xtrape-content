package com.xtrape.content.blog.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xtrape.content.blog.domain.CmsBlog;
import com.xtrape.content.blog.domain.CmsBlogSearch;
import com.xtrape.system.entry.EntrySchema;

/**
 * 文章管理Service接口
 * 
 * @author ning
 * @date 2022-01-01
 */
public interface ICmsBlogService extends IService<CmsBlog>
{
    /**
     * 查询文章管理
     * 
     * @param id 文章管理主键
     * @return 文章管理
     */
    public CmsBlog selectCmsBlogById(String id);

    /**
     * 查询文章管理列表
     * 
     * @param cmsBlog 文章管理
     * @return 文章管理集合
     */
    public List<CmsBlog> selectCmsBlogList(CmsBlog cmsBlog);

    List<CmsBlog> inquire(CmsBlogSearch blogSearch);

    /**
     * 查询推荐文章列表
     */
    public List<CmsBlog> selectCmsBlogListRecommend(CmsBlog cmsBlog);

    /**
     * 按分类查询文章列表
     */
    public List<CmsBlog> selectCmsBlogListByTypeId(String id);

    /**
     * 按标签查询文章列表
     */
    public List<CmsBlog> selectCmsBlogListByTagId(String id);

    /**
     * 新增文章管理
     * 
     * @param cmsBlog 文章管理
     * @return 结果
     */
    public String insertCmsBlog(CmsBlog cmsBlog);

    /**
     * 修改文章管理
     * 
     * @param cmsBlog 文章管理
     * @return 结果
     */
    public int updateCmsBlog(CmsBlog cmsBlog);

    /**
     * 批量删除文章管理
     * 
     * @param ids 需要删除的文章管理主键集合
     * @return 结果
     */
    public int deleteCmsBlogByIds(String[] ids);

    /**
     * 删除文章管理信息
     * 
     * @param id 文章管理主键
     * @return 结果
     */
    public int deleteCmsBlogById(String id);
}
