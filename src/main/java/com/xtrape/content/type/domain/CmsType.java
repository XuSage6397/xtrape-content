package com.xtrape.content.type.domain;

import com.xtrape.common.core.annotation.Excel;
import lombok.Data;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.xtrape.common.core.domain.BaseEntity;

/**
 * 分类管理对象 cms_type
 * 
 * @author ning
 * @date 2022-01-02
 */
@Data
@Accessors(chain = true)
public class CmsType extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 分类ID */
    private String typeId;

    /** 分类名称 */
    @Excel(name = "分类名称")
    private String typeName;

    /**
     * 分类图像类型（0地址 1上传）
     */
    @Excel(name = "分类图像类型（0地址 1上传）", readConverterExp = "0=地址,1=上传")
    private String typePicType;

    /** 分类图像（ 1上传） */
    @Excel(name = "分类图像（ 1上传）")
    private String typePic;

    /** 分类图像（ 0地址） */
    @Excel(name = "分类图像（ 0地址）")
    private String typePicLink;

    /** 博客数量 */
    private int blogNum;


}
