package com.xtrape.content.tag.domain;

import com.xtrape.common.core.annotation.Excel;
import lombok.Data;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.xtrape.common.core.domain.BaseEntity;

/**
 * 标签管理对象 cms_tag
 * 
 * @author ning
 * @date 2022-01-02
 */
@Data
@Accessors(chain = true)
public class CmsTag extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 标签ID */
    private String tagId;

    /** 标签名称 */
    @Excel(name = "标签名称")
    private String tagName;

    /** 博客数量 */
    private int blogNum;

}
