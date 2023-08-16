package com.xtrape.content.blog.domain;
/**
 * @program: xtrape-Vue
 * @Author: WangNing
 * @Description: 〈blog类型关联表 cms_blog_type〉
 * @Date: 2022/1/2 23:34
 */

import lombok.Data;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @Author: WangNing
 * @Description:〈blog分类关联表 cms_blog_type〉
 * @Date: 2022/1/2 23:34
 **/
@Data
@Accessors(chain = true)
public class CmsBlogType {
    private String typeId;
    private String blogId;
    private String[] typeIds;

}
