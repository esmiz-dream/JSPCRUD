/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.crud.app;

import CRUD.User_CRUD;
import common.LoginBean;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author hp
 */
public class Login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Login</title>");
            out.println("</head>");
            out.println("<body>");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            out.println("<h1>Servlet Login at" + email + "  " + password + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //  processRequest(request, response);
      
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
          response.setContentType("text/html;charset=UTF-8");
        String n = request.getParameter("userName");
        PrintWriter out = response.getWriter();

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        LoginBean loginbean = new LoginBean();
        loginbean.setEmail(email);
        loginbean.setPassword(password);

        User_CRUD crud = new User_CRUD();
         
        boolean status = crud.loginDao(loginbean);

        if (status) {
            HttpSession old_session = request.getSession(false);
            if (old_session != null) {
                old_session.invalidate();
            }
            HttpSession session = request.getSession(true);
            session.setAttribute("user", loginbean.getName());
            session.setMaxInactiveInterval(10 * 60);

            Cookie cook_user = new Cookie("user", loginbean.getName());
            cook_user.setMaxAge(10 * 60);
            response.addCookie(cook_user);

            RequestDispatcher obj_dispatcher = request.getRequestDispatcher("/home.jsp");
            obj_dispatcher.forward(request, response);
          //  response.sendRedirect("home.jsp");
            
        } else {
            RequestDispatcher obj_dispatcher = request.getRequestDispatcher("/index.jsp");
            out.print("incorrect username and password! please try again!!!");
            obj_dispatcher.include(request, response);
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
