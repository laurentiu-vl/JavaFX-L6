package sample;

//import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

//import CourseRepo;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class allTests {

    RegistrationSystem registrationSystem1;
    Student student1;
    Student student2;
    Student student3;
    Course Desen;
    Course Info;
    Course OOP;
    CourseRepo courseRepo;
    List<Student> studentslist1;
    List<Student> studentslist2;
    List<Student> studentslist3;

    @BeforeEach
    public void setUp(){
        List<Course> CourseList1 = new ArrayList<Course>();
        List<Course> CourseList2 = new ArrayList<Course>();
        List<Course> CourseList3 = new ArrayList<Course>();

        Teacher teacher1 = new Teacher("Stefan", "Rusu", CourseList1);
        Teacher teacher2 = new Teacher("Vasile", "Huiu", CourseList3);

        student1 = new Student("Matei", "Popescu",1, 12, CourseList1);
        student2 = new Student("Andrei", "Ionescu",2, 6, CourseList2);
        student3 = new Student("Alex", "Paiu",3, 10, CourseList3);

        studentslist1 = new ArrayList<Student>();
        studentslist2 = new ArrayList<Student>();
        studentslist3 = new ArrayList<Student>();

        Desen = new Course("Desen", teacher1, 150, studentslist1, 7);
        Info = new Course("Info", teacher2, 180, studentslist2, 7);
        OOP = new Course("OOP", teacher2, 200, studentslist3, 6);

        List <Course> courseslist = new ArrayList<Course>();
        courseslist.add(Desen);
        courseslist.add(Info);
        courseslist.add(OOP);

        courseRepo = new CourseRepo(courseslist);

        registrationSystem1 = new RegistrationSystem(courseRepo);

        registrationSystem1.register(OOP, student1);
        registrationSystem1.register(Info, student2);
        registrationSystem1.register(Desen, student1);
        registrationSystem1.register(Desen, student3);

    }

    @Test
    public void testGettersAndSetters() {
        List<Course> listCourses = new ArrayList<Course>();
        Teacher teacher = new Teacher("Marin", "Sorescu", listCourses);
        assertEquals("Marin", teacher.getterFirstname());
        assertEquals("Sorescu", teacher.getterFamName());

        teacher.setterFirstname("Andrei");
        teacher.setterFamName("Pop");
        assertEquals("Andrei", teacher.getterFirstname());
        assertEquals("Pop", teacher.getterFamName());

        assertNotNull(teacher.getterCourses());

        Student stud = new Student("Marin", "Sorescu", 1, 15, listCourses);
        assertEquals("Marin", stud.getterFirstname());
        assertEquals("Sorescu", stud.getterFamName());

        stud.setterFirstname("Andrei");
        stud.setterFamName("Pop");
        assertEquals("Andrei", stud.getterFirstname());
        assertEquals("Pop", stud.getterFamName());

        assertNotNull(stud.getterEnrolledCourses());

    }

    @Test
    public void Registr()
    {
        List<Course> CourseList1 = new ArrayList<Course>();
        List<Course> CourseList2 = new ArrayList<Course>();
        List<Course> CourseList3 = new ArrayList<Course>();

        Teacher teacher1 = new Teacher("Stefan", "Rusu", CourseList1);
        Teacher teacher2 = new Teacher("Vasile", "Huiu", CourseList3);

        Student student1 = new Student("Matei", "Popescu",1, 12, CourseList1);
        Student student2 = new Student("Andrei", "Ionescu",2, 6, CourseList2);
        Student student3 = new Student("Alex", "Paiu",3, 27, CourseList3);

        List<Student> studentslist1 = new ArrayList<Student>();
        List<Student> studentslist2 = new ArrayList<Student>();
        List<Student> studentslist3 = new ArrayList<Student>();

        Course Desen = new Course("Desen", teacher1, 150, studentslist1, 7);
        Course Info = new Course("Info", teacher2, 180, studentslist2, 7);
        Course OOP = new Course("OOP", teacher2, 200, studentslist3, 6);

        List <Course> courseslist = new ArrayList<Course>();
        courseslist.add(Desen);
        courseslist.add(Info);
        courseslist.add(OOP);

        CourseRepo courseRepo = new CourseRepo(courseslist);

        RegistrationSystem registrationSystem1 = new RegistrationSystem(courseRepo);

        registrationSystem1.register(OOP, student1);
        registrationSystem1.register(Info, student2);
        registrationSystem1.register(Desen, student1);
        registrationSystem1.register(Desen, student3);

        assertFalse(registrationSystem1.register(Desen, student1));
        assertFalse(registrationSystem1.register(Info, student2));
        assertFalse(registrationSystem1.register(Desen, student3));
    }

}