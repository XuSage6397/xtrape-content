package com.xtrape.content.blog.service.impl;
/**
 * @program: xtrape-Vue
 * @Author: WangNing
 * @Description: 〈〉
 * @Date: 2022/1/2 23:24
 */

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xtrape.content.blog.domain.CmsBlog;
import com.xtrape.content.blog.domain.CmsBlogTag;
import com.xtrape.content.blog.mapper.CmsBlogMapper;
import com.xtrape.content.blog.mapper.CmsBlogTagMapper;
import com.xtrape.content.blog.service.ICmsBlogTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: WangNing
 * @Description:〈〉
 * @Date: 2022/1/2 23:24
 **/
@Service
public class CmsBlogTagServiceImpl extends ServiceImpl<CmsBlogTagMapper, CmsBlogTag> implements ICmsBlogTagService {

//    @Autowired
//    CmsBlogTagMapper cmsBlogTagMapper;

    @Override
    public int batchBlogTag(List<CmsBlogTag> blogTagList) {
        return baseMapper.batchBlogTag(blogTagList);
    }

    @Override
    public int deleteBlogTagByBlogId(String blogId) {
        return baseMapper.deleteBlogTagByBlogId(blogId);
    }

    @Override
    public int deleteBlogTag(String[] ids) {
        return baseMapper.deleteBlogTag(ids);
    }

    @Override
    public List<CmsBlogTag> selectBlogTagList(String blogId) {
        return baseMapper.selectBlogTagList(blogId);
    }
}
