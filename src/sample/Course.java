package sample;

import java.util.List;

public class Course
{
    private String name;
    private Teacher teacher;
    private int maxEnrollment;
    private List<Student> studentsEnrolled;
    private int credits;

    Course(String nameCourse, Teacher nameTeacher, int maxEnroll, List studentsEnroll, int nr_credits)
    {
        name = nameCourse;
        teacher = nameTeacher;
        maxEnrollment = maxEnroll;
        studentsEnrolled= studentsEnroll;
        this.credits = nr_credits;
        teacher.getCourses().add(this);
    }

    Course()
    {}

    //getters
    public String getName() {
        return name;
    }

    String getterName()
    {
        return name;
    }

    Teacher getterTeacher()
    {
        return teacher;
    }

    int getterMaxEnrollment()
    {
        return maxEnrollment;
    }

    public List <Student> getterStudentsEnrolled()
    {
        return studentsEnrolled;
    }

    public List <Student> getStudentsEnrolled() { return studentsEnrolled; }

    public int getCredit() { return credits; }

    //setters
    public void setterCredits(int credits) {
        this.credits = credits;
    }

    void setterName(String newName)
    {
        name = newName;
    }

    void setterTeacher(Teacher newTeacher)
    {
        teacher = newTeacher;
    }

    void setterMaxEnrollment(int newMaxEnrollment)
    {
        maxEnrollment= newMaxEnrollment;
    }

    void setterStudentsEnrolled(List newstudentsEnrolled)
    {
        studentsEnrolled = newstudentsEnrolled;
    }

    void insertStudent(Student newStudent)
    {
        studentsEnrolled.add(newStudent);
    }
}