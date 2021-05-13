package com.pocket.controllers;

import com.pocket.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import com.pocket.services.UserService;

import java.io.IOException;
import java.util.List;

public class LoginController {
    @FXML
    private Text registrationMessage;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField usernameField;
    @FXML
    private ImageView logo;
    @FXML
    private Button Register;
    @FXML
    private Button Login;
    @FXML
    private Button Close;
    @FXML

    public void handleLoginAction() throws IOException {
        String password = UserService.loginEncode(usernameField.getText(),passwordField.getText());
        List<User> users = UserService.loadUsersFromFile2();
        boolean userFound = false;
        for(User it : users )
        {
            if(usernameField.getText().compareTo(it.getUsername())==0 && password.compareTo(it.getPassword())==0)
            {
                userFound = true;
                registrationMessage.setText("Login successful!");
                handleLoginButton();
                break;
            }
        }
        if(userFound==false)
        {
            registrationMessage.setText("Username or password incorrect!");
        }
    }

    @FXML
    public void handleRegisterAction()
    {
        Stage stage;
        Parent root;
        try{

            stage = (Stage) Register.getScene().getWindow();
            root = FXMLLoader.load(getClass().getClassLoader().getResource("SelectRole.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch(Exception e) {
            e.printStackTrace();
            e.getCause();
        }

    }

    public void handleLoginButton()
    {
        Stage stage;
        Parent root;
        try{

            stage = (Stage) Login.getScene().getWindow();
            root = FXMLLoader.load(getClass().getClassLoader().getResource("ClientProfile.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch(Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }
    public void handleCloseAction(ActionEvent event)
    {
        Stage stage;
        try{
        stage = (Stage) Close.getScene().getWindow();
        stage.close();
        } catch(Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }
}
