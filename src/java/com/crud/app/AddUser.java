/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.crud.app;

import CRUD.User_CRUD;
import common.User_Bean;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author hp
 */
public class AddUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User_Bean obj_user_bean = new User_Bean();
        obj_user_bean.setName(request.getParameter("name"));
        obj_user_bean.setPassword(request.getParameter("password"));
        obj_user_bean.setEmail(request.getParameter("email"));
        obj_user_bean.setSex(request.getParameter("sex"));
        obj_user_bean.setCountry(request.getParameter("country"));

        User_CRUD user_insert = new User_CRUD();
       int status= user_insert.addUser(obj_user_bean);
        if (status == 1) {
            System.out.print("1 user added");
        } else {
            System.out.print("user data not recorded");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
