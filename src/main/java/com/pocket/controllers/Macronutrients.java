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

public class Macronutrients {
    @FXML
    private Button Close;
    @FXML
    private Button Back;
    @FXML
    private Text Carbs;
    @FXML
    private Text Fats;
    @FXML
    private Text Proteins;

    private int TotalCalories;
    private double TotalCarbs;
    private double TotalFats;
    private double TotalProteins;
    private User user;

    @FXML
    public void initialize(User user,int calories, double carbs, double fats, double proteins)
    {
        this.user = user;
        TotalCalories = calories;
        TotalCarbs = carbs;
        TotalFats = fats;
        TotalProteins = proteins;
        Carbs.setText(String.format("%.1f",carbs));
        Fats.setText(String.format("%.1f",fats));
        Proteins.setText(String.format("%.1f",proteins));
    }



    @FXML
    public void handleBackButton()
    {
        Stage stage;
        FXMLLoader root;
        try {

            stage = (Stage) Back.getScene().getWindow();
            root = new FXMLLoader(getClass().getResource("/Client.fxml"));
            Scene scene = new Scene(root.load());
            stage.setScene(scene);
            ClientController controller = root.getController();
            controller.initialize2(user,TotalCalories,TotalFats,TotalCarbs,TotalProteins);

            stage.show();

        } catch (Exception e) {
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
