package com.xtrape.content.blog.service.impl;
/**
 * @program: xtrape-Vue
 * @Author: WangNing
 * @Description: 〈〉
 * @Date: 2022/1/2 23:44
 */

import com.xtrape.content.blog.domain.CmsBlogType;
import com.xtrape.content.blog.mapper.CmsBlogTypeMapper;
import com.xtrape.content.blog.service.ICmsBlogTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: WangNing
 * @Description:〈〉
 * @Date: 2022/1/2 23:44
 **/
@Service
public class CmsBlogTypeServiceImpl implements ICmsBlogTypeService {

    @Autowired
    CmsBlogTypeMapper cmsBlogTypeMapper;

    @Override
    public int batchBlogType(List<CmsBlogType> blogTypeList) {
        return cmsBlogTypeMapper.batchBlogType(blogTypeList);
    }

    @Override
    public int deleteBlogTypeByBlogId(String blogId) {
        return cmsBlogTypeMapper.deleteBlogTypeByBlogId(blogId);
    }

    @Override
    public int deleteBlogType(String[] ids) {
        return cmsBlogTypeMapper.deleteBlogType(ids);
    }

    @Override
    public List<CmsBlogType> selectBlogTypeList(String blogId) {
        return cmsBlogTypeMapper.selectBlogTypeList(blogId);
    }
}
