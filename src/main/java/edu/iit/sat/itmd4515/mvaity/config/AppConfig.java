/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.mvaity.config;

import edu.iit.sat.itmd4515.mvaity.domain.Auth;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @author Minal
 */
@Named
@ApplicationScoped
public class AppConfig {

    public AppConfig() {
    }
    
    public Auth[] getAuth() {
        return Auth.values();
    }
}
