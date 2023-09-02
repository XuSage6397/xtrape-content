package com.xtrape.content.blog.domain;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class CmsBlogSearch {

    String title;

    Long[] ids;

    String[] cats;

    String[] dialects;

    int[] types;

    int[] statuses;

    Integer[] tops;
}
