/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.mvaity.web;

import edu.iit.sat.itmd4515.mvaity.domain.security.User;
import edu.iit.sat.itmd4515.mvaity.service.UserService;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.security.enterprise.AuthenticationStatus;
import javax.security.enterprise.SecurityContext;
import javax.security.enterprise.authentication.mechanism.http.AuthenticationParameters;
import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.credential.Password;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author Minal
 */
@Named
@RequestScoped
public class LoginController implements Serializable{

    private static final Logger LOG = Logger.getLogger(LoginController.class.getName());

    private static final long serialVersionUID = 1L;

    @Inject
    @RequestScoped
    private SecurityContext securityContext;
    @Inject
    @RequestScoped
    private FacesContext facesContext;

    @Inject
    private UserService userSvc;

    private User user;

    public LoginController() {
    }

    @PostConstruct
    private void postContruct() {
        LOG.info("Inside the LoginController.postConstruct method");
        // if authenticated, find the user by username
        if (facesContext.getExternalContext().getRemoteUser() != null) {
            user = userSvc.findByEmail(facesContext.getExternalContext().getRemoteUser());
        } else {
            //else, instantiate a new user object for the login form
            user = new User();
        }
    }

    // helper methods
    /**
     * Gets the username of the currently authenticated user (if any)
     *
     * @return
     */
    public String getEmail() {
        return user.getEmail();
    }

    /**
     * Gets the groups of the currently authenticated user (if any)
     *
     * @return
     */
    public String getUserGroups() {
        LOG.info("User as group count of: " + user.getGroups().size());
        return user.getGroups().toString();
        //return securityContext.toString();
    }

    /**
     *
     * @return
     */
    public boolean isStudent() {
        if(securityContext.isCallerInRole("STUDENT_ROLE")){
            LOG.info("USER IS STUDENT");
        }
        return securityContext.isCallerInRole("STUDENT_ROLE");
    }

    /**
     *
     * @return
     */
    public boolean isInstructor() {
        if(securityContext.isCallerInRole("INSTRUCTOR_ROLE")){
            LOG.info("USER IS INSTRUCTOR");
        }
        return securityContext.isCallerInRole("INSTRUCTOR_ROLE");
    }

    /**
     *
     * @return
     */
    public boolean isTeachingAssistant() {
        if(securityContext.isCallerInRole("TEACHINGASSISTANT_ROLE")){
            LOG.info("USER IS TEACHING ASSISTANT");
        }
        return securityContext.isCallerInRole("TEACHINGASSISTANT_ROLE");
    }

    // action method
    public String doLogin() {
        // do some login stuff
        LOG.info("LoginController.doLogin for user " + user.getEmail());

        Credential credential = new UsernamePasswordCredential(user.getEmail(), new Password(user.getPassword()));
        
        
        AuthenticationStatus status = securityContext.authenticate(
                (HttpServletRequest) facesContext.getExternalContext().getRequest(),
                (HttpServletResponse) facesContext.getExternalContext().getResponse(),
                AuthenticationParameters.withParams().credential(credential)
        );

        LOG.info("Authentication Status is " + status.toString());

        switch (status) {
            case SEND_CONTINUE:
                LOG.info("Received SEND_CONTINUE");
                break;
            case SEND_FAILURE:
                LOG.info("Received SEND_FAILURE");
                return "/error.xhtml";
            case SUCCESS:
                LOG.info("Received SUCCESS");
                break;
            case NOT_DONE:
                LOG.info("Received NOT_DONE");
                return "/error.xhtml";
        }

        // eventually returns a navigation case, on successful login
        return "/welcome.xhtml?faces-redirect=true";
    }

    /**
     *
     * @return
     */
    public String doLogout() {
        // do some login stuff
        LOG.info("LoginController.doLogout for user " + getEmail());

        HttpServletRequest req = (HttpServletRequest) facesContext.getExternalContext().getRequest();
        try {
            req.logout();
        } catch (ServletException ex) {
            LOG.log(Level.SEVERE, null, ex);
            return "/error.xhtml";
        }

        // eventually returns a navigation case, on successful login
        return "/login.xhtml?faces-redirect=true";
    }


    /**
     *
     * @return
     */
    public User getUser() {
        return user;
    }

    /**
     *
     * @param user
     */
    public void setUser(User user) {
        this.user = user;
    }
}
