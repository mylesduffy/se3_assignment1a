package com.mycompany.se3_assignment1;


import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;

/**
 *
 * @author myles
 */

public class Course{

    private String courseName;
    private DateTime startDate, endDate;
    private List<Student> studentsEnrolled;
    private List<Module> moduleList;

    public Course(String courseName, DateTime startDate, DateTime endDate){
        this.courseName = courseName;
        this.startDate = startDate;
        this.endDate = endDate;
        studentsEnrolled = new ArrayList<Student>();
        moduleList = new ArrayList<Module>();
    }

    public void enrollStudentCourse(Student student){
        if(!studentsEnrolled.contains(student)){
            studentsEnrolled.add(student);
            student.setCourseEnrolled(Course.this);
        } else {
            System.out.println("Error: Student already enrolled in this course.");
        }
    }

    public void remStudentCourse(Student student){
        if(studentsEnrolled.contains(student)){
            studentsEnrolled.remove(student);
        } else {
            System.out.println("Error: Student not enrolled in this course.");
        }
    }

    public void addModuleCourse(Module module){
        if(!moduleList.contains(module)){
            moduleList.add(module);
            module.addCourse(Course.this);
        } else {
            System.out.println("Error: That module is already associated with this course.");
        }
    }

    public void remModuleCourse(Module module){
        if(moduleList.contains(module)){
            moduleList.remove(module);
            module.removeCourse(Course.this);
        } else {
            System.out.println("Error: That module is not associated witht this course.");
        }
    }

    public List<Module> getModuleList() {
        return moduleList;
    }

    public void setModuleList(List<Module> moduleList) {
        this.moduleList = moduleList;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public DateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(DateTime startDate) {
        this.startDate = startDate;
    }

    public DateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(DateTime endDate) {
        this.endDate = endDate;
    }

    public List<Student> getStudentsEnrolled() {
        return studentsEnrolled;
    }

    public void setStudentsEnrolled(List<Student> studentsEnrolled) {
        this.studentsEnrolled = studentsEnrolled;
    }

    public String getStudentsEnrolledString(){
        StringBuilder studentsEnrolledSB = new StringBuilder();

        for(Student student : studentsEnrolled){
            studentsEnrolledSB.append(student.getUsername());
        }

        String studentsEnrolledString = studentsEnrolledSB.toString();

        return studentsEnrolledString;
    }

    public String getModuleListString(){
        StringBuilder moduleStringSB = new StringBuilder();

        for(Module module : moduleList){
            moduleStringSB.append(module.getModuleName());
        }

        String moduleString = moduleStringSB.toString();

        return moduleString;
    }

    @Override
    public String toString(){
        return "Course Name: " + courseName + " | Start Date: " + startDate + " | End Date: " + endDate + " | Students Enrolled: " +
                this.getStudentsEnrolledString() + " | Course Modules: " + this.getModuleListString();
    }
}