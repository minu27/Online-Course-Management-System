/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.mvaity.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Minal
 */
class CourseInstructorMapping extends AbstractEntity{
    // inverse side of bi-directional ManyToOne/OneToMany
    @OneToMany(mappedBy = "CourseInstructorMapping")
    private List<LearningSystem> LearningSystems = new ArrayList<>();

    // bi-directional ManyToOne/OneToMany
    @ManyToOne
    private Instructor instructor;

    public CourseInstructorMapping() {
    }

    /**
     * Get the value of LearningSystems
     *
     * @return the value of LearningSystems
     */
    public List<LearningSystem> getLearningSystems() {
        return LearningSystems;
    }

    /**
     * Set the value of LearningSystems
     *
     * @param LearningSystems new value of LearningSystems
     */
    public void setLearningSystems(List<LearningSystem> LearningSystems) {
        this.LearningSystems = LearningSystems;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

}
