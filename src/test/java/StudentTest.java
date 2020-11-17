/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.se3_assignment1.*;
import org.joda.time.DateTime;
import org.junit.Before;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author myles
 */
public class StudentTest {
    
    private Student student;
    private com.mycompany.se3_assignment1.Module module1;
    private com.mycompany.se3_assignment1.Module module2;
    private Course course;
     
    @Before
    public void setUp() {
        student = new Student("Colin Flaherty", 22, 17303453, "17-04-1999");
        module1 = new com.mycompany.se3_assignment1.Module("Software Engineering", "CT417");
        module2 = new com.mycompany.se3_assignment1.Module("Machine Learning", "CT4101");
        course = new Course("ECE", new DateTime("2020-08-01T00:00:00Z"), new DateTime("2021-05-31T00:00:00Z"));
    }
    
    
    @Test
    public void testGetUsername(){
        String correctUsername = "Colin Flaherty_22";
        String testCaseUsername = student.getUsername();
        assertEquals("working", correctUsername, testCaseUsername);
    }

    @Test
    public void testAddModule(){
        student.addModule(module1);
        com.mycompany.se3_assignment1.Module testCaseModule = new com.mycompany.se3_assignment1.Module("Software Engineering", "CT417");
        String correctModuleName = student.getModuleString();
        assertEquals("working", correctModuleName, testCaseModule.getModuleName());
    }
    
    @Test
    public void testRemModule(){
        student.addModule(module1);
        student.addModule(module2);
        
        com.mycompany.se3_assignment1.Module testCaseModule = new com.mycompany.se3_assignment1.Module("Software Engineering", "CT417");
        
        student.remModule(module2);
        String correctModuleName = student.getModuleString();
        assertEquals("working", correctModuleName, testCaseModule.getModuleName());
    }
    
    @Test
    public void testSetCourse(){
        student.setCourseEnrolled(course);
        
        Course testCaseCourse = new Course("ECE", new DateTime("2020-08-01T00:00:00Z"), new DateTime("2021-05-31T00:00:00Z"));
        Course correctCourse = student.getCourseEnrolled();
        
        assertEquals("working", correctCourse.getCourseName(), testCaseCourse.getCourseName());
    }
    
}
