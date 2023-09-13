package com.example.ecommerce.ecommerce.Handler;


import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@Component
public class YourCustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, org.springframework.security.core.Authentication authentication) throws IOException, ServletException {
        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());

        if (roles.contains("ROLE_ADMIN")) {
            response.sendRedirect("/seller/dashboard"); // Redirect recruiter to recruiter profile page
        } else if (roles.contains("ROLE_USERS")) {
            response.sendRedirect("/users/shop"); // Redirect candidate to job listing page
        } else {
            // If the user doesn't have any of the specified roles, redirect to a default page.
            response.sendRedirect("/home");
        }
    }
}
