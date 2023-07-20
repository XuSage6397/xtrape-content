package com.xtrape.content.fileInfo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xtrape.content.fileInfo.domain.FileBlogInfo;

import java.util.List;

/**
 * @program: xtrape-Vue
 * @Author: WangNing
 * @Description: 〈blog文件关联 数据层〉
 * @Date: 2022/1/2 0:48
 */
public interface FileBlogInfoMapper extends BaseMapper<FileBlogInfo> {
    /**
     * 批量新增
     */
    public int batchFileBlog(List<FileBlogInfo> fileBlogList);
    /**
     * 通过blogID删除blog文件关联
     */
    public int deleteFileBlogByBlogId(Long blogId);
    /**
     * 批量删除blog文件关联
     */
    public int deleteFileBlog(Long[] ids);
    /**
     * 查询文件列表
     */
    public List<FileBlogInfo> selectFileBlogList(Long blogId);
}
