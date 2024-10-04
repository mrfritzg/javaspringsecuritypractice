package com.example.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain (HttpSecurity http) throws Exception{
        http.authorizeRequests(
                (authorize) -> authorize
                .anyRequest()
                .authenticated())
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public UserDetailsService users() {
        UserDetails user = User.builder()
                .username("samm")
                .password("{bcrypt}$2a$12$OrJ4N2G.whqQQD44eAqgwOeffgmGkl49dYa2mRUDk7UAApUA8blcO")
                .roles("USER")
                .build();

        UserDetails user2 = User.builder()
                .username("jeff")
                .password("{bcrypt}$2a$12$OrJ4N2G.whqQQD44eAqgwOeffgmGkl49dYa2mRUDk7UAApUA8blcO")
                .roles("USER", "ADMIN")
                .build();



//        return new InMemoryUserDetailsManager(user,user2);
    }

}
