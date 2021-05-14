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
import javafx.stage.StageStyle;

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
        for(User it : users ) {
            if (usernameField.getText().compareTo(it.getUsername()) == 0 && password.compareTo(it.getPassword()) == 0) {
                userFound = true;
                if (it.getRole().compareTo("Client") == 0) {
                    Stage stage;
                    FXMLLoader root;
                    try {

                        stage = (Stage) Register.getScene().getWindow();
                        //stage = new Stage(StageStyle.DECORATED);
                        root = new FXMLLoader(getClass().getResource("/Client.fxml"));
                        Scene scene = new Scene(root.load());
                        stage.setScene(scene);
                        ClientController controller = root.getController();
                        controller.initialize(it);

                        stage.show();
                        //return stage;

                    } catch (Exception e) {
                        e.printStackTrace();
                        e.getCause();
                    }
                }
                //registrationMessage.setText("Login successful!");
                //handleLoginButton();
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

    @FXML
    public void handleCloseAction(ActionEvent event)
    {
        Stage stage;

        stage = (Stage) Close.getScene().getWindow();
        stage.close();

    }
}
