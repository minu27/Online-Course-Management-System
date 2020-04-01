/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.mvaity.domain;


/**
 *
 * @author minal
 */
public enum Auth {
    
    ST("Student"),
    IN("Instructor"),
    TA("Teaching Assistant");
    
    private Auth(String label){
        this.label = label;
    }
    
    private String label;
    
    public String getLabel(){
        return label;
    }
}