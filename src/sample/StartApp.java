package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

/**
 * Main class where program starts.
 */
public class StartApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        //INITIALIZE DATABASE WITH SOME DATA

        List<Course> ListCourse1 = new ArrayList<Course>();
        List<Course> ListCourse2 = new ArrayList<Course>();
        List<Course> ListCourse3 = new ArrayList<Course>();
        List<Course> ListCourse4 = new ArrayList<Course>();
        List<Course> ListCourse5 = new ArrayList<Course>();

        Teacher Teacher = new Teacher("Tudor", "Dragos", ListCourse1);
        Teacher Teacher1 = new Teacher("Faur", "Ion", ListCourse4);

        Student Student1 = new Student("Ana", "Anina",1, 8, ListCourse2);
        Student Student2 = new Student("Marcel", "Olar",2, 14, ListCourse3);
        Student Student3 = new Student("Tavi", "Merge",3, 11, ListCourse5);

        List <Student> listastudenti1 = new ArrayList<Student>();
        List <Student> listastudenti2 = new ArrayList<Student>();
        List <Student> listastudenti3 = new ArrayList<Student>();

        Course Course1 = new Course("Biologie", Teacher, 100, listastudenti1, 6);
        Course Course2 = new Course("Matematica", Teacher1, 150, listastudenti2, 6);
        Course Course3 = new Course("Info", Teacher, 200, listastudenti3, 6);

        List <Course> listWithCourses = new ArrayList<Course>();
        listWithCourses.add(Course1);
        listWithCourses.add(Course2);
        listWithCourses.add(Course3);

        CourseRepo courseRepo = new CourseRepo(listWithCourses);

        RegistrationSystem registrationSystem = new RegistrationSystem(courseRepo);

        registrationSystem.register(Course1, Student3);
        registrationSystem.register(Course1, Student2);
        registrationSystem.register(Course3, Student1);
        registrationSystem.register(Course2, Student1);

        // EXIT INITIALIZE

        //INITIALIZE CONTROLLER AND VIEW
        Menu menu = new Menu();
        StudentAppController controller = new StudentAppController(menu, registrationSystem);

        //LOG IN WITH WINDOW

        FXMLLoader loader = new FXMLLoader(getClass().getResource("studentLogin.fxml"));
        FXMLLoader teacherLoader = new FXMLLoader(getClass().getResource("teacherLogin.fxml"));
        Parent root = loader.load();
        Parent teacherRoot = teacherLoader.load();
        StudentLoginController loginController = loader.getController();
        TeacherLoginController teacherLoginController = teacherLoader.getController();
        //Send the reference to the student app controller
        loginController.setStudentController(controller);
        teacherLoginController.setRegSystem(registrationSystem);
        //Load the teacher window
        Stage teacherStage = new Stage();
        teacherStage.setTitle("Teacher Login");
        teacherStage.setScene(new Scene(teacherRoot, 750, 600));
        teacherStage.show();

        stage.setTitle("Student Login");
        stage.setScene(new Scene(root,650,550));
        stage.show();
    }

    /**
     * Start point of the application
     * @param args command line arguments
     */
    public static void main(String[] args)
    {
        launch(args);
    }
}
