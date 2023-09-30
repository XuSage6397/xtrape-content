package com.xtrape.content.anon;

import com.xtrape.common.core.utils.PageUtils;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ListBlogParams implements PageUtils.PageParams {

    String title;

    String genus;
    String dialect;

    Long offset = 0L;
    Integer length = 10;
    Integer top;

    Boolean reasonable;

    String orderBy;
}
