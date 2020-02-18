/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.mvaity.web;

import edu.iit.sat.itmd4515.mvaity.domain.Students;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Minal
 */
@WebServlet("/StudentReg")
public class StudentReg extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(StudentReg.class.getName());

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
        processRequest(request, response);
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
        processRequest(request, response);
    }


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
        LOG.info("StudentRegServlet inside doPost");
        response.setContentType("text/html;charset=UTF-8");

        
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        //String dob=request.getParameter("dob"); 
        String email = request.getParameter("emailId");
        String gender = request.getParameter("gender");

        //LOG statements
        LOG.info("Caught parameter first name:" + firstName);
        LOG.info("Caught parameter last name:" + lastName);
        LOG.info("Caught parameter email:" + email);
        LOG.info("Caught parameter gender:" + gender);

        PrintWriter out = response.getWriter();
        try {
            //inputs are tested and proceeded with error messages if any
            if (firstName.isEmpty() != true || lastName.isEmpty() != true || email.isEmpty() != true) {

                request.getSession().setAttribute("firstName", firstName);
                request.getSession().setAttribute("lastName", lastName);
                // request.getSession().setAttribute("dob", dob);
                request.getSession().setAttribute("emailId", email);
                request.getSession().setAttribute("gender", gender);

                Students st = new Students();
                request.setAttribute("st", st);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WelcomeServlet");//RequestDispatcher logic
                dispatcher.forward(request, response);
            } else {
                
                out.print("Please enter valid input!");//Error message on the JSP page
                RequestDispatcher rd = request.getRequestDispatcher("/Welcome.jsp"); //RequestDispatcher logic
                rd.include(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
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
    }

}
