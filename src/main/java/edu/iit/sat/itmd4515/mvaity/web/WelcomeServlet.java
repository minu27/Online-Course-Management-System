/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.mvaity.web;

import edu.iit.sat.itmd4515.mvaity.domain.Guest;
import edu.iit.sat.itmd4515.mvaity.domain.Students;
import java.io.IOException;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;


/**
 *
 * @author Minal
 */
@WebServlet(name = "/WelcomeServlet", urlPatterns = {"/st"})
public class WelcomeServlet extends HttpServlet {

    //Initialization of Logger
    private static final Logger LOG = Logger.getLogger(WelcomeServlet.class.getName());
    
    @PersistenceContext(name = "itmd4515PU")
    EntityManager em;

    @Resource
    UserTransaction tx;
    //Initialization of validator
    @Resource
    Validator validator;
    
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
        String email = (String) request.getSession().getAttribute("emailId");
        String gender = (String) request.getSession().getAttribute("gender");

        Students st = new Students(fname, lname, email, gender);
        LOG.info("Constructed instance:" + st.toString());
       
       
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
        LOG.info("ExerciseServlet inside doGet");

        Guest gu = new Guest();
        request.setAttribute("gu", gu);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Welcome.jsp");
        dispatcher.forward(request, response);
        
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
        
        //Log Statements
        LOG.info("WelcomeServlet inside doPost");
        LOG.info("Caught parameter nonexistant which is null - remember empty user input is not null, it's blank!" + request.getParameter("nonexistant") );
        
        String stfirstName = request.getParameter("firstName");
        String stlastName = request.getParameter("lastName");
        String stemailId = request.getParameter("emailId");
        String stgender = request.getParameter("gender");
       

        LOG.info("Caught parameter first name:" + stfirstName );
        LOG.info("Caught parameter last name:" + stlastName );
        LOG.info("Caught parameter email:" + stemailId );
        LOG.info("Caught parameter gender:" + stgender );
       
        //Object creation
        Students st = new Students(stfirstName, stlastName, stemailId, stgender);
        LOG.info("Constructed instance:" + st.toString());
        
        
        try{
        //Validation of inputs
        Set<ConstraintViolation<Students>> violations = validator.validate(st);
       
        if( violations.size() > 0 ){
            //Invoked when validation is failed
            LOG.info("Houston - we have a problem with validation.  Halt the launch!");
            for (ConstraintViolation<Students> violation : violations) {
                LOG.info(violation.getPropertyPath() + " " + violation.getMessage());
            }
            
            request.setAttribute("StudentId", st.getStudentId().toString());
            request.setAttribute("createdBy", st.getCreatedBy().toString());
            request.setAttribute("createdOn", st.getCreatedOn().toString());
            request.setAttribute("st", st);
            request.setAttribute("mistakes", violations);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Welcome.jsp");
            dispatcher.forward(request, response);
           
            
        } else 
        {
            //Invoked when validation is passed
            LOG.info("Houston - we have passed validation.  All systems are good!");
            request.setAttribute("st", st);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/confirmation.jsp");
            dispatcher.forward(request, response);
        }
        }catch (Exception e) {
            Logger.getLogger(WelcomeServlet.class.getName()).log(Level.SEVERE, null, e);
            // this would be a nice place to send the user webapp flow back to an error page, or potentially the form to correct errors, or with a global error banner
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
