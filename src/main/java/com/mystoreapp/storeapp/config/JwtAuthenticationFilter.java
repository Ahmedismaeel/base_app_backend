package com.mystoreapp.storeapp.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.CachingUserDetailsService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    final JwtService jwtService;
  final  private UserDetailsService userDetailsService;
    private static final Logger logger = LoggerFactory.getLogger(JwtAuthenticationFilter.class);
    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {
        logger.info("step 1");

    final String authHeader = request.getHeader("Authorization");
        logger.info(authHeader);
    final String jwt;
    final String userName;
    if(authHeader == null || !authHeader.startsWith("Bearer ")){
        logger.info("step 2");
        filterChain.doFilter(request,response);
        logger.info("step 3");
        return;
    }

    jwt = authHeader.substring(7);
        logger.info("step 4");
    userName = jwtService.extractUsername(jwt);
        logger.info("step 5");
    if(userName != null && SecurityContextHolder.getContext().getAuthentication() == null){
            UserDetails userDetails =  this.userDetailsService.loadUserByUsername(userName);
        logger.info(userDetails.getUsername());
        if (jwtService.isValidToken(jwt, userDetails) ) {      logger.info(userDetails.getAuthorities().toString());
            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                    userDetails,
                    null,
                    userDetails.getAuthorities()
            );      logger.info("step 8");
            authToken.setDetails(
                    new WebAuthenticationDetailsSource().buildDetails(request)
            );      logger.info("step 1");
            SecurityContextHolder.getContext().setAuthentication(authToken);
        }
    }      logger.info("step 1");
    filterChain.doFilter(request,response);
    }
}
