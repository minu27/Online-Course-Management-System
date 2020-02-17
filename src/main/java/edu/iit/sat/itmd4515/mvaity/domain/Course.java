/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.mvaity.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Minal
 */
@Entity
public class Course{

    public Course() {
    }
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int ID;
    private String CourseName;
    private String CourseCode;
    private String Dept;

    public Course(String CourseName, String CourseCode, String Dept) {
        this.CourseName = CourseName;
        this.CourseCode = CourseCode;
        this.Dept = Dept;
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String CourseName) {
        this.CourseName = CourseName;
    }

    public String getCourseCode() {
        return CourseCode;
    }

    public void setCourseCode(String CourseCode) {
        this.CourseCode = CourseCode;
    }

    public String getDept() {
        return Dept;
    }

    public void setDept(String Dept) {
        this.Dept = Dept;
    }

  

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "Course{" + "ID=" + ID + ", CourseName=" + CourseName + ", CourseCode=" + CourseCode + ", Dept=" + Dept + '}';
    }
    
}

