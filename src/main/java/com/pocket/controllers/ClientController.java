package com.pocket.controllers;

import com.pocket.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ClientController {
    @FXML
    private Button Close;
    @FXML
    private Button AddFood;
    @FXML
    private Button ChooseNutritionist;
    @FXML
    private Button Account;
    @FXML
    private Text ClientName;
    @FXML
    private Text TotalCaloriesText;
    @FXML
    private Text CaloriesLeftText;
    @FXML
    private Text CaloriesText;
    @FXML
    private Button CheckMacros;

    private int TotalCalories;
    private int Calories;
    private int CaloriesLeft;

    public void initialize(User user)
    {
        ClientName.setText(user.getFullName());
        TotalCalories = user.getCalories();
        Calories = 0;
        CaloriesLeft = user.getCalories();
        setTexts();
    }

    private void setTexts()
    {
        TotalCaloriesText.setText(String.valueOf(TotalCalories));
        CaloriesText.setText(String.valueOf(Calories));
        CaloriesLeftText.setText(String.valueOf(CaloriesLeft));
        //
    }

    public void addCalorie(int calorie)
    {
        Calories = Calories + calorie;
        CaloriesLeft = CaloriesLeft - calorie;
    }
    @FXML
    public void handleAddFoodAction()
    {
        Stage stage;
        Parent root;
        try{

            stage = (Stage) AddFood.getScene().getWindow();
            root = FXMLLoader.load(getClass().getClassLoader().getResource("AddFood.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch(Exception e) {
            e.printStackTrace();
            e.getCause();
        }

    }

    public void handleLoginAction()
    {

    }
    @FXML
    public void handleAccountAction()
    {
        Stage stage;
        Parent root;
        try{

            stage = (Stage) Account.getScene().getWindow();
            root = FXMLLoader.load(getClass().getClassLoader().getResource("AccountDetails.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch(Exception e) {
            e.printStackTrace();
            e.getCause();
        }


    }
    @FXML
    public void handleCheckMacrosAction()
    {
        Stage stage;
        Parent root;
        try{

            stage = (Stage) CheckMacros.getScene().getWindow();
            root = FXMLLoader.load(getClass().getClassLoader().getResource("Macronutrients.fxml"));
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
