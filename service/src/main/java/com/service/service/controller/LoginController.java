package com.service.service.controller;

import com.service.service.config.ApiUriTemplate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value =ApiUriTemplate.APP_ROOT_PATH,description = "api相关接口")
@RequestMapping("/login")
@Slf4j
public class LoginController {

    //  private static final Logger log = LoggerFactory.getLogger(LoginController.class);

    @ApiOperation("登录相关接口")
    @GetMapping("/login")
    public String login(){
        log.info("这是一个注解");
        return "hahah";
    }

}
