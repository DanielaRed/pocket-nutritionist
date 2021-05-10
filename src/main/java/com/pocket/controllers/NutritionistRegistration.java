package com.pocket.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import com.pocket.services.UserService;
import com.pocket.exceptions.*;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

import static org.apache.commons.io.FileUtils.copyFile;

public class NutritionistRegistration {

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
    private Button back;

    private String Document;




    @FXML
    public void initialize() {

        DatePicker DateOfBirth = new DatePicker();
        HBox hbox = new HBox(DateOfBirth);
    }




    @FXML
    public void selectImage() throws IOException
    {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Document File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif")
        );
        File selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile != null) {
            //System.out.println(selectedFile.toString());
            Document = selectedFile.toString();
        }
    }



    @FXML
    public void handleRegisterAction() {
        try {
            LocalDate date = DateOfBirth.getValue();

            UserService.addUser(usernameField.getText(), passwordField.getText(), "Nutritionist", date, PhoneNumber.getText(),Email.getText(), false, Document);
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
        catch (NoFileSelectedException e) {
            registrationMessage.setText(e.getMessage());
        }
        catch (IOException e) {
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
}