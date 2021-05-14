package com.pocket.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;


public class SelectRoleController {
    @FXML
    private ChoiceBox role;

    @FXML
    private Button next;
    @FXML
    private Button back;
    @FXML
    private Button LoginScreen;
    @FXML
    private Button Close;


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
            root = FXMLLoader.load(getClass().getClassLoader().getResource("NutritionistRegistrationNew.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }


    }
    @FXML
    public void handleBackButton()
    {
        Stage stage;
        Parent root;
        try{

            stage = (Stage) back.getScene().getWindow();
            root = FXMLLoader.load(getClass().getClassLoader().getResource("LoginLauncher.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch(Exception e) {
            e.printStackTrace();
            e.getCause();
        }

    }
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
    @FXML
    public void handleCloseAction(ActionEvent event)
    {
        Stage stage;

        stage = (Stage) Close.getScene().getWindow();
        stage.close();

    }

}
