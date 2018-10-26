package com.api.api.Utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;

/**
 * 自启动类之后自动启动
 * @author wufangyu
 */
@Slf4j
@Component
public class MyApplicationRunner implements ApplicationRunner {

    @Autowired
    private static HttpServletResponse response;

    @Override
    public void run(ApplicationArguments args) throws Exception {

      log.info("api-spring-boot开始启动");
       //SocketUtils.socketServer(response);

    }

}
