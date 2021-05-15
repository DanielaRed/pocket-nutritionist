package com.pocket.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pocket.model.Calories;
import com.pocket.model.User;
import com.pocket.services.FileSystemService;
import com.pocket.services.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.apache.commons.io.FileUtils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Calendar;
import java.util.List;

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
    private int Day;


    private User user;
    private List<com.pocket.model.Calories> ListCal;
    private int IndexList;


    public void initialize(User user) throws IOException
    {
        this.user = user;
        Day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        ClientName.setText(user.getFullName());
        IndexList = 0;

        if (!Files.exists(FileSystemService.getPathToFile( "calories.json"))) {
            FileUtils.copyURLToFile(ClientController.class.getClassLoader().getResource("calories.json"), FileSystemService.getPathToFile( "calories.json").toFile());
        }
        ObjectMapper objectMapper = new ObjectMapper();
        ListCal = objectMapper.readValue(FileSystemService.getPathToFile( "calories.json").toFile(), new TypeReference<List<com.pocket.model.Calories>>(){});
        boolean userFound = false;

        for(com.pocket.model.Calories it : ListCal) {
            if(user.getUsername().compareTo(it.getName())==0) {
                userFound = true;
                break;
            }
            IndexList++;
        }

        if(userFound == false)
        {
            //IndexList++;
            com.pocket.model.Calories calorie = new Calories(user.getUsername(), Calories, TotalCarbs, TotalFats, TotalProteins, Day);
            ListCal.add(calorie);
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(FileSystemService.getPathToFile("calories.json").toFile(), ListCal);
        }

        if(ListCal.get(IndexList).getDay() == Day ) {

            TotalCalories = user.getCalories();
            Calories = ListCal.get(IndexList).getCalories();
            CaloriesLeft = user.getCalories() - ListCal.get(IndexList).getCalories();
            TotalCarbs = ListCal.get(IndexList).getCarbs();
            TotalFats = ListCal.get(IndexList).getFats();
            TotalProteins = ListCal.get(IndexList).getProteins();

        }


        if(ListCal.get(IndexList).getDay() != Day ) {

            ListCal.get(IndexList).setCalories(0);
            ListCal.get(IndexList).setCarbs(0);
            ListCal.get(IndexList).setFats(0);
            ListCal.get(IndexList).setProteins(0);
            ListCal.get(IndexList).setDay(Day);
            TotalCalories = user.getCalories();
            Calories = 0;
            CaloriesLeft = TotalCalories - Calories;
            TotalCarbs = 0;
            TotalFats = 0;
            TotalProteins = 0;
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(FileSystemService.getPathToFile("calories.json").toFile(), ListCal);

        }
        setTexts();

    }

    public void initialize2(User user, int calories, double fats, double carbs, double proteins) throws IOException
    {
        this.user = user;
        ClientName.setText(user.getFullName());
        TotalCalories = calories;
        TotalFats = fats;
        TotalCarbs = carbs;
        TotalProteins = proteins;
        Calories = calories;
        CaloriesLeft = user.getCalories() - Calories;

        ObjectMapper objectMapper = new ObjectMapper();
        ListCal = objectMapper.readValue(FileSystemService.getPathToFile( "calories.json").toFile(), new TypeReference<List<com.pocket.model.Calories>>(){});
        boolean userFound = false;

        for(com.pocket.model.Calories it : ListCal) {
            if(user.getUsername().compareTo(it.getName())==0) {
                userFound = true;
                break;
            }
            IndexList++;
        }

        ListCal.get(IndexList).setCalories(TotalCalories);
        ListCal.get(IndexList).setCarbs(TotalCarbs);
        ListCal.get(IndexList).setFats(TotalFats);
        ListCal.get(IndexList).setProteins(TotalProteins);

        objectMapper.writerWithDefaultPrettyPrinter().writeValue(FileSystemService.getPathToFile("calories.json").toFile(), ListCal);

        setTexts();
    }

    private void setTexts()
    {
        TotalCaloriesText.setText(String.valueOf(user.getCalories()));
        CaloriesText.setText(String.valueOf(Calories));
        CaloriesLeftText.setText(String.valueOf(CaloriesLeft));
        //
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
            controller.loadInfo(user,Calories,TotalFats,TotalCarbs,TotalProteins);

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
            controller.initialize(user,Calories,TotalCarbs,TotalFats,TotalProteins);

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
            controller.initialize(user,Calories,TotalCarbs,TotalFats,TotalProteins);

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
