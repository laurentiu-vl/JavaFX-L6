package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class StudentLoginController implements Initializable {

    //Reference to the student app controller
    private StudentAppController studentController;

    public void setStudentController(StudentAppController studentController) {
        this.studentController = studentController;
    }

    @FXML
    public TextField nameText;
    @FXML
    public TextField famnameText;
    @FXML
    public Button acceptButton;

    private Student loggedStudent;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void startStudentWindow() throws IOException {

        //Verify Input
        if(nameText.getText().equals("") || famnameText.getText().equals("") ){

            return;
        }

        String name = nameText.getText();
        String famname = famnameText.getText();

        loggedStudent  = new Student(name, famname, 1500, 0, new ArrayList<Course>());

        studentController.setLoggedStudent(loggedStudent);

        //Load Stundent View
        FXMLLoader loader = new FXMLLoader();
        loader.setController(studentController);
        loader.setLocation(StartApp.class.getResource("studentView.fxml"));
        Parent root = loader.load();

        //Set new scene for view window
        Stage stage = (Stage) acceptButton.getScene().getWindow();
        stage.setScene(new Scene(root, 600, 600));

    }
}
