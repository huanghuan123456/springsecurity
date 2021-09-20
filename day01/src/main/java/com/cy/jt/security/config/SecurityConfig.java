package com.cy.jt.security.config;

import com.cy.jt.security.handler.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.servlet.http.HttpServletResponse;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(http);
        //1.关闭跨域攻击
        http.csrf().disable();
        //2.配置登录url(登录表单使用哪个页面)
        http.formLogin()
                .loginPage("/login.html")//登录页面
                .loginProcessingUrl("/login")//与form表单中的action值相同
                .usernameParameter("username")//与form表单中input元素的name属性相同
                .passwordParameter("password")
                //.successHandler(new RedirectAuthenticationSuccessHandler("https://www.baidu.com"));
                .defaultSuccessUrl("/index.html")
                //.successHandler(new DefaultAuthenticationSuccessHandler())
        .failureHandler(new DefaultAuthenticationFailureHandler());//登录成功的url,请求重定向
        http.logout().logoutUrl("login").logoutSuccessUrl("/index.html?logout");
        http.exceptionHandling().authenticationEntryPoint(new DefaultAuthenticationEntryPoint())
                .accessDeniedHandler(new DefaultAccessDeniedExceptionHandler());
        http.authorizeRequests()
                .antMatchers("/login.html", "/images/**")//这里写你要放行的资源
                .permitAll()//运行访问
                .anyRequest().authenticated();//除了以上的资源必须认证才可以访问
    }
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
