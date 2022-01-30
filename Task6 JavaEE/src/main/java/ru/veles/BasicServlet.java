package ru.veles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet (name = "BasicServlet" , urlPatterns = "/" )
public class BasicServlet implements Servlet {
    private static final Logger logger = LoggerFactory.getLogger(BasicServlet.class);
    private transient ServletConfig config;

@Override
    public void init(ServletConfig config) throws ServletException {
        this.config = config;
    }
    @Override
    public ServletConfig getServletConfig()
    {
        return config;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws
        ServletException, IOException
    {
        logger.info( "New request" );

        PrintWriter out = res.getWriter();
        out.println("<html><body>");
        out.println("<h1>Hello World</h1>");
        out.println("</body></html>");

    }

    @Override
    public String getServletInfo()
    {
        return "BasicServlet" ;
    }

    @Override
    public void destroy() {
        logger.info( "Servlet {} destroyed" , getServletInfo()); }
        }
