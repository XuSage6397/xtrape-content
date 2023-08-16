package com.xtrape.content.blog.domain;
/**
 * @program: xtrape-Vue
 * @Author: WangNing
 * @Description: 〈blog标签关联表 cms_blog_tag〉
 * @Date: 2022/1/2 22:54
 */

import lombok.Data;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @Author: WangNing
 * @Description:〈blog标签关联表 cms_blog_tag〉
 * @Date: 2022/1/2 22:54
 **/
@Data
@Accessors(chain = true)
public class CmsBlogTag {
    private String tagId;
    private String blogId;
    private String[] tagIds;

}
