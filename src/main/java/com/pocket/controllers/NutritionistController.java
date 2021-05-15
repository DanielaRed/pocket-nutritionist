package com.pocket.controllers;

import com.pocket.model.User;
import com.pocket.services.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.List;

public class NutritionistController {
    @FXML
    private TableView<User> table;
    @FXML
    private Button Close;
    @FXML
    private Button LoginScreen;
    @FXML
    private Text ClientName;
    @FXML
    private Button ViewClients;
    @FXML
    private TableColumn<User, Button> clientEdit;
    @FXML
    private TableColumn<User, Integer> clientCalories;
    @FXML
    private TableColumn<User, String> clientName;
    @FXML
    private TableColumn<User, String> clientEmail;
    @FXML
    private TableColumn<User, String> clientPhoneNumber;
    @FXML
    private TableColumn<User, String> clientHeight;
    @FXML
    private TableColumn<User, String> clientWeight;
    @FXML
    private TableColumn<User, String> clientAllergies;
    @FXML
    private TableColumn<User, String> clientDiet;
    @FXML
    private TableColumn<User, String> clientGender;

    private User user;
    Stage window;

    public void initialize(User user)
    {
        this.user = user;
        ClientName.setText(user.getFullName());
    }


    public void handleClientsAction() throws IOException
    {
        Label label = new Label("File Data:");
        Font font = Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12);
        label.setFont(font);

        List<User> users = UserService.loadUsersFromFile2();
        ObservableList<User> data = FXCollections.observableArrayList();
        for (User it : users)
        {
            if (it.getRole().compareTo("Client") == 0)
            {
                    data.add(it);
            }
        }
            //Creating columns
            //TableColumn <User, String> clientName = new TableColumn("Client");
            clientName.setCellValueFactory(new PropertyValueFactory<>("FullName"));
           // clientName.setMinWidth(200);
            //TableColumn <User, String> clientPhoneNumber = new TableColumn("Phone Number");
            clientPhoneNumber.setCellValueFactory(new PropertyValueFactory<>("PhoneNumber"));
           // clientPhoneNumber.setMinWidth(50);
            //TableColumn <User, String> clientEmail = new TableColumn("Email");
            clientEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
           // clientEmail.setMinWidth(150);
            //TableColumn <User, String> clientDiet = new TableColumn("Diet Type");
            clientDiet.setCellValueFactory(new PropertyValueFactory<>("DietType"));
            //clientDiet.setMinWidth(100);
           // TableColumn <User, String> clientGender = new TableColumn("Gender");
            clientGender.setCellValueFactory(new PropertyValueFactory<>("Gender"));
            //clientGender.setMinWidth(100);
            //TableColumn <User, String> clientHeight = new TableColumn("Height");
            clientHeight.setCellValueFactory(new PropertyValueFactory<>("Height"));
           // clientHeight.setMinWidth(20);
            //TableColumn <User, String> clientWeight = new TableColumn("Weight");
            clientWeight.setCellValueFactory(new PropertyValueFactory<>("Weight"));
           // clientWeight.setMinWidth(20);
            //TableColumn <User, String> clientAllergies = new TableColumn("Allergies");
            clientAllergies.setCellValueFactory(new PropertyValueFactory<>("Allergies"));
            //clientAllergies.setMinWidth(20);
           // TableColumn <User, Integer> clientCalories = new TableColumn("Calories Allowed");
            clientCalories.setCellValueFactory(new PropertyValueFactory<>("calories"));
            //clientCalories.setMinWidth(30);
            //TableColumn <User, Button> clientEdit = new TableColumn("Edit Calories");
            clientEdit.setCellValueFactory(new PropertyValueFactory<>("Edit"));
            //clientEdit.setMinWidth(30);


            TableView<User> table = new TableView<User>();
            table.setItems(data);
            table.getColumns().addAll(clientName,clientPhoneNumber,clientEmail,clientDiet,clientGender,clientHeight,clientWeight,clientAllergies,clientCalories,clientEdit);

            window=new Stage();

            VBox vbox= new VBox();
            vbox.getChildren().addAll(table);
            Scene scene=new Scene(vbox);
            window.setTitle("Clients");
            window.setScene(scene);
            window.show();
            EditCalories();

        }
        @FXML
         public void handleClientsButton() throws IOException{
            Stage  stage = (Stage) ViewClients.getScene().getWindow();
            handleClientsAction();


         }

         public void EditCalories(){
            clientCalories.setCellFactory(TextFieldTableCell.forTableColumn());
            clientCalories.setOnEditCommit(e -> {
                e.getTableView().getItems().get(e.getTablePosition().getRow()).setCalories(e.getNewValue());
            });
            table.setEditable(true);
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

