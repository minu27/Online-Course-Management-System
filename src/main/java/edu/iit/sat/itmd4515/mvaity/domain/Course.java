/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.mvaity.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;


/**
 *
 * @author Minal
 */
@Entity
@Table(name = "course")
@NamedQueries({
    @NamedQuery(name = "Course.findAll", query = "SELECT c FROM Course c")
    , @NamedQuery(name = "Course.findByCourseId", query = "SELECT c FROM Course c WHERE c.courseId = :courseId")
    , @NamedQuery(name = "Course.findByCourseDuration", query = "SELECT c FROM Course c WHERE c.courseDuration = :courseDuration")
    , @NamedQuery(name = "Course.findByCourseName", query = "SELECT c FROM Course c WHERE c.courseName = :courseName")
    , @NamedQuery(name = "Course.findByCreatedBy", query = "SELECT c FROM Course c WHERE c.createdBy = :createdBy")
    , @NamedQuery(name = "Course.findByCreatedOn", query = "SELECT c FROM Course c WHERE c.createdOn = :createdOn")
    , @NamedQuery(name = "Course.findByStatus", query = "SELECT c FROM Course c WHERE c.status = :status")
    , @NamedQuery(name = "Course.findByUpdatedBy", query = "SELECT c FROM Course c WHERE c.updatedBy = :updatedBy")
    , @NamedQuery(name = "Course.findByUpdatedOn", query = "SELECT c FROM Course c WHERE c.updatedOn = :updatedOn")})
public class Course extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    
   
    @Size(max = 255)
    @Column(name = "courseDuration")
    private String courseDuration;
    @Size(max = 255)
    @Column(name = "courseName")
    private String courseName;
    @Size(max = 255)
    @Column(name = "createdBy")
    private String createdBy;
    @Column(name = "createdOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
    @Size(max = 255)
    @Column(name = "status")
    private String status;
    @Size(max = 255)
    @Column(name = "updatedBy")
    private String updatedBy;
    @Column(name = "updatedOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedOn;
    //@OneToMany(mappedBy = "courseId")
    //private List<CourseWiseMaterial> coursewisematerialList;
    //@OneToMany(mappedBy = "courseId")
    //private List<Assignment> assignmentList;
    @OneToMany(mappedBy = "course")
    private List<StudentRequestCourse> studentrequestcourseList = new ArrayList<>();
    // bi-directional ManyToOne/OneToMany
    @ManyToOne
    private TeachingAssistant teachingassistantList;

    public Course() {
    }

    /*public Course(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }*/

    public String getCourseDuration() {
        return courseDuration;
    }

    public void setCourseDuration(String courseDuration) {
        this.courseDuration = courseDuration;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }
/*
    @XmlTransient
    public List<CourseWiseMaterial> getCoursewisematerialList() {
        return coursewisematerialList;
    }

    public void setCoursewisematerialList(List<CourseWiseMaterial> coursewisematerialList) {
        this.coursewisematerialList = coursewisematerialList;
    }

    @XmlTransient
    public List<Assignment> getAssignmentList() {
        return assignmentList;
    }

    public void setAssignmentList(List<Assignment> assignmentList) {
        this.assignmentList = assignmentList;
    }
*/
   
    public List<StudentRequestCourse> getStudentrequestcourseList() {
        return studentrequestcourseList;
    }

    public void setStudentrequestcourseList(List<StudentRequestCourse> studentrequestcourseList) {
        this.studentrequestcourseList = studentrequestcourseList;
    }

   
    public TeachingAssistant getTeachingAssistant() {
        return teachingassistantList;
    }

    public void setTeachingAssistant(TeachingAssistant teachingassistantList) {
        this.teachingassistantList = teachingassistantList;
    }
/*
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (courseId != null ? courseId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Course)) {
            return false;
        }
        Course other = (Course) object;
        if ((this.courseId == null && other.courseId != null) || (this.courseId != null && !this.courseId.equals(other.courseId))) {
            return false;
        }
        return true;
    }
*/
    @Override
    public String toString() {
        return "edu.iit.sat.itmd4515.mvaity.domain.Course[ Id=" + id + " ]";
    }
    
}
