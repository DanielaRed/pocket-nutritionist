package com.pocket.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

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
    public void handleLoginAction() {

    }
    @FXML
    public void handleRegisterAction()
    {
        try{

            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("register.fxml"));
            Stage registerStage = new Stage();
            registerStage.setScene(new Scene(root, 600, 400));
            registerStage.setTitle("Pocket Nutritionist - Register");
            registerStage.show();

        } catch(Exception e) {
            e.printStackTrace();
            e.getCause();
        }

    }
}
