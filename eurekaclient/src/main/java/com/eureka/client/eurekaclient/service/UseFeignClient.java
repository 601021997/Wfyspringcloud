package com.eureka.client.eurekaclient.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author WFY
 */
@FeignClient(name = "discovery-service-eurekaServer1")
public interface UseFeignClient {

    /**
     * 获取到用户
     * @param id
     */
    @GetMapping("/getUser/{id}")
    public void getUser(@PathVariable Integer id);

}
