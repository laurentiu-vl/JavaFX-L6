package sample;

import java.util.List;

public class Student extends Person
{
    private long studentID;
    private int totalCredits;
    private List <Course> enrolledCourses;


    Student(String nume, String numedefamilie, long Idstudent, int credite, List EnrolledCourses)
    {
        firstname=nume;
        lastname=numedefamilie;
        studentID = Idstudent;
        totalCredits= credite;
        enrolledCourses= EnrolledCourses;
    }

    Student(int credite)
    {
        totalCredits= credite;
    }

    public long getStudentID() {
        return studentID;
    }

    public int getTotalCredits() {
        return totalCredits;
    }

    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    long getterStudentID()
    {
        return studentID;
    }

    int gettertotalCredits()
    {
        return  totalCredits;
    }

    List <Course> getterEnrolledCourses()
    {
        return enrolledCourses;
    }

    void setterStudentID(long newStudentid)
    {
        studentID = newStudentid;
    }

    void setterTotalCredits(int newTotalCredits)
    {
        totalCredits= newTotalCredits;
    }

    void setterEnrolledCourses(List <Course> newCourses)
    {
        enrolledCourses = newCourses;
    }

    void deleteCourse(Course curs) //sterge cursul studentului
    {
        enrolledCourses.remove(curs);
        setterTotalCredits(gettertotalCredits()-curs.getCredit()); //updateaza numarul creditelor fiecarui student
    }

}
