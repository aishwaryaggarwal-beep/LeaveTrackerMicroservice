package com.example.demo.config;

import com.example.demo.Service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {

    @Autowired
    private JwtService jwtService;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
    	System.out.println("Incoming request: " + request.getMethod() + " " + request.getRequestURI());
    	System.out.println("Authorization: " + request.getHeader("Authorization"));

        String authHeader = request.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);

            try {
                String username = jwtService.extractUserName(token);
                String role = jwtService.extractRole(token); // "ADMIN" or "USER"

                if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                    // IMPORTANT: Spring expects roles to start with "ROLE_"
                    UsernamePasswordAuthenticationToken authToken =
                            new UsernamePasswordAuthenticationToken(
                                    username,
                                    null,
                                    List.of(new SimpleGrantedAuthority("ROLE_" + role))
                            );

                    SecurityContextHolder.getContext().setAuthentication(authToken);
                    System.out.println("Auth header: " + authHeader);
                    System.out.println("Username: " + username + ", role: " + role);
                    System.out.println("SecurityContext auth: " + SecurityContextHolder.getContext().getAuthentication());

                }
                

            } catch (Exception e) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }
        }

        filterChain.doFilter(request, response);
    }
}
