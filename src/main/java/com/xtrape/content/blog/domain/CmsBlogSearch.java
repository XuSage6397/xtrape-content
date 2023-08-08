package com.xtrape.content.blog.domain;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class CmsBlogSearch {

    Long[] ids;

    String[] types;

    int[] statuses;
}
