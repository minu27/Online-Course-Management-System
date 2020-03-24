/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.mvaity.domain;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Minal
 */
@Entity
public class Course extends AbstractEntity {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "courseId")
    private Integer courseId;
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
    @OneToMany(mappedBy = "courseId")
    private List<CourseWiseMaterial> coursewisematerialList;
    @OneToMany(mappedBy = "courseId")
    private List<Assignment> assignmentList;
    @OneToMany(mappedBy = "courseId")
    private List<StudentRequestCourse> studentrequestcourseList;
    @OneToMany(mappedBy = "courseId")
    private List<TeachingAssistant> teachingassistantList;

    private String name;
    @ManyToMany
    @JoinTable(name = "course_students",
            joinColumns = @JoinColumn(name = "courseId"),
            inverseJoinColumns = @JoinColumn(name = "studentId"))
    private List<Students> students = new ArrayList<>();
    
    public Course() {
    }
    
    public Course(Integer courseId, String name) {
        this.courseId = courseId;
        this.name = name;
    }

    public void addStudents(Students t) {
        if (!this.students.contains(t)) {
            this.students.add(t);
        }
        if (!t.getCourses().contains(this)) {
            t.getCourses().add(this);
        }
    }

    public void removeStudents(Students t) {
        if (this.students.contains(t)) {
            this.students.remove(t);
        }
        if (t.getCourses().contains(this)) {
            t.getCourses().remove(this);
        }
    }

    

    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Course{" + "Course id=" + courseId + "name=" + name + '}';
    }

    public List<Students> getStudents() {
        return students;
    }

    public void setStudents(List<Students> students) {
        this.students = students;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

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

    @XmlTransient
    public List<StudentRequestCourse> getStudentrequestcourseList() {
        return studentrequestcourseList;
    }

    public void setStudentrequestcourseList(List<StudentRequestCourse> studentrequestcourseList) {
        this.studentrequestcourseList = studentrequestcourseList;
    }

    @XmlTransient
    public List<TeachingAssistant> getTeachingassistantList() {
        return teachingassistantList;
    }

    public void setTeachingassistantList(List<TeachingAssistant> teachingassistantList) {
        this.teachingassistantList = teachingassistantList;
    }

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

    
}