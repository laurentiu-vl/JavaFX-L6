package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class StudentAppController implements Initializable {

    private Menu menu;
    private RegistrationSystem registrationSystem;
    private CourseRepo courseRepo;
    private Student loggedStudent;

    public StudentAppController(Menu view, RegistrationSystem reg){

        this.menu = view;
        this.registrationSystem = reg;
        this.courseRepo = registrationSystem.courses;
    }

    public void setLoggedStudent(Student stud){
        loggedStudent = stud;
    }

    TableColumn totalCredits = new TableColumn("Total Credite");

    @FXML
    public Button ButtonRegister;

    @FXML
    public TableView tableCredits;

    @FXML
    public TextField courseText;

    @FXML
    public TableView tableCourses;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        TableColumn name = new TableColumn("Name");
        name.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn credite = new TableColumn("Credit");
        credite.setCellValueFactory(new PropertyValueFactory<>("credit"));

        tableCourses.getColumns().addAll(name, credite);

        for(int i = 0; i<courseRepo.getCourses().size(); i++)
        {
            tableCourses.getItems().add(courseRepo.getCourses().get(i));
        }

        loggedStudent.setterTotalCredits(0);
        tableCredits.getColumns().addAll(totalCredits);
        totalCredits.setCellValueFactory(new PropertyValueFactory<>("totalCredits"));
        tableCredits.getItems().add(loggedStudent);
    }

    //Button for registering to a Course
    public void registerToCourse()
    {
        Course registerCourse = registrationSystem.courses.getCourses().stream().filter(course -> course.getName().toLowerCase().equals(courseText.getText().toLowerCase())).findFirst().get();

        boolean verify = registrationSystem.register(registerCourse,loggedStudent);
        if(!verify)
        {
            Alert errorRegister = new Alert(Alert.AlertType.ERROR, "ERROR!!! You already registered to this course OR you have too many credits");
            errorRegister.setTitle("Error");
            errorRegister.showAndWait();
        }

        registrationSystem.register(registerCourse,loggedStudent);
        totalCredits.setCellValueFactory(new PropertyValueFactory<>("totalCredits"));
        tableCredits.getItems().clear();
        tableCredits.getItems().add(loggedStudent);
    }
}
