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
import javafx.stage.StageStyle;

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
    @FXML
    private Button LoginScreen;

    private int TotalCalories;
    private int Calories;
    private int CaloriesLeft;
    private double TotalCarbs;
    private double TotalFats;
    private double TotalProteins;

    private User user;


    public void initialize(User user)
    {
        this.user = user;
        ClientName.setText(user.getFullName());
        TotalCalories = user.getCalories();
        Calories = 0;
        CaloriesLeft = user.getCalories();
        TotalCarbs = 0;
        TotalFats = 0;
        TotalProteins = 0;
        setTexts();
    }

    public void initialize2(User user, int calories, double fats, double carbs, double proteins)
    {
        this.user = user;
        ClientName.setText(user.getFullName());
        TotalCalories = calories;
        TotalFats = fats;
        TotalCarbs = carbs;
        TotalProteins = proteins;
        Calories = user.getCalories() - calories;
        CaloriesLeft = calories;
        setTexts();
    }

    private void setTexts()
    {
        TotalCaloriesText.setText(String.valueOf(user.getCalories()));
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
        FXMLLoader loader;
        try{

            stage = (Stage) AddFood.getScene().getWindow();
            loader = new FXMLLoader(getClass().getResource("/AddFood.fxml"));
            stage.setScene(new Scene(loader.load()));
            AddFood controller = loader.getController();
            controller.loadInfo(user,TotalCalories,TotalFats,TotalCarbs,TotalProteins);

            stage.show();

        } catch(Exception e) {
            e.printStackTrace();
            e.getCause();
        }

    }

    @FXML
    public void handleAccountAction()
    {
        Stage stage;
        FXMLLoader loader;
        try{

            stage = (Stage) Account.getScene().getWindow();
            loader = new FXMLLoader(getClass().getResource("/AccountDetails.fxml"));
            stage.setScene(new Scene(loader.load()));
            AccountDetails controller = loader.getController();
            controller.initialize(user,TotalCalories,TotalFats,TotalCarbs,TotalProteins);

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
        FXMLLoader loader;
        try{

            stage = (Stage) CheckMacros.getScene().getWindow();
            loader = new FXMLLoader(getClass().getResource("/Macronutrients.fxml"));
            stage.setScene(new Scene(loader.load()));
            Macronutrients controller = loader.getController();
            controller.initialize(user,TotalCalories,TotalCarbs,TotalFats,TotalProteins);

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
