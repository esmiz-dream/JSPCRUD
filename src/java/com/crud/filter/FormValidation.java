/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Filter.java to edit this template
 */
package com.crud.filter;

import java.io.IOException;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import org.apache.commons.validator.routines.*;

/**
 *
 * @author hp
 */
public class FormValidation implements Filter {

    private static final boolean debug = true;

    // The filter configuration object we are associated with.  If
    // this value is null, this filter instance is not currently
    // configured. 
    private FilterConfig filterConfig = null;

    public FormValidation() {
    }

    public boolean checkIsEmpty(String input) {
        boolean status=false;
        if(input== null) {
            status= true;
        } else{
            status= false;
        }
        return status;
    }

    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
         
        boolean status = true;
        String name = request.getParameter("name");
        System.out.println("name =>"+name+" "+checkIsEmpty(name));
        if (checkIsEmpty(name) || name.isEmpty()) {
            status = false;
            request.setAttribute("errName", "Name can not be empty");
            System.out.println("name null");
        }
        String password = request.getParameter("password");
        if (checkIsEmpty(password)|| password.isEmpty()) {
            status = false;
            request.setAttribute("errPassword", "Password can not be empty");
        }
        String email = request.getParameter("email");
        if (checkIsEmpty(email)|| email.isEmpty()) {
            status = false;
            request.setAttribute("errEmail", "Email can not be empty");
        }
        String sex = request.getParameter("sex");
        if (checkIsEmpty(sex)|| sex.isEmpty()) {
            status = false;
            request.setAttribute("errSex", "Sex can not be empty");
        }
        String country = request.getParameter("country");
        if (checkIsEmpty(country) || country.isEmpty()) {
            status = false;
            request.setAttribute("errCountry", "Country can not be empty");
        }
        String checkMe=request.getParameter("checkme");
        if(checkIsEmpty(checkMe) || checkMe.isEmpty()){
        status=false;
        request.setAttribute("errCheckMe", "You have to check confirm to policy");
        }
        
        

        boolean vldEmail = EmailValidator.getInstance().isValid(email);
        if (!vldEmail&&!checkIsEmpty(email)) {
            status = false;
            request.setAttribute("errEmail", "Email format not valid");
        }
        if (!status) {
            RequestDispatcher dispatch_adduser = request.getRequestDispatcher("/adduserform.jsp");
            dispatch_adduser.forward(request, response);
        } else {
            chain.doFilter(request, response);
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
        this.filterConfig = filterConfig;
    }

    public void log(String msg) {
        filterConfig.getServletContext().log(msg);
    }

}
