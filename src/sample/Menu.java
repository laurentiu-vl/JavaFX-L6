package sample;

import java.util.List;

public class Menu {

    public void printMenu(){

        System.out.println("1. Enroll to a course");
        System.out.println("2. List of students enrolled to a course");
        System.out.println("3. List of enrolled students and their credits");
        System.out.println("4. Delete course (Teacher mode)");
        System.out.println("0. Exit");
    }

    public void printCourses(List<Course> courses)
    {
        for(int i = 0; i < courses.size(); i++)
            System.out.println(courses.get(i).getterName());
    }

    public void printCoursesAndNumbers(List<Course> courses)
    {
        for(int i = 0; i < courses.size(); i++)
        {
            System.out.println(courses.get(i).getterName());
            System.out.println("Rooms: ");
            System.out.println(courses.get(i).getterMaxEnrollment() - courses.get(i).getterStudentsEnrolled().size());
        }
    }

    public void printStudentsAndCredits(List<Student> students)
    {
        for(Student stud : students)
        {
            System.out.println(stud.firstname + ' ' + stud.lastname);
            System.out.println(stud.gettertotalCredits());
        }
    }

    public void printStudentsForCourse(Course course)
    {
        List<Student> students = course.getterStudentsEnrolled();
        System.out.println(course.getterName());
        for(int i =0; i < students.size(); i++)
        {
            System.out.println(students.get(i).firstname + ' ' + students.get(i).lastname);
        }
    }
}
