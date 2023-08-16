package com.xtrape.content.message.domain;
/**
 * @program: xtrape-Vue
 * @Author: WangNing
 * @Description: 〈留言点赞实体类〉
 * @Date: 2022/1/19 8:38
 */

import com.xtrape.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @Author: WangNing
 * @Description:〈留言点赞实体类〉
 * @Date: 2022/1/19 8:38
 **/
@Data
@Accessors(chain = true)
public class CmsMessageLike  extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String messageId;
    private String userId;

    /** 点赞数量 */
    private Long likeNum;


}
