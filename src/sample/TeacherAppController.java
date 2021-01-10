package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class TeacherAppController implements Initializable {

    private Teacher loggedTeacher;

    private RegistrationSystem registrationSystem;

    public void setLoggedTeacher(Teacher loggedTeacher) {
        this.loggedTeacher = loggedTeacher;
    }

    public void setRegistrationSystem(RegistrationSystem registrationSystem) {
        this.registrationSystem = registrationSystem;
    }

    @FXML
    TableView ShowStudents;

    @FXML
    TableView ShowCourses;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        registrationSystem.setTeacherController(this);

        TableColumn firstname = new TableColumn("First Name");
        firstname.setCellValueFactory(new PropertyValueFactory<>("firstname"));

        TableColumn lastname = new TableColumn("Last Name");
        lastname.setCellValueFactory(new PropertyValueFactory<>("lastname"));

        ShowStudents.getColumns().addAll(firstname, lastname);

        TableColumn numecurs = new TableColumn("Course Name");
        numecurs.setCellValueFactory(new PropertyValueFactory<>("name"));

        ShowCourses.getColumns().addAll(numecurs);

        for (int i =0; i < loggedTeacher.getterCourses().size(); i++)
        {
            List<Student> r= loggedTeacher.getterCourses().get(i).getStudentsEnrolled();
            for(int j=0; j<r.size(); j++)
            {
                ShowStudents.getItems().add(loggedTeacher.getterCourses().get(i).getStudentsEnrolled().get(j));
                ShowCourses.getItems().add(loggedTeacher.getterCourses().get(i));
            }
        }
    }

    public void updatePanel(){
        //Remove old Information for update
        ShowStudents.getItems().clear();
        ShowCourses.getItems().clear();

        //Update panel with renewed data
        for (int i =0; i < loggedTeacher.getterCourses().size(); i++)
        {
            List<Student> r= loggedTeacher.getterCourses().get(i).getStudentsEnrolled();
            for(int j=0; j<r.size(); j++)
            {
                ShowStudents.getItems().add(loggedTeacher.getterCourses().get(i).getStudentsEnrolled().get(j));
                ShowCourses.getItems().add(loggedTeacher.getterCourses().get(i));
            }
        }
    }
}
