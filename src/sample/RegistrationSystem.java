package sample;

import java.util.ArrayList;
import java.util.List;

public class RegistrationSystem
{
    CourseRepo courses;
    List<Student> registeredStudents;

    public void setTeacherController(TeacherAppController teacherController) {
        this.teacherController = teacherController;
    }

    private TeacherAppController teacherController;

    public RegistrationSystem(CourseRepo courses){

        this.courses = courses;
        registeredStudents = new ArrayList<>();
    }



    boolean register(Course course, Student student)
    {
        //We verify if the number of enrolledStudents exceeds the maxium allowed
        if(course.getterStudentsEnrolled().size()<course.getterMaxEnrollment())
        {
            //We verify if the student is already participating to the course
            for(int i=0; i<course.getterStudentsEnrolled().size();i++ )
            {
                if (student == course.getterStudentsEnrolled().get(i))
                {
                    System.out.println("You are already participating to this course!\n");
                    return false;
                }
            }

            //We verify if the number of maximum credits over 30
            if(student.gettertotalCredits()+course.getCredit()>30)
            {
                System.out.println("You already have 30 credits!\n");
                return false;
            }

            //We assing the student to the course and increse the number of their credits
            student.setterTotalCredits(student.gettertotalCredits()+course.getCredit());
            course.insertStudent(student);

            if(!registeredStudents.contains(student))
            {
                registeredStudents.add(student);
            }

            //Update the GUI panel
            if(teacherController != null){
                teacherController.updatePanel();
            }

            return true;
        }
        else
        {
            return false;
        }
    }

    //We print the courses with free room
    List<Course> retrieveCoursesWithFreePlaces()
    {
        List <Course> freeCourses = new ArrayList<Course>();

        for(int i = 0; i < courses.getCourses().size(); i++)
        {
            if (courses.getCourses().get(i).getterStudentsEnrolled().size()<courses.getCourses().get(i).getterMaxEnrollment()) {
                freeCourses.add(courses.getCourses().get(i));
            }
        }
        return freeCourses;
    }
}
