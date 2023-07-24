package com.xtrape.content.feign;


import com.xtrape.common.core.web.domain.AjaxResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "${xtrape.module.system}")
public interface SystemFeignService {

    @RequestMapping("/role/listMnemonicByMemberPortal")
    AjaxResult listMnemonicByMemberPortal();

}
