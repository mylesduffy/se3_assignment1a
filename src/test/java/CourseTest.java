/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.se3_assignment1.*;
import java.util.List;
import org.joda.time.DateTime;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author myles
 */
public class CourseTest {
    
    private Student student1;
    private Student student2;
    private Course course;
    private com.mycompany.se3_assignment1.Module module1;
    private com.mycompany.se3_assignment1.Module module2;
    
    @Before
    public void setUp(){
        student1 = new Student("Colin Flaherty", 22, 17303453, "17-04-1999");
        student2 = new Student("Maeve Kennedy", 23, 17320345, "21-03-1998");
        module1 = new com.mycompany.se3_assignment1.Module("Software Engineering", "CT417");
        module2 = new com.mycompany.se3_assignment1.Module("Machine Learning", "CT4101");
        course = new Course("ECE", new DateTime("2020-08-01T00:00:00Z"), new DateTime("2021-05-31T00:00:00Z"));
    }
    
    @Test
    public void testEnrollStudentCourse(){
        course.enrollStudentCourse(student1);
        
        List<Student> enrolledStudents = course.getStudentsEnrolled();
        
        assertTrue(enrolledStudents.contains(student1));
    }
    
    @Test
    public void testRemStudentCourse(){
        course.enrollStudentCourse(student1);
        course.enrollStudentCourse(student2);
        course.remStudentCourse(student2);
        
        List<Student> enrolledStudents = course.getStudentsEnrolled();
        
        assertTrue(!enrolledStudents.contains(student2));
    }
    
    @Test
    public void testAddModuleCourse(){
        course.addModuleCourse(module1);
        
        List<com.mycompany.se3_assignment1.Module> courseModules = course.getModuleList();
        
        assertTrue(courseModules.contains(module1));
    }
    
    @Test
    public void testRemModuleCourse(){
        course.addModuleCourse(module1);
        course.addModuleCourse(module2);
        course.remModuleCourse(module2);
        
        List<com.mycompany.se3_assignment1.Module> courseModules = course.getModuleList();
        
        assertTrue(!courseModules.contains(module2));
    }
}
