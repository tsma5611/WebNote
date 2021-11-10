package com.example.webnote.config_secure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import static com.example.webnote.models.User.Role.ADMIN;
import static com.example.webnote.models.User.Role.USER;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    //    @Autowired
//    private DataSource dataSource;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        //web.ignoring().antMatchers(HttpMethod.POST, "register/**");
//        web
//                .ignoring()
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .csrf()
//                .disable()
//                //
        http
                .authorizeRequests()
                .antMatchers(
                        "/",
                        "/main",
                        "/registration",
                        "/authorization"
                )
                .permitAll()
//                .antMatchers(HttpMethod.POST, "/**")
//                .permitAll()
                .and()
                //
                .authorizeRequests()
                .antMatchers(
                        "/notes"
                )
                .hasAnyAuthority(
                        USER.name(),
                        ADMIN.name()
                )
                .and()
                .authorizeRequests()
                .antMatchers(
                        "/admin"
                )
                .hasAuthority(
                        ADMIN.name()
                )
                .and()
                //
                .authorizeRequests()
                .antMatchers(
                        "/registration"
                )
                .access(
                        "not (hasAuthority('USER')) and isAuthenticated()"
                )
                .and()
                //
                .formLogin()
                .loginPage(
                        "/authorization"
                )
                .permitAll()
                //
                .and()
                .logout()
                .logoutUrl(
                        "/j_spring_security_logout"
                )
                .logoutSuccessUrl(
                        "/main"
                )
        /*END*/;
    }
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.jdbcAuthentication()
//                .dataSource(dataSource)
//                .passwordEncoder(NoOpPasswordEncoder.getInstance())
//                .usersByUsernameQuery(
//                        "select login, pass, status from notes2_db.users where login=?"
//                );
//    }
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .passwordEncoder(NoOpPasswordEncoder.getInstance())
//                //
//                .withUser("a")
//                .password("p")
//                .roles(ADMIN.name())
//                //
//                .and()
//                .withUser("b")
//                .password("p")
//                .roles(USER.name())
//        /*END*/;
//    }
    //

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(NoOpPasswordEncoder.getInstance());
    }
}
