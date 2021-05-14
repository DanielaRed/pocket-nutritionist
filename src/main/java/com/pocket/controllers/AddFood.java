package com.pocket.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import com.pocket.model.Food;

public class AddFood {

    @FXML
    private Button Close;
    @FXML
    private Button Back;
    @FXML
    private Button Add;

    Food food_list[] =  {
            new Food("Bread", "1 slice", 24, 1.5, 5, 130),
            new Food("Cheese", "1 slice", 4, 7, 6, 100),
            new Food("Chicken Breast", "100g",2.1,1,22,105),
            new Food("Banana", "Medium", 27,0.4,1.3,105),
            new Food("Milk","100 ml",12,0,8,80)
    };



    @FXML
    public void handleAddButton()
    {

    }

    @FXML
    public void handleBackButton()
    {
        Stage stage;
        Parent root;
        try{

            stage = (Stage) Back.getScene().getWindow();
            root = FXMLLoader.load(getClass().getClassLoader().getResource("Client.fxml"));
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
