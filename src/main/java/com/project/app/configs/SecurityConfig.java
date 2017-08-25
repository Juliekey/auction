package com.project.app.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.EmbeddedDataSourceConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;


@Configuration
@EnableWebMvc
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private DataSource dataSource;
    public static final String DEF_USERS_BY_USERNAME_QUERY = "select user_name, password, enabled from users where user_name = ?";
    public static final String DEF_AUTHORITIES_BY_USERNAME_QUERY = "select user_name, role from users where user_name = ?";

//    @Autowired
//    public SecurityConfig(EmbeddedDatabase dataSource) {
//        this.dataSource = dataSource;
//      //  EmbeddedDataSourceConfiguration
//    }

    public void configure(HttpSecurity http) throws Exception {
        http.headers().frameOptions().disable() //for h2 console page to be shown
                .and().formLogin() //default login page
                .and().csrf().disable() //for h2 database
                .authorizeRequests()
//                .antMatchers("/user/**").hasRole("USER")
//                .antMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().permitAll();
        //    .and().requiresChannel(); //for https

    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .jdbcAuthentication()
//                .dataSource(dataSource)
//                .usersByUsernameQuery(DEF_USERS_BY_USERNAME_QUERY)
//                .authoritiesByUsernameQuery(DEF_AUTHORITIES_BY_USERNAME_QUERY)
//                .passwordEncoder(new BCryptPasswordEncoder());
//    }

//    @Primary
//    @Bean
//    @ConfigurationProperties("app.datasource")
//    public DataSource dataSource() {
//    }

}
