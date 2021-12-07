package com.example.j2eestuff.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebListener;

@WebListener
public class TestServletContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext sc = sce.getServletContext();
        //register servlet
        ServletRegistration sr = sc.addServlet("DynamicServlet","com.example.j2eestuff.servlets.DynamicServlet");
        sr.setInitParameter("myparam","value");
        sr.addMapping("/dynamic");
    }
}
