package com.eureka.client.eurekaclient.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author wfy
 */
@RequestMapping("/eureka")
@Slf4j
@RestController
public class LoginController{

    @GetMapping(value = "getUser")
    public String getUser(){
       return "hahha";
    }
}
