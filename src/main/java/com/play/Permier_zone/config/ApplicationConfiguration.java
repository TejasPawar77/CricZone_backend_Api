package com.play.Permier_zone.config;

import com.play.Permier_zone.reppositories.UserRepository;
import com.play.Permier_zone.service.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jspecify.annotations.NonNull;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.io.IOException;

@Configuration
public class ApplicationConfiguration {
    private final UserRepository userRepository;
    public ApplicationConfiguration(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Bean
    UserDetailsService userDetailsService(){
        return username -> userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
    @Bean
    BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws  Exception{
        return config.getAuthenticationManager();
    }
    @Bean
    AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    @Component
    public static class jwtAuthenticationFilter {
        private final HandlerExceptionResolver handlerExceptionResolver;
        private final JwtService jwtService;
        private final UserDetailsService userDetailsService;

        public jwtAuthenticationFilter(
                JwtService jwtService,
                UserDetailsService userDetailsService,
                HandlerExceptionResolver handlerExceptionResolver
        ){
            this.jwtService = jwtService;
            this.userDetailsService = userDetailsService;
            this.handlerExceptionResolver = handlerExceptionResolver;
        }

        protected void doFilterInternal(
                @NonNull HttpServletRequest request,
                @NonNull HttpServletResponse response,
                @NonNull FilterChain filterChain
                ) throws ServletException, IOException {
            final String authHeader = request.getHeader("Autherization");

            if(authHeader == null || !authHeader.startsWith("Bearer")){
                filterChain.doFilter(request, response);
                return;
            }
        }
    }
}
