package com.xtrape.content.message.domain;

import com.xtrape.common.core.annotation.Excel;
import lombok.Data;
import lombok.experimental.Accessors;
import com.xtrape.common.core.web.domain.BaseEntity2;

import java.util.List;

/**
 * 留言管理对象 cms_message
 * 
 * @author ning
 * @date 2022-01-15
 */
@Data
@Accessors(chain = true)
public class CmsMessage extends BaseEntity2
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private String id;

    /** 父留言id */
    @Excel(name = "父留言id")
    private String parentId;

    /** 主留言id(第一级留言) */
    @Excel(name = "主留言id(第一级留言)")
    private String mainId;

    /** 点赞数量 */
    @Excel(name = "点赞数量")
    private Long likeNum;

    /** 内容 */
    @Excel(name = "内容")
    private String content;

    /** 留言类型：（0代表留言 1代表回复） */
    @Excel(name = "留言类型：（0代表留言 1代表回复）")
    private String type;

    /** 被留言者id，可以是人、项目、资源 */
    @Excel(name = "被留言者id，可以是人、项目、资源")
    private String blogId;

    /** 留言者id */
    @Excel(name = "留言者id")
    private String userId;

    /** 删除标志（0代表存在 1代表删除） */
    @Excel(name = "删除标志（0代表存在 1代表删除）")
    private String delFlag;

    /** 头像 */
    private String avatar;

    /** 回复 */
    private List<CmsMessage> children;

    /** 父留言者 */
    private String pCreateBy;

    /** 点赞 */
    private Boolean isLike;

}
