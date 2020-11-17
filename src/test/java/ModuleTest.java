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
public class ModuleTest {
    private Student student1;
    private Student student2;
    private com.mycompany.se3_assignment1.Module module;
    private Course course1;
    private Course course2;

    
    @Before
    public void setUp(){
        student1 = new Student("Colin Flaherty", 22, 17303453, "17-04-1999");
        student2 = new Student("Maeve Kennedy", 23, 17320345, "21-03-1998");
        module = new com.mycompany.se3_assignment1.Module("Software Engineering", "CT417");
        course1 = new Course("ECE", new DateTime("2020-08-01T00:00:00Z"), new DateTime("2021-05-31T00:00:00Z"));
        course2 = new Course("BIS", new DateTime("2020-08-01T00:00:00Z"), new DateTime("2021-05-31T00:00:00Z"));
    }
    
    @Test
    public void testEnrollStudent(){
        module.enrollStudent(student1);
        
        List<Student> enrolledStudents = module.getStudentsEnrolled();
        
        assertTrue(enrolledStudents.contains(student1));
    }
    
    @Test
    public void testRemoveStudent(){
        module.enrollStudent(student1);
        module.enrollStudent(student2);
        module.removeStudent(student2);
        
        List<Student> enrolledStudents = module.getStudentsEnrolled();
        
        assertTrue(!enrolledStudents.contains(student2));
    }
    
    @Test
    public void testAddCourse(){
        module.addCourse(course1);
        
        List<Course> coursesAssociated = module.getCoursesAssociated();
        
        assertTrue(coursesAssociated.contains(course1));
    }
    
    @Test
    public void testRemoveCourse(){
        module.addCourse(course1);
        module.addCourse(course2);
        module.removeCourse(course2);
        
        List<Course> coursesAssociated = module.getCoursesAssociated();
        
        assertTrue(!coursesAssociated.contains(course2));
    }
}
