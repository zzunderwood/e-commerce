package com.zz.ecommerce.service;

import cn.hutool.crypto.digest.MD5;
import com.alibaba.fastjson.JSON;
import com.zz.ecommerce.dao.EcommerceUserDao;
import com.zz.ecommerce.entity.EcommerceUser;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 验证下EcommerceUser 相关的测试
 *
 * @Author zhaozhen
 * @Version 1.0
 * @Date 2023/6/14 13:24
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class EcommerceUserTest {
    @Autowired
    private EcommerceUserDao ecommerceUserDao;

    @Test
    public void createUserRecord() {
        EcommerceUser ecommerceUser = new EcommerceUser();
        ecommerceUser.setUsername("zz@imooc.com");
        ecommerceUser.setPassword(MD5.create().digestHex("12345678"));
        ecommerceUser.setExtraInfo("{}");
        log.info("save user:[{}]",
                JSON.toJSONString(ecommerceUserDao.save(ecommerceUser)));
    }
}
