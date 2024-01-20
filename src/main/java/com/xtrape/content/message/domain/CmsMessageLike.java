package com.xtrape.content.message.domain;
/**
 * @program: xtrape-Vue
 * @Author: WangNing
 * @Description: 〈留言点赞实体类〉
 * @Date: 2022/1/19 8:38
 */

import com.xtrape.common.core.web.domain.BaseEntity2;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author: WangNing
 * @Description:〈留言点赞实体类〉
 * @Date: 2022/1/19 8:38
 **/
@Data
@Accessors(chain = true)
public class CmsMessageLike  extends BaseEntity2 {

    private static final long serialVersionUID = 1L;

    private String messageId;
    private String userId;

    /** 点赞数量 */
    private Long likeNum;


}
