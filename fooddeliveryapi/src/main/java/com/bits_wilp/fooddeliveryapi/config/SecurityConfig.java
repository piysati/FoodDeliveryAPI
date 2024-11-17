package com.bits_wilp.fooddeliveryapi.config;

import jakarta.servlet.Filter;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.csrf().disable().authorizeHttpRequests().anyRequest().authenticated().and()
//                .httpBasic();
//
//        return http.build();
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/api/customers/register", "/api/customers/login").permitAll() // Public endpoints
//                .antMatchers("/api/admin/**").hasRole("ADMIN") // Only admin can access
//                .antMatchers("/api/owners/**").hasRole("OWNER") // Only restaurant owners can access
//                .antMatchers("/api/delivery/**").hasRole("DELIVERY_PERSONNEL") // Delivery personnel access
//                .anyRequest().authenticated() // Other requests need authentication
//                .and()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS); // Stateless session
//
//        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
//    }
//    @Autowired
//    private CustomUserDetailsServiceImpl userDetailsService;
//
//    @Autowired
//    private JwtAuthenticationFilter jwtAuthenticationFilter;
//
//    @Autowired
//    private JWTAuthenticationEntryPoint authenticationEntryPointpoint;
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
//        return builder.getAuthenticationManager();
//    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//
//        http.csrf(csrf -> csrf.disable())
//                .authorizeRequests()
//                .antMatchers("/api/customers/**").hasRole("CUSTOMER")
//                .antMatchers("/api/restaurants/**").hasRole("RESTAURANT_OWNER")
//                .antMatchers("/api/admin/**").hasRole("ADMIN")
//                .anyRequest().authenticated();
//                .requestMatchers("/test").authenticated()
//                .requestMatchers("/auth/login").permitAll()
//                .anyRequest().authenticated()
//                .and().exceptionHandling(ex -> ex.authenticationEntryPoint(authenticationEntryPointpoint))
//                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//
//        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
//        return http.build();
//    }



//    @Override
//    public boolean matches(HttpServletRequest request) {
//        return false;
//    }
//
//    @Override
//    public List<Filter> getFilters() {
//        return List.of();
//    }

//        @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//    }
}

