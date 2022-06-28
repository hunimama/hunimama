package com.hkt.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

/**
 * @author 794073612@qq.com
 * @time 15:45 2022/6/11
 **/
@Configuration
public class SecurityConfigTest extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;
    //注入数据源
    @Autowired
    private DataSource dataSource;

    //配置对象
    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource);
//        jdbcTokenRepository.setCreateTableOnStartup(true);
        return jdbcTokenRepository;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(password());
    }

    @Bean
    PasswordEncoder password() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.exceptionHandling().accessDeniedPage("/unauth.html");
        http.formLogin()    //自定义自己编写的登录页面
                .loginPage("/login.html")   //登录页面设置
                .loginProcessingUrl("/user/login")    //登录访问路径
                .defaultSuccessUrl("/test/index").permitAll()    //登录成功之后，跳转路径
                .and().authorizeRequests()
                .antMatchers("/", "/test/hello", "/user/login").permitAll()   //设置那些路径可以直接访问，不需要认证
//                .antMatchers("/test/index").hasAuthority("admins,manager")  //当前登录用户，只有具有admins权限才可以访问这个路径
//                .antMatchers("/test/index").hasAnyAuthority("admins,manager")
                .antMatchers("test/index").hasRole("sale")
                .anyRequest().authenticated()
                .and().rememberMe().tokenRepository(persistentTokenRepository())
                .tokenValiditySeconds(60) //设置有效时长，单位秒
                .userDetailsService(userDetailsService)
                .and().csrf().disable();    //关闭csrf防护
    }
}
