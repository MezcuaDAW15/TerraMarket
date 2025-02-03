package com.example.demo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

        @Autowired
        private UserDetailsService userDetailsService;
        
	@Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
                http
                .authorizeHttpRequests(requests -> requests
                        .antMatchers("/").permitAll()
                        .antMatchers("/clientes").permitAll()
                        .antMatchers("/fragments/**").permitAll()
                        .antMatchers("/clientes/add/**",
                                "/clientes/delete/**",
                                "/clientes/update/**",
                                "/clientes/save/**").hasRole("ADMIN")
                        .antMatchers("/clientes/{idCliente}/direcciones").hasAnyRole("ADMIN", "USER")
                        .antMatchers("/clientes/{idCliente}/direcciones/add/**",
                                "/clientes/{idCliente}/direcciones/delete/**",
                                "/clientes/{idCliente}/direcciones/update/**",
                                "/clientes/{idCliente}/direcciones/save/**").hasRole("ADMIN")
                        .antMatchers("/clientes/{idCliente}/cuentas").hasAnyRole("ADMIN", "USER")
                        .antMatchers("/clientes/{idCliente}/cuentas/add/**",
                                "/clientes/{idCliente}/cuentas/delete/**",
                                "/clientes/{idCliente}/cuentas/update/**",
                                "/clientes/{idCliente}/cuentas/save/**",
                                "/clientes/{idCliente}/cuentas/**").hasRole("ADMIN")
                        .antMatchers("/newRoute/**").hasRole("NEW_ROLE") // Nueva ruta agregada
                        .anyRequest().authenticated()
                        .and()
                        .formLogin()
                        .loginPage("/login")
                        .defaultSuccessUrl("/clientes")
                        .failureUrl("/login?error")
                        .permitAll()
                        .and()
                        .logout()
                        .permitAll()
                        .logoutSuccessUrl("/")
                        .and()
                        .exceptionHandling().accessDeniedPage("/errors/403"));

                return http.build();
        }


        @Autowired
        public void configureGlobal(AuthenticationManagerBuilder build) throws Exception{
                build.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
        }
}
