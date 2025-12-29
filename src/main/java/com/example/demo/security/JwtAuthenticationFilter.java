package com.example.demo.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtTokenProvider tokenProvider;
    private final CustomUserDetailsService userDetailsService;

    public JwtAuthenticationFilter(JwtTokenProvider tokenProvider,
                                   CustomUserDetailsService userDetailsService) {
        this.tokenProvider = tokenProvider;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        // Read Authorization header
        String header = request.getHeader(SecurityConstants.HEADER_STRING);
        String token = null;

        if (StringUtils.hasText(header) && header.startsWith(SecurityConstants.TOKEN_PREFIX)) {
            // strip "Bearer " prefix
            token = header.substring(SecurityConstants.TOKEN_PREFIX.length());
        }

        // If we have a token and no authentication yet, validate and authenticate
        if (token != null
                && tokenProvider.validateToken(token)
                && SecurityContextHolder.getContext().getAuthentication() == null) {

            // Your provider stores id|email|roles -> we extract user id
            Long userId = tokenProvider.getUserIdFromToken(token);

            // IMPORTANT: CustomUserDetailsService must load by this id string
            UserDetails userDetails = userDetailsService.loadUserByUsername(String.valueOf(userId));

            UsernamePasswordAuthenticationToken authentication =
                    new UsernamePasswordAuthenticationToken(
                            userDetails,
                            null,
                            userDetails.getAuthorities()
                    );
            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(request, response);
    }
}
