package com.zz.ecommerce.controller;

import com.zz.ecommerce.service.NacosClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * nacos client controller
 *
 * @Author zhaozhen
 * @Version 1.0
 * @Date 2023/6/7 03:35
 */
@RestController
@Slf4j
@RequestMapping("/nacos-client")
public class NacosClientController {

    @Autowired
    private NacosClientService nacosClientService;


    /**
     * 根据serviceId获取服务实例信息
     * @param serviceId
     * @return
     */
    @GetMapping("/service-instance")
    public List<ServiceInstance> logNacosClientInfo(
            @RequestParam(defaultValue = "e-commerce-nacos-client") String serviceId) {
        log.info("coming in log nacos client info: [{}]", serviceId);
        return nacosClientService.getNacosClientInfo(serviceId);
    }

}
