package lab04;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;

public class Controller {

    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private TextField nameField;
    @FXML private TextField emailField;
    @FXML private DatePicker dateField;
    @FXML private TextField phoneField;

    @FXML protected void handleRegisterButton (ActionEvent event){
        String username = usernameField.getText();
        System.out.println("Username: " + username);

        String password = passwordField.getText();
        System.out.println("Password: " + password);

        String name = nameField.getText();
        System.out.println("Full Name: " + name);

        String email = emailField.getText();
        System.out.println("E-Mail: " + email);

        String phone = phoneField.getText();
        System.out.println("Phone #: " + phone);

        LocalDate date = dateField.getValue();
        System.out.println("Date of Birth: " + date);
    }
}
