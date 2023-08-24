package com.xtrape.content.blog.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.xtrape.common.core.annotation.Excel;
import com.xtrape.content.tag.domain.CmsTag;
import com.xtrape.content.type.domain.CmsType;
import lombok.Data;
import lombok.experimental.Accessors;
import nonapi.io.github.classgraph.json.Id;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.xtrape.common.core.domain.BaseEntity;

import java.util.List;

/**
 * 文章管理对象 cms_blog
 *
 * @author ning
 * @date 2022-01-01
 */
@Data
@Accessors(chain = true)
public class CmsBlog extends BaseEntity {

    private static final long serialVersionUID = 1L;

    String cat;

    String notes;
    /**
     * ID
     */
    @TableId
    private String id;

    /**
     * 标题
     */
    @Excel(name = "标题")
    private String title;

    /**
     * 类型 1文章 2随笔
     * todo: remove, replaced by pattern
     */
    @Excel(name = "类型")
    private String type;


    /**
     * 内容
     */
    @Excel(name = "内容")
    private String content;

    /**
     * 文本编辑器类型 1 Quill富文本编辑器 2 CherryMarkdown
     */
    @Excel(name = "文本编辑器类型")
    private String contentType;

    /**
     * Markdown格式内容
     */
    @Excel(name = "Markdown格式内容")
    private String contentMarkdown;

    /**
     * 置顶（0否 1是）
     */
    @Excel(name = "置顶", readConverterExp = "0=否,1=是")
    private String top;

    /**
     * 阅读
     */
    @Excel(name = "阅读")
    private Long views;

    /**
     * 状态（0暂存 1发布）
     */
    @Excel(name = "状态", readConverterExp = "0=暂存,1=发布")
    private String status;

    /**
     * 首页图片类型（0地址 1上传）
     */
    @Excel(name = "首页图片类型", readConverterExp = "0=地址,1=上传")
    private String blogPicType;

    /** 首页图片（ 1上传） */
    @Excel(name = "首页图片（ 1上传）")
    private String blogPic;

    /** 首页图片（ 0地址） */
    @Excel(name = "首页图片（ 0地址）")
    private String blogPicLink;

    /** 简介 */
    @Excel(name = "简介")
    private String blogDesc;

    /** 附件列表 */
    private String blogFiles;

    String script;

    String dialect;

    String pattern;

    /**
     * 分类
     */
    private String[] typeIds;

    /**
     * 分类
     */
    private String[] tagIds;

    /** 角色对象 */
    private List<CmsTag> tags;

    /** 角色对象 */
    private List<CmsType> types;

}
