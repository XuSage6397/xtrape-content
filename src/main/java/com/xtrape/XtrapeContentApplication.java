package com.xtrape;

import com.xtrape.common.security.annotation.EnableCustomConfig;
import com.xtrape.common.security.annotation.EnableRyFeignClients;
import com.xtrape.common.swagger.annotation.EnableCustomSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * 系统模块
 *
 * @author xtrape
 */
@EnableCustomConfig
@EnableCustomSwagger2
@EnableRyFeignClients
@EnableAsync(proxyTargetClass = true)
@EnableCaching(proxyTargetClass = true)
@SpringBootApplication
public class XtrapeContentApplication {
    public static void main(String[] args) {
        SpringApplication.run(XtrapeContentApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  Xtrape Content Started   ლ(´ڡ`ლ)ﾞ ");
    }
}
