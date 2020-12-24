package controller.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author ：huadong.chen
 * @ProjectName: controller$
 * @Package: controller.config$
 * @ClassName: SecurityConfig$
 * @date ：Created in 12/24/20 3:51 PM
 * @description：自定义权限认证配置
 * @modified By：
 * @version: 1.01
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/user/**").hasRole("user")
                .antMatchers("/user1/**").hasRole("user1");

    }
}