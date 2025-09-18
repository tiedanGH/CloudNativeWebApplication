package edu.northeastern.csye6225.component;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class GetRequestFilter extends OncePerRequestFilter {

    @Override
    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (request.getMethod().equals("GET")) {
            int length = request.getContentLength();
            if (length > 0) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Response body must be empty");
                return;
            }
        }
        filterChain.doFilter(request, response);
    }
}
