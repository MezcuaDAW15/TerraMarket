package com.example.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
        
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

        @Bean
        public PasswordEncoder passwordEncoder() {
                return PasswordEncoderFactories.createDelegatingPasswordEncoder();
        }

        @Bean
        public UserDetailsService userDetailsService() {
                UserDetails user1 = User.builder()
                                .username("jpperez")
                                .password(passwordEncoder().encode("1234"))
                                .roles("USER")
                                .build();

                UserDetails user2 = User.builder()
                                .username("juan123")
                                .password("secure123")
                                .roles("ADMIN", "USER")
                                .build();
                return new InMemoryUserDetailsManager(user1, user2);
        }
}
