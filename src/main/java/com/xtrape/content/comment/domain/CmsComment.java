package com.xtrape.content.comment.domain;

import lombok.Data;
import lombok.experimental.Accessors;
import com.xtrape.common.core.annotation.Excel;
import com.xtrape.common.core.web.domain.BaseEntity;

import java.util.List;

/**
 * 评论管理对象 cms_comment
 * 
 * @author ning
 * @date 2022-01-21
 */
@Data
@Accessors(chain = true)
public class CmsComment extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private String id;

    /** 父评论id */
    @Excel(name = "父评论id")
    private String parentId;

    /** 主评论id(第一级评论) */
    @Excel(name = "主评论id(第一级评论)")
    private String mainId;

    /** 点赞数量 */
    @Excel(name = "点赞数量")
    private Long likeNum;

    /** 内容 */
    @Excel(name = "内容")
    private String content;

    /** 评论类型：对人评论，对项目评论，对资源评论 */
    @Excel(name = "评论类型：对人评论，对项目评论，对资源评论")
    private String type;

    /** 被评论者id，可以是人、项目、资源 */
    @Excel(name = "被评论者id，可以是人、项目、资源")
    private String blogId;

    /** 文章标题 */
    private String blogTitle;

    /** 删除标志（0代表存在 1代表删除） */
    private String delFlag;

    /** 评论者id */
    @Excel(name = "评论者id")
    private String userId;

    /** 头像 */
    private String avatar;

    String email;

    /** 回复 */
    private List<CmsComment> children;

    /** 父留言者 */
    private String pCreateBy;

    /** 点赞 */
    private Boolean isLike;

}
