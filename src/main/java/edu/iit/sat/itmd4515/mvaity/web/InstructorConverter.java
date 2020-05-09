/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.mvaity.web;

import edu.iit.sat.itmd4515.mvaity.domain.Instructor;
import edu.iit.sat.itmd4515.mvaity.service.InstructorService;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Minal
 */
@FacesConverter(value = "instructorConverter", managed = true)
public class InstructorConverter implements javax.faces.convert.Converter<Instructor>{

    private static final Logger LOG = Logger.getLogger(InstructorConverter.class.getName());
   
    @EJB
    private InstructorService iSvc;

    @Override
    public Instructor getAsObject(FacesContext context, UIComponent component, String value) {
        LOG.info("Value of Converter : " + value.toString());
        if (value == null || value.isEmpty()) {
            return null;
        }

        return iSvc.find(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Instructor value) {
        LOG.info("Value of Converter : " + value.toString());
        if (value == null) {
            return "";
        }

        return String.valueOf(value.getId());
    }

}
