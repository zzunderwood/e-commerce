package com.zz.ecommerce.service;

import com.zz.ecommerce.vo.UsernameAndPassword;

/**
 *  JWT相关服务接口定义
 * @Author zz
 * @Version 1.0
 * @Date 2023/6/15 00:39
 */
public interface IJWTService {
    /**
     * 生成JWT token,使用默认的超时时间
     * @param username
     * @param password
     * @return
     * @throws Exception
     */
    String generateToken(String username, String password) throws Exception;

    /**
     * 指定超时时间 单位天
     * @param username
     * @param password
     * @param expire
     * @return
     * @throws Exception
     */
    String generateToken(String username, String password, int expire) throws Exception;


    /**
     * 注册用户并生成token
     */
    String registerUserAndGenerateToken(UsernameAndPassword usernameAndPassword) throws Exception;


}
