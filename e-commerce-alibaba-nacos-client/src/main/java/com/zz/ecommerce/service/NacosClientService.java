package com.zz.ecommerce.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author zhaozhen
 * @Version 1.0
 * @Date 2023/6/7 03:12
 */
@Slf4j
@Service
public class NacosClientService {

    @Autowired
    private DiscoveryClient discoveryClient;

    /**
     * 打印 nacos client 信息到日志中
     * @param serviceId
     * @return
     */
    public List<ServiceInstance> getNacosClientInfo(String serviceId) {
        log.info("request nacos server to get service instance info: [{}] ", serviceId);

        return discoveryClient.getInstances(serviceId);
    }

}
