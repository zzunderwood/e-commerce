package com.zz.ecommerce.conf;

import de.codecentric.boot.admin.server.config.AdminServerProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

/**
 * 配置安全认证，以便其他的微服务可以注册
 * 参考spring security 官方文档
 *
 * @Author zhaozhen
 * @Version 1.0
 * @Date 2023/6/7 22:09
 */
@Configuration
public class SecuritySecureConfig extends WebSecurityConfigurerAdapter {
    /**
     * 应用上下文路径
     */
    private final String adminContextPath;

    public SecuritySecureConfig(AdminServerProperties adminServerProperties) {
        this.adminContextPath = adminServerProperties.getContextPath();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        SavedRequestAwareAuthenticationSuccessHandler successHandler =
                new SavedRequestAwareAuthenticationSuccessHandler();
        successHandler.setTargetUrlParameter("redirectTo");
        successHandler.setDefaultTargetUrl(adminContextPath + "/");

        http.authorizeRequests()
                //1.配置所有的静态资源和登陆页可以访问到
                .antMatchers(adminContextPath + "/assets/** ").permitAll()
                .antMatchers(adminContextPath + "/login").permitAll()
                //2.其他请求必须要经过认证
                .anyRequest().authenticated()
                .and()
                //3.配置登陆登出路径
                .formLogin().loginPage(adminContextPath + "/login").successHandler(successHandler)
                .and()
                .logout().logoutUrl(adminContextPath + "/logout")
                .and()
                //4.开启http basic 支持，其他的服务模块注册时需要使用
                .httpBasic()
                .and()
                //5.开启基于cookie的 csrf保护
                .csrf()
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                //6.忽略这些路径的csrf保护，以便其他的模块可以实现注册
                .ignoringAntMatchers(
                        adminContextPath + "/instances",
                        adminContextPath + "/actuator/**"
                );
    }

}
