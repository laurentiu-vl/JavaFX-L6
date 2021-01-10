package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TeacherLoginController implements Initializable {

    @FXML
    public TextField nameText;
    @FXML
    public TextField famnameText;
    @FXML
    public Button acceptButton;

    private RegistrationSystem regSystem;

    private TeacherAppController teacherController;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void startTeacherWindow() throws IOException {

        //Verify Input
        if(nameText.getText().equals("") || famnameText.getText().equals("") ){
            return;
        }
        if(regSystem == null){
            return;
        }

        String name = nameText.getText();
        String surname = famnameText.getText();

        Teacher loggedTeacher = null;

        //Try to log in with the entered data
        try {
            loggedTeacher = regSystem.courses.getCourses().stream()
                    .filter(course ->
                            course.getterTeacher().firstname.toLowerCase().equals(name.toLowerCase()))
                    .filter(course -> course.getterTeacher().lastname.toLowerCase().equals(surname.toLowerCase()))
                    .findFirst().get().getterTeacher();
        }
        catch(Exception exc){
            Alert error = new Alert(Alert.AlertType.ERROR, "Teacher does not exist!");
            error.showAndWait();
            return;
        }

        if(loggedTeacher == null) {
            return;
        }

        teacherController = new TeacherAppController();
        teacherController.setLoggedTeacher(loggedTeacher);
        teacherController.setRegistrationSystem(regSystem);

        FXMLLoader loader = new FXMLLoader();
        loader.setController(teacherController);
        loader.setLocation(StartApp.class.getResource("teacherView.fxml"));
        Parent root = loader.load();
        //Get the current stage so you can change the scene
        Stage stage = (Stage) acceptButton.getScene().getWindow();
        stage.setScene(new Scene(root, 600, 600));
    }

    public void setRegSystem(RegistrationSystem reg){
        regSystem = reg;
    }
}