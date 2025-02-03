package com.example.demo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

        @Autowired
        private UserDetailsService userDetailsService;
        
	@Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
                return http.authorizeHttpRequests(auth -> auth
                .requestMatchers("/","/login","/error", "/fragments/**").permitAll()
                        .requestMatchers("/")
                        .hasRole("ADMIN").anyRequest().authenticated())
                        .formLogin(form -> form.loginPage("/login")
                                .defaultSuccessUrl("/clientes", true)
                                .failureUrl("/login?error")
                                .permitAll()).logout(logout -> logout.logoutSuccessUrl("/").permitAll()).build();
                
        }

        @Autowired
        public void configureGlobal(AuthenticationManagerBuilder build) throws Exception{
                build.userDetailsService(userDetailsService).passwordEncoder(new
                BCryptPasswordEncoder());
        }
}
