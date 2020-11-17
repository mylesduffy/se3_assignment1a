package com.mycompany.se3_assignment1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author myles
 */
public class Student {
    private String studentName, DOB, studentUName;
    private int studentAge, studentID;
    private List<Module> modulesEnrolled;
    private Course courseEnrolled;
    
    public Student(String studentName, int studentAge, int studentID, String DOB){
        this.studentName = studentName;
        this.studentAge = studentAge;
        this.DOB = DOB;
        this.studentAge = studentAge;
        this.studentID = studentID;
        this.modulesEnrolled = new ArrayList<Module>();
    }
    
    public String getUsername(){
        
        studentUName = studentName + "_" + String.valueOf(studentAge);
        
        return studentUName;
    }
    
    public void addModule(Module moduleName){
        if(!modulesEnrolled.contains(moduleName)){
            modulesEnrolled.add(moduleName);
        } else {
            System.out.println("Error: Student already enrolled in this module.");
        }
    }
    
    public void remModule(Module moduleName){
        if(modulesEnrolled.contains(moduleName)){
            modulesEnrolled.remove(moduleName);
        } else {
            System.out.println("Error: Student not enrolled in this module.");
        }
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public Course getCourseEnrolled() {
        return courseEnrolled;
    }

    public void setCourseEnrolled(Course courseEnrolled) {
        this.courseEnrolled = courseEnrolled;
        this.modulesEnrolled = courseEnrolled.getModuleList();
        for(Module module : modulesEnrolled){
            module.enrollStudent(Student.this);
        }
    }

    public int getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(int studentAge) {
        this.studentAge = studentAge;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public List<Module> getModulesEnrolled() {
        return modulesEnrolled;
    }

    public void setModulesEnrolled(List<Module> modulesEnrolled) {
        this.modulesEnrolled = modulesEnrolled;
    }
    
    public String getModuleString(){
        StringBuilder moduleSB = new StringBuilder();
        
        for(Module module : modulesEnrolled){
            moduleSB.append(module.getModuleName());
        }
        
        String moduleString = moduleSB.toString();
        
        return moduleString;
    }
  
    @Override
    public String toString(){
        return "Name: " + studentName + " | Username: " + this.getUsername() + " | DOB: " + DOB + " | Age: " + studentAge + " | ID: " + studentID +
                " | Course: " + courseEnrolled.getCourseName() + " | Modules: " + this.getModuleString();
    }
    
}
