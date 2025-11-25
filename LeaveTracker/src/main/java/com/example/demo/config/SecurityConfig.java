package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    @Autowired
    private JwtAuthFilter jwtAuthFilter;

    
    @Bean      
	public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{
    	   System.out.println("SecurityFilterChain bean initialized");
		http
		    .csrf(csrf -> csrf.disable())
		    .cors(Customizer.withDefaults()) 
		    .authorizeHttpRequests(request -> request
		    		.requestMatchers("/register","/login")
		    		.permitAll()
		    		.anyRequest().authenticated())
		    .httpBasic(Customizer.withDefaults())
		    .sessionManagement(session ->
		         session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
		    .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
		    
		return http.build();
	}

}
