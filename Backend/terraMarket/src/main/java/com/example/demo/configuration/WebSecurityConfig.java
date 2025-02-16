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
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

        @Autowired
        private UserDetailsService userDetailsService;
        
        
        /*
        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
                return http.authorizeHttpRequests(auth -> auth
                .requestMatchers("/","/login","/error", "/fragments/**", "/register",
                "/**").permitAll()
                .requestMatchers("/").hasRole("USER")
                .anyRequest().authenticated())
                .formLogin(form -> form.loginPage("/login")
                .defaultSuccessUrl("/clientes", true)
                .failureUrl("/login?error")
                 .permitAll())
                .logout(logout -> logout.logoutSuccessUrl("/").permitAll())
                .build();
        		/*
                http.csrf(csrf -> csrf.disable())
                                .authorizeHttpRequests(auth -> auth
                                                .requestMatchers("/**").permitAll()
                                               .anyRequest().authenticated());
                                                
                //return http.build();
        }
		
        */
        /*
        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
            http.csrf(csrf -> csrf.disable())  // Desactiva CSRF para facilitar las llamadas a la API (puedes dejarlo habilitado si lo gestionas con tokens)
                .authorizeHttpRequests(auth -> auth
                    .requestMatchers("/**").permitAll()  // Permite todas las rutas (ajusta según tus necesidades)
                    .anyRequest().authenticated())  // Resto de las rutas requieren autenticación
                .cors()  // Habilita CORS
                .and();
            return http.build();
        }

        @Bean
        public CorsConfigurationSource corsConfigurationSource() {
            CorsConfiguration configuration = new CorsConfiguration();
            configuration.addAllowedOrigin("http://localhost:4200");  // Permite solicitudes desde localhost:4200
            configuration.addAllowedMethod("*");  // Permite todos los métodos HTTP (GET, POST, PUT, DELETE)
            configuration.addAllowedHeader("*");  // Permite todos los encabezados
            configuration.setAllowCredentials(true);  // Si necesitas manejar cookies o tokens de autenticación

            UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
            source.registerCorsConfiguration("/**", configuration);  // Aplica a todas las rutas

            return source;
        }
		*/
        
        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
            http
                    .authorizeHttpRequests(authorizeRequests -> authorizeRequests
                            .anyRequest().permitAll() // Permitir acceso sin autenticación a todas las rutas
                    )
                    .csrf(csrf -> csrf.disable()); // Deshabilitar CSRF si no es necesario

            return http.build();
        }
        
        @Autowired
        public void configureGlobal(AuthenticationManagerBuilder build) throws Exception {
            build.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
        }
}
