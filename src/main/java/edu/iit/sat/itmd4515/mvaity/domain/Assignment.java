/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.mvaity.domain;

import java.io.Serializable;
import java.util.logging.Logger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;


/**
 *
 * @author Minal
 */
@Entity
@Table(name = "assignment")
@NamedQueries({
    @NamedQuery(name = "Assignment.findAll", query = "SELECT a FROM Assignment a")
    , @NamedQuery(name = "Assignment.findByCourseName", query = "SELECT a FROM Assignment a WHERE a.courseName = :courseName")
    , @NamedQuery(name = "Assignment.findByGrading", query = "SELECT a FROM Assignment a WHERE a.grading = :grading")
    , @NamedQuery(name = "Assignment.findByInstructorId", query = "SELECT a FROM Assignment a WHERE a.instructorId = :instructorId")
    , @NamedQuery(name = "Assignment.findByMarks", query = "SELECT a FROM Assignment a WHERE a.marks = :marks")})
public class Assignment extends AbstractEntity implements Serializable {

    private static final Logger LOG = Logger.getLogger(Assignment.class.getName());
   
    private static final long serialVersionUID = 1L;
    
   
    @Size(max = 255)
    @Column(name = "createdBy")
    private String createdBy;
    @Size(max = 255)
    @Column(name = "courseName")
    private String courseName;
    @Size(max = 255)
    @Column(name = "grading")
    private String grading;
    @Column(name = "instructorId")
    private Integer instructorId;
    @Column(name = "marks")
    private Integer marks;
    
    @ManyToOne
    private TeachingAssistant teachingAssistant;
    @ManyToOne
    private Instructor instructor;
    @ManyToOne
    private Students students;
    // bi-directional ManyToOne/OneToMany
    @ManyToOne
    private Course course;
    
    public Assignment() {
    }

    public Assignment(String createdBy, String courseName, Integer instructorId, Integer marks, String grading ) {
        this.createdBy = createdBy;
        this.courseName = courseName;
        this.instructorId = instructorId;
        this.marks = marks;
        this.grading = grading;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getGrading() {
        return grading;
    }

    public void setGrading(String grading) {
        this.grading = grading;
    }

    public Integer getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(Integer instructorId) {
        this.instructorId = instructorId;
    }

    public Integer getMarks() {
        return marks;
    }

    public void setMarks(Integer marks) {
        this.marks = marks;
    }
    
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    

     /**
     * Get the value of instructor
     *
     * @return the value of instructor
     */
    public Instructor getInstructor() {
        return instructor;
    }

    /**
     * Set the value of instructor
     *
     * @param instructor new value of instructor
     */
    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    
    public Students getStudents() {
        return students;
    }

    public void setStudents(Students students) {
        this.students = students;
    }
    
    public TeachingAssistant getTeachingAssistant() {
        return teachingAssistant;
    }

    public void setTeachingAssistant(TeachingAssistant teachingAssistant) {
        this.teachingAssistant = teachingAssistant;
    }
    
        /**
     *
     * @return
     */
    public Course getCourse() {
        return course;
    }

    /**
     * Sets the value of course, and manages BOTH sides of this bi-directional
     * relationship *
     *
     * @param course
     */
    public void setCourse(Course course) {
        this.course = course;
        
        if (!course.getAssignments().contains(this)) {
            course.getAssignments().add(this);
        }
    }


    /**
     *
     */
    public void removeFromCourse() {
        
        LOG.info("Assignment to be deleted" + course.getAssignments());
        
        if(course.getAssignments().contains(this)) {
            course.getAssignments().remove(this);
        }

        this.course = null;
        
    }
    
    @Override
    public String toString() {
        return "Assignment[ assignmentId=" + id + ", courseName=" + courseName + ", createdBy=" + createdBy + ", instructorId=" + instructorId + ", marks=" + marks + ", grading=" + grading + "  ]";
    }

    
    
}
