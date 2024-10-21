package com.CapstoneApp.TitanFit.config;

import com.CapstoneApp.TitanFit.Service.CustomUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private CustomUserService userDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorizeRequests -> authorizeRequests
                        .requestMatchers("/css/**", "/js/**", "/images/**", "/login", "/register").permitAll()  // Public access
                        .requestMatchers("/user/**").hasAnyRole("USER", "ADMIN")  // App User task hub
                        .requestMatchers("/admin/**").hasRole("ADMIN")  // Admin-only access for managing tasks
                        .anyRequest().authenticated())  // All other requests require authentication

                .formLogin(formLogin -> formLogin
                        .loginPage("/login") //Custom login URL
                        .permitAll()
                        .successHandler((request, response, authentication) -> {
                            authentication.getAuthorities().forEach(grantedAuthority -> {
                                String role = grantedAuthority.getAuthority();
                                try {
                                    if (role.equals("ROLE_ADMIN")) {
                                        response.sendRedirect("/admin");  // Admin redirect
                                    } else if (role.equals("ROLE_USER")) {
                                        response.sendRedirect("/user");  // Users redirect
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            });
                        }))
                .logout( logout ->logout
                        .logoutSuccessUrl("/login")
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID")
                        .permitAll())
                        .userDetailsService(userDetailsService);
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}