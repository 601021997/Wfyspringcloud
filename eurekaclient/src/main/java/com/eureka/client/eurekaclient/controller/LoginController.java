package com.eureka.client.eurekaclient.controller;

import com.eureka.client.eurekaclient.service.UseFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author wfy
 */
@RequestMapping("/eureka")
@Slf4j
@RestController
public class LoginController{

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private UseFeignClient useFeignClient;

    @GetMapping(value = "getUser")
    public String getUser(){
       return "hahha";
    }


    @GetMapping("/log-use-instance")
    public void logUseInstance(){
        ServiceInstance serviceInstance  = this.loadBalancerClient.choose("选择当前下的哪个节点");
        useFeignClient.getUser(1);
        log.info(serviceInstance.getHost()+"-------"+serviceInstance.getPort()+"-------"+serviceInstance.getServiceId());
    }
}
