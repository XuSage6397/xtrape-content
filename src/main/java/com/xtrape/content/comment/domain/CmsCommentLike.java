package com.xtrape.content.comment.domain;
/**
 * @program: xtrape-Vue
 * @Author: WangNing
 * @Description: 〈評論點贊实体类〉
 * @Date: 2022/1/22 17:48
 */

import com.xtrape.common.core.web.domain.BaseEntity;
import lombok.Data;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @Author: WangNing
 * @Description:〈評論點贊实体类〉
 * @Date: 2022/1/22 17:48
 **/
@Data
@Accessors(chain = true)
public class CmsCommentLike  extends BaseEntity {
    private static final long serialVersionUID = 1L;

    private String commentId;
    private String userId;

    /** 点赞数量 */
    private Long likeNum;

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(Long likeNum) {
        this.likeNum = likeNum;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("commentId", getCommentId())
                .append("userId", getUserId())
                .append("likeNum", getLikeNum())
                .toString();
    }
}
