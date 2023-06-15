package com.zz.ecommerce.dao;

import com.zz.ecommerce.entity.EcommerceUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author zhaozhen
 * @Version 1.0
 * @Date 2023/6/14 13:16
 */
public interface EcommerceUserDao extends JpaRepository<EcommerceUser, Long> {
    /**
     * 根据 用户名查询 EcommerceUser
     * @param username
     * @return
     */
    EcommerceUser findByUsername(String username);

    EcommerceUser findByUsernameAndPassword(String username, String password);
}
