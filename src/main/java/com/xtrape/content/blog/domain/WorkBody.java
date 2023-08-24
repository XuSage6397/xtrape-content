package com.xtrape.content.blog.domain;

import com.alibaba.nacos.shaded.com.google.gson.JsonObject;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class WorkBody {

    JsonObject edit;

    JsonObject show;

    String text;

}
