package com.service.config;

import com.service.utils.SocketUtils;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

/**
 * 自启动类之后自动启动
 *
 * @author wufangyu
 */
public class MyApplicationRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {

        //SocketUtils.socketServer();

    }
}
