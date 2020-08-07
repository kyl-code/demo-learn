package org.example.filter;


import javax.servlet.*;
import java.io.IOException;

public class ParamFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.err.println("this is paramFilter");
        chain.doFilter(request, response);
    }
}
