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
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import com.pocket.services.UserService;

public class ClientProfile {
    @FXML
    private ChoiceBox role;

    @FXML
    private Button next;
    @FXML
    private Button back;


    @FXML
    public void initialize() {
        role.getItems().addAll("Client", "Nutritionist");
    }

    public void loadMenu() throws Exception
    {
        Stage stage;
        Parent root;

        if((String) role.getValue() == "Client") {
            //UserService.loadUsersFromFile();

            stage = (Stage) next.getScene().getWindow();
            root = FXMLLoader.load(getClass().getClassLoader().getResource("ClientRegistration.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        }

        if((String) role.getValue() == "Nutritionist") {
            // UserService.loadUsersFromFile();

            //Stage primaryStage = new Stage();
            stage = (Stage) next.getScene().getWindow();
            root = FXMLLoader.load(getClass().getClassLoader().getResource("NutritionistRegistration.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }


    }


}
