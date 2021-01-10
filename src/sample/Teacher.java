package sample;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends Person
{
    private List<Course> courses = new ArrayList<>();

    Teacher(String name, String fam_name, List<Course> cours) {
        firstname = name;
        lastname = fam_name;
        courses = cours;
    }

    Teacher(String name, String fam_name){
        firstname = name;
        lastname = fam_name;
    }

    Teacher(List Curs)
    {
        courses = Curs;
    }

    public List<Course> getCourses()
    {
        return courses;
    }

    //getter Courses
    List<Course> getterCourses()
    {
        return  courses;
    }

    //setter Courses
    void setterCourses(List<Course> newCourses)
    {
        courses = newCourses;
    }

    //remove 1 Course from the list
    void deleteCourses(Course toRemove)
    {
        courses.remove(toRemove);

        for(int i=1; i<toRemove.getterStudentsEnrolled().size(); i++) {
            toRemove.getterStudentsEnrolled().get(i).deleteCourse(toRemove);
        }
        List<Student> emptylist = new ArrayList<Student>();

        toRemove.setterStudentsEnrolled(emptylist);
    }
}
