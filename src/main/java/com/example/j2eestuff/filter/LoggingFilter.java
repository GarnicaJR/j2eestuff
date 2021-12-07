package com.example.j2eestuff.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.Date;

@WebFilter("/*")
public class LoggingFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain
            chain) throws IOException, ServletException {
        //Get the IP address of client machine.
        String ipAddress = request.getRemoteAddr();
        //Log the IP address and current timestamp.
        System.out.println("IP " + ipAddress + ", Time " + new Date().toString());
        chain.doFilter(request, response);
    }

    public void init(FilterConfig config) throws ServletException {
        //Get init parameter
        String testParam = config.getInitParameter("example-param");
        //Print the init parameter
        System.out.println("Test Param: " + testParam);
    }

    public void destroy() {
        //release any resource
    }

}
