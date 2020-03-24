/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.mvaity.domain;

import java.time.LocalDateTime;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

/**
 *
 * @author Minal
 */
public class AbstractEntityAuditListener {

    @PrePersist
    private void prePersist(AbstractEntity ae) {
        ae.setCreatedTimestamp(LocalDateTime.now());
    }

    @PreUpdate
    private void preUpdate(AbstractEntity ae) {
        ae.setUpdatedTimestamp(LocalDateTime.now());
    }
    
}
