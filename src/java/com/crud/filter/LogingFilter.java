/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Filter.java to edit this template
 */
package com.crud.filter;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author hp
 */
public class LogingFilter implements Filter {

    private static final boolean debug = true;
    private ServletContext context;

    // The filter configuration object we are associated with.  If
    // this value is null, this filter instance is not currently
    // configured. 
    private FilterConfig filterConfig = null;

    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest http_request = (HttpServletRequest) request;
        //  Cookie cookies_user[] = http_request.getCookies();
        HttpSession session = http_request.getSession(false);
        String requested_uri = http_request.getRequestURI().toString();
        System.out.println(requested_uri);
        if (session != null) {

            if (requested_uri.endsWith("/JSPCRUD/") || requested_uri.endsWith("/JSPCRUD/home.jsp") || requested_uri.endsWith("/JSPCRUD/index.jsp")) {
                RequestDispatcher obj_dispatcher = http_request.getRequestDispatcher("/home.jsp");
                obj_dispatcher.forward(request, response);
            } else {
                chain.doFilter(request, response);
            }

        } else if (requested_uri.endsWith("/JSPCRUD/Login")) {
            chain.doFilter(request, response);
        } else {
            //  chain.doFilter(request, response);
            RequestDispatcher obj_dispatcher = http_request.getRequestDispatcher("/index.jsp");
            obj_dispatcher.forward(request, response);
        }

    }

    /**
     * Return the filter configuration object for this filter.
     */
    public FilterConfig getFilterConfig() {
        return (this.filterConfig);
    }

    /**
     * Set the filter configuration object for this filter.
     *
     * @param filterConfig The filter configuration object
     */
    public void setFilterConfig(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    /**
     * Destroy method for this filter
     */
    public void destroy() {
    }

    /**
     * Init method for this filter
     */
    public void init(FilterConfig filterConfig) {
        this.context = filterConfig.getServletContext();
        this.filterConfig = filterConfig;

    }

}
