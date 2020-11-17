package com.mycompany.se3_assignment1;


import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author myles
 */
public class Module {
    
    public String moduleName, moduleID;
    private List<Student> studentsEnrolled;
    private List<Course> coursesAssociated;
    
    public Module(String moduleName, String moduleID){
        this.moduleName = moduleName;
        this.moduleID = moduleID;
        studentsEnrolled = new ArrayList<Student>();
        coursesAssociated = new ArrayList<Course>();
    } 

    public void enrollStudent(Student student){
        if(!studentsEnrolled.contains(student)){
            studentsEnrolled.add(student);
        } else {
            System.out.println("Error: Student is already enrolled in this module.");
        }
    }

    public void removeStudent(Student student){
        if(studentsEnrolled.contains(student)){
            studentsEnrolled.remove(student);
            student.remModule(Module.this);
        } else {
            System.out.println("Error: Student is not enrolled in this module.");
        }
    }

    public void addCourse(Course course){
        if(!coursesAssociated.contains(course)){
            coursesAssociated.add(course);
        } else {
            System.out.println("Error: That course is already associated with this module.");
        }
    }

    public void removeCourse(Course course){
        if(coursesAssociated.contains(course)){
            coursesAssociated.remove(course);
        } else {
            System.out.println("Error: That course is not associated with this module.");
        }
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getModuleID() {
        return moduleID;
    }

    public void setModuleID(String moduleID) {
        this.moduleID = moduleID;
    }

    public List<Student> getStudentsEnrolled() {
        return studentsEnrolled;
    }

    public void setStudentsEnrolled(List<Student> studentsEnrolled) {
        this.studentsEnrolled = studentsEnrolled;
    }

    public List<Course> getCoursesAssociated() {
        return coursesAssociated;
    }

    public void setCoursesAssociated(List<Course> coursesAssociated) {
        this.coursesAssociated = coursesAssociated;
    }

    public String getStudentsString(){
        StringBuilder studentSB = new StringBuilder();

        for(Student student : studentsEnrolled){
            studentSB.append(student.getUsername());
            studentSB.append(" ");
        }

        String studentString = studentSB.toString();

        return studentString;
    }

    public String getCoursesString(){
        StringBuilder courseSB = new StringBuilder();

        for(Course course : coursesAssociated){
            courseSB.append(course.getCourseName());
            courseSB.append(" ");
        }

        String courseString = courseSB.toString();

        return courseString;
    }

    @Override
    public String toString(){
        return "Name: " + moduleName + " | ID: " + moduleID + " | Students Enrolled: " + this.getStudentsString() + " | Courses Associated: " + this.getCoursesString();
    }
    
}
