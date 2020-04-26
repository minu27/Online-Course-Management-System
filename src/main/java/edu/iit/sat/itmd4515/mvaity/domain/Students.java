/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.mvaity.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author Minal
 */
@Entity
@Table(name = "students")
@NamedQueries({
    @NamedQuery(name = "Students.findAll", query = "SELECT s FROM Students s")
    , @NamedQuery(name = "Students.findByStudentId", query = "SELECT s FROM Students s WHERE s.studentId = :studentId")
    , @NamedQuery(name = "Students.findByCreatedBy", query = "SELECT s FROM Students s WHERE s.createdBy = :createdBy")
    , @NamedQuery(name = "Students.findByCreatedOn", query = "SELECT s FROM Students s WHERE s.createdOn = :createdOn")
    , @NamedQuery(name = "Students.findByEmailId", query = "SELECT s FROM Students s WHERE s.emailId = :emailId")
    , @NamedQuery(name = "Students.findByFirstName", query = "SELECT s FROM Students s WHERE s.firstName = :firstName")
    , @NamedQuery(name = "Students.findByGender", query = "SELECT s FROM Students s WHERE s.gender = :gender")
    , @NamedQuery(name = "Students.findByLastName", query = "SELECT s FROM Students s WHERE s.lastName = :lastName")
    , @NamedQuery(name = "Students.findByStatus", query = "SELECT s FROM Students s WHERE s.status = :status")
    , @NamedQuery(name = "Students.findByUpdatedBy", query = "SELECT s FROM Students s WHERE s.updatedBy = :updatedBy")
    , @NamedQuery(name = "Students.findByUpdatedOn", query = "SELECT s FROM Students s WHERE s.updatedOn = :updatedOn")})
public class Students extends AbstractEntity implements Serializable {

    
    @Column(name = "facialTokanImage")
    private byte[] facialTokanImage;

    private static final long serialVersionUID = 1L;
    
    
    @Basic(optional = false)
    @Column(name = "studentId")
    private Integer studentId;
    @Size(max = 255)
    @Column(name = "createdBy")
    private String createdBy;
    @Column(name = "createdOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
    @Size(max = 255)
    @Column(name = "emailId")
    private String emailId;
    @Size(max = 255)
    @Column(name = "firstName")
    private String firstName;
    @Size(max = 255)
    @Column(name = "gender")
    private String gender;
    @Size(max = 255)
    @Column(name = "lastName")
    private String lastName;
    @Size(max = 255)
    @Column(name = "status")
    private String status;
    @Size(max = 255)
    @Column(name = "updatedBy")
    private String updatedBy;
    @Column(name = "updatedOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedOn;
  /*  @OneToMany(mappedBy = "studentId")
    private List<Assignment> assignmentList;
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    @ManyToOne
    private Authuser userId;
    @OneToMany(mappedBy = "studentId")
    private List<StudentRequestCourse> studentrequestcourseList; */

    //@ManyToOne
    //private Authuser userId;
    
    public Students() {
    }

   
    public Students(String firstName, String lastName, String emailId, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.gender = gender;
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

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
    public List<Assignment> getAssignmentList() {
        return assignmentList;
    }

    public void setAssignmentList(List<Assignment> assignmentList) {
        this.assignmentList = assignmentList;
    }

    public Authuser getUserId() {
        return userId;
    }

    public void setUserId(Authuser userId) {
        this.userId = userId;
    }

    @XmlTransient
    public List<StudentRequestCourse> getStudentrequestcourseList() {
        return studentrequestcourseList;
    }

    public void setStudentrequestcourseList(List<StudentRequestCourse> studentrequestcourseList) {
        this.studentrequestcourseList = studentrequestcourseList;
    }
*/
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studentId != null ? studentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Students)) {
            return false;
        }
        Students other = (Students) object;
        if ((this.studentId == null && other.studentId != null) || (this.studentId != null && !this.studentId.equals(other.studentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.iit.sat.itmd4515.mvaity.domain.Students[ studentId=" + studentId + " ]";
    }

    public byte[] getFacialTokanImage() {
        return facialTokanImage;
    }

    public void setFacialTokanImage(byte[] facialTokanImage) {
        this.facialTokanImage = facialTokanImage;
    }
    
}
