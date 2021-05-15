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

public class AccountDetails {
    @FXML
    private Button Close;
    @FXML
    private Button Back;
    @FXML
    private Text FullName;
    @FXML
    private Text DateOfBirth;
    @FXML
    private Text Height;
    @FXML
    private Text Weight;
    @FXML
    private Text Gender;
    @FXML
    private Text Email;
    @FXML
    private Text DietType;
    @FXML
    private Text Allergies;
    @FXML
    private Text Phone;

    private int TotalCalories;
    private double TotalCarbs;
    private double TotalFats;
    private double TotalProteins;
    private User user;

    @FXML
    public void initialize(User user, int calories, double carbs, double fats, double proteins)
    {
        this.user = user;
        TotalCalories = calories;
        TotalCarbs = carbs;
        TotalFats = fats;
        TotalProteins = proteins;

        FullName.setText(user.getFullName());
        DateOfBirth.setText(String.format("%d.%d.%d",user.getDay(),user.getMonth(),user.getYear()));
        Height.setText(user.getHeight());
        Weight.setText(user.getWeight());
        Gender.setText(user.getGender());
        Email.setText(user.getEmail());
        DietType.setText(user.getDietType());
        if(user.getAllergies().compareTo("")==0)
        {
            Allergies.setText("None");
        }
        else Allergies.setText(user.getAllergies());

        Phone.setText(user.getPhoneNumber());




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
