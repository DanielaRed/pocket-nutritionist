package pocket_nutri.registration.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import pocket_nutri.registration.exceptions.EmptyEntryException;
import pocket_nutri.registration.exceptions.InvalidEmailException;
import pocket_nutri.registration.exceptions.InvalidPhoneNumberException;
import pocket_nutri.registration.exceptions.UsernameAlreadyExistsException;
import pocket_nutri.registration.services.UserService;

import java.time.LocalDate;

public class ClientRegistration {

    @FXML
    private Text registrationMessage;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField usernameField;
    @FXML
    private DatePicker DateOfBirth;
    @FXML
    private TextField PhoneNumber;
    @FXML
    private TextField Email;



    @FXML
    public void initialize() {

        DatePicker DateOfBirth = new DatePicker();
        HBox hbox = new HBox(DateOfBirth);
    }

    @FXML
    public void handleRegisterAction() {
        try {
            LocalDate date = DateOfBirth.getValue();

            UserService.addUser(usernameField.getText(), passwordField.getText(), "Client", date, PhoneNumber.getText(),Email.getText(), true);
            registrationMessage.setText("Account created successfully!");
        } catch (UsernameAlreadyExistsException e) {
            registrationMessage.setText(e.getMessage());
        }
        catch (InvalidPhoneNumberException e) {
            registrationMessage.setText(e.getMessage());
        }
        catch (InvalidEmailException e) {
            registrationMessage.setText(e.getMessage());
        }
        catch (EmptyEntryException e) {
            registrationMessage.setText(e.getMessage());
        }


    }
}
