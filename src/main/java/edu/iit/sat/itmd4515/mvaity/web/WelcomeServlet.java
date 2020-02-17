/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.mvaity.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Minal
 */
@WebServlet(name = "/WelcomeServlet", urlPatterns = {"/welcome"})
public class WelcomeServlet extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(WelcomeServlet.class.getName());
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
        String fname = (String) request.getSession().getAttribute("firstName");
        String lname = (String) request.getSession().getAttribute("lastName");
        String email = (String) request.getSession().getAttribute("email");
        String gender = (String) request.getSession().getAttribute("gender");

        try ( PrintWriter out = response.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet WelcomeServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div align='center'><h1>Student Creation Confirmation</h1></div>");
            out.println("</br></br> ");
            out.println("<h3>The following information was submitted</h3>");
            out.println("</br> ");
            out.println(". First Name-" + fname);
            out.println("</br>");
            out.println(". Last Name-" + lname);
            out.println("</br>");
            out.println(". Email Id-" + email);
            out.println("</br>");
            out.println(". Gender-" + gender);
            out.println("</br>");
            out.println("</body>");
            out.println("</html>");
        }
    }

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
       LOG.info("WelcomeServlet inside doGet");
       
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
        LOG.info("WelcomeServlet inside doPost");
        LOG.info("Caught parameter nonexistant which is null - remember empty user input is not null, it's blank!" + request.getParameter("nonexistant") );
    
      
    
    }   
    

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
