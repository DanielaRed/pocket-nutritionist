package com.pocket.controllers;

import com.pocket.exceptions.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import com.pocket.services.UserService;
import javafx.stage.Stage;

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
    private TextField FullName;
    @FXML
    private ChoiceBox Gender;
    @FXML
    private TextField Height;
    @FXML
    private TextField Weight;
    @FXML
    private TextField Allergies;
    @FXML
    private  ChoiceBox DietType;
    @FXML
    private Button back;
    @FXML
    private Button LoginScreen;


    @FXML
    public void initialize() {

        DatePicker DateOfBirth = new DatePicker();
        HBox hbox = new HBox(DateOfBirth);
        Gender.getItems().addAll("Female", "Male");
        DietType.getItems().addAll("Normal", "Muscle-Gain","Restricted");
    }

    @FXML
    public void handleRegisterAction() {
        try {
            LocalDate date = DateOfBirth.getValue();

            UserService.addClientUser(usernameField.getText(), passwordField.getText(), "Client", date, PhoneNumber.getText(),Email.getText(),FullName.getText(),Gender.getValue().toString(),Allergies.getText(),Height.getText(),Weight.getText(),DietType.getValue().toString(),true);
            registrationMessage.setText("Account created successfully!");
        } catch (UsernameAlreadyExistsException e) {
            registrationMessage.setText(e.getMessage());
        } catch (InvalidPhoneNumberException e) {
            registrationMessage.setText(e.getMessage());
        }
        catch (InvalidEmailException e) {
            registrationMessage.setText(e.getMessage());
        }
        catch (EmptyEntryException e) {
            registrationMessage.setText(e.getMessage());
        }


    }
    @FXML
    public void handleBackButton()
    {
        Stage stage;
        Parent root;
        try{

            stage = (Stage) back.getScene().getWindow();
            root = FXMLLoader.load(getClass().getClassLoader().getResource("SelectRole.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch(Exception e) {
            e.printStackTrace();
            e.getCause();
        }

    }
    @FXML
    public void handleLoginScreenButton()
    {
        Stage stage;
        Parent root;
        try{

            stage = (Stage) LoginScreen.getScene().getWindow();
            root = FXMLLoader.load(getClass().getClassLoader().getResource("LoginLauncher.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch(Exception e) {
            e.printStackTrace();
            e.getCause();
        }

    }
}