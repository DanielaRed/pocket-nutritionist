package com.pocket.controllers;

import com.pocket.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
    private Button profile;
    @FXML
    private Text ClientName;
    @FXML
    private Text TotalCaloriesText;
    @FXML
    private Text CaloriesLeftText;
    @FXML
    private Text CaloriesText;

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
    }

    public void addCalorie(int calorie)
    {
        Calories = Calories + calorie;
        CaloriesLeft = CaloriesLeft - calorie;
    }

    public void handleAddFoodAction()
    {

    }

    public void handleLoginAction()
    {

    }

    public void handleProfileAction()
    {

    }



    @FXML
    public void handleCloseAction(ActionEvent event)
    {
        Stage stage;

        stage = (Stage) Close.getScene().getWindow();
        stage.close();

    }





}
