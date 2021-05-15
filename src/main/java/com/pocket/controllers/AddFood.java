package com.pocket.controllers;

import com.pocket.model.User;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import com.pocket.model.Food;

import java.util.ArrayList;

public class AddFood {

    @FXML
    private Button Close;
    @FXML
    private Button Back;
    @FXML
    private Button Add;
    @FXML
    private ChoiceBox food_items;
    @FXML
    private ChoiceBox no_servings;
    @FXML
    private Text Carbs;
    @FXML
    private Text Fat;
    @FXML
    private Text Proteins;
    @FXML
    private Text Calories;


    Food food_list[] =  {
            new Food("Bread", "1 slice", 24, 1.5, 5, 130),
            new Food("Cheese", "1 slice", 4, 7, 6, 100),
            new Food("Chicken Breast", "100g",2.1,1,22,105),
            new Food("Banana", "Medium", 27,0.4,1.3,105),
            new Food("Milk","100 ml",12,0,8,80),
            new Food("Black Coffee","100 ml",0,0,0,20),
            new Food("Pork","100 g",0.1,34.6,14.2,386),
            new Food("Roasted Duck","100 g",0,60.5,17.7,636)
    };

    private double No_Carbs;
    private double No_Fats;
    private double No_Proteins;
    private int No_Calories;

    private double TotalCarbs;
    private double TotalFats;
    private double TotalProteins;
    private int TotalCalories;
    private User user;




    @FXML
    public void initialize() {
        No_Carbs = 0;
        No_Fats = 0;
        No_Proteins = 0;

        ArrayList<String> foods = new ArrayList<String>();
        for(Food it : food_list)
        {
            foods.add(it.getName());
        }

        no_servings.setValue("1");
        food_items.getItems().addAll(FXCollections.observableArrayList(foods));
        no_servings.getItems().addAll(FXCollections.observableArrayList("1","2","3","4"));
        food_items.setOnAction((event1) ->
        {
            for (Food it : food_list) {
                if (it.getName().compareTo(food_items.getSelectionModel().getSelectedItem().toString()) == 0) {
                    No_Carbs = it.getCarbs() * (Integer.parseInt(no_servings.getSelectionModel().getSelectedItem().toString()));
                    No_Fats = it.getFat() * (Integer.parseInt(no_servings.getSelectionModel().getSelectedItem().toString()));
                    No_Proteins = it.getProtein() * (Integer.parseInt(no_servings.getSelectionModel().getSelectedItem().toString()));
                    No_Calories = it.getCalories() * (Integer.parseInt(no_servings.getSelectionModel().getSelectedItem().toString()));

                    Carbs.setText(String.format("%.1f",No_Carbs));
                    Fat.setText(String.format("%.1f",No_Fats));
                    Proteins.setText(String.format("%.1f",No_Proteins));
                    Calories.setText(No_Calories + "");

                    break;
                }
            }

            no_servings.setOnAction((event2) -> {
                for (Food it : food_list) {
                    if (it.getName().compareTo(food_items.getSelectionModel().getSelectedItem().toString()) == 0) {
                        No_Carbs = it.getCarbs() * (Integer.parseInt(no_servings.getSelectionModel().getSelectedItem().toString()));
                        No_Fats = it.getFat() * (Integer.parseInt(no_servings.getSelectionModel().getSelectedItem().toString()));
                        No_Proteins = it.getProtein() * (Integer.parseInt(no_servings.getSelectionModel().getSelectedItem().toString()));
                        No_Calories = it.getCalories() * (Integer.parseInt(no_servings.getSelectionModel().getSelectedItem().toString()));

                        Carbs.setText(String.format("%.1f",No_Carbs));
                        Fat.setText(String.format("%.1f",No_Fats));
                        Proteins.setText(String.format("%.1f",No_Proteins));
                        Calories.setText(No_Calories + "");

                        break;
                    }


                }


            });
        });

    }
    @FXML
    public void loadInfo(User user,int calories, double fats, double carbs, double proteins)
    {
        this.user = user;
        TotalCalories = calories;
        TotalFats = fats;
        TotalCarbs = carbs;
        TotalProteins = proteins;

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
    public void handleAddButton(ActionEvent event)
    {
        TotalCalories = TotalCalories - No_Calories;
        TotalFats = TotalFats + No_Fats;
        TotalCarbs = TotalCarbs + No_Carbs;
        TotalProteins = TotalProteins + No_Proteins;

    }

    @FXML
    public void handleCloseAction(ActionEvent event)
    {
        Stage stage;

        stage = (Stage) Close.getScene().getWindow();
        stage.close();

    }
}
