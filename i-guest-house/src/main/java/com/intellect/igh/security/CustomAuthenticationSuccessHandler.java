package com.intellect.igh.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@Component
public class CustomAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Override
    protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {
        String targetUrl = determineTargetUrl(authentication);
        if (response.isCommitted()) {
            return;
        }
        getRedirectStrategy().sendRedirect(request, response, targetUrl);
    }

    protected String determineTargetUrl(Authentication authentication) {
        //Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        //for (GrantedAuthority authority : authorities) {
          //String role = authority.getAuthority();
//            if (role.equals("ROLE_ADMIN")) {
//                return "/admin/dashboard";  // Define this endpoint or modify it as needed
//            } else if (role.equals("ROLE_MANAGER")) {
//                return "/manager/dashboard";  // Define this endpoint or modify it as needed
//            } else if (role.equals("ROLE_USER")) {
//                return "/user/dashboard";  // Define this endpoint or modify it as needed
//            }
        //}
        return "/";  // Default redirect URL
    }
}