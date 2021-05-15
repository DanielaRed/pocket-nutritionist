package com.pocket.controllers;
import java.util.ResourceBundle;
import com.pocket.model.User;
import com.pocket.services.UserService;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
import javafx.util.converter.IntegerStringConverter;

import java.io.IOException;
import java.util.List;
import java.net.URL;

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

        TableView<User> table = new TableView<User>();
        table.setEditable(true);
        //Creating columns
        TableColumn <User, String> clientName = new TableColumn("Client");
        clientName.setCellValueFactory(new PropertyValueFactory<>("FullName"));

        TableColumn <User, String> clientPhoneNumber = new TableColumn("Phone Number");
        clientPhoneNumber.setCellValueFactory(new PropertyValueFactory<>("PhoneNumber"));

        TableColumn <User, String> clientEmail = new TableColumn("Email");
        clientEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));

        TableColumn <User, String> clientDiet = new TableColumn("Diet Type");
        clientDiet.setCellValueFactory(new PropertyValueFactory<>("DietType"));

        TableColumn <User, String> clientGender = new TableColumn("Gender");
        clientGender.setCellValueFactory(new PropertyValueFactory<>("Gender"));

       TableColumn <User, String> clientHeight = new TableColumn("Height");
        clientHeight.setCellValueFactory(new PropertyValueFactory<>("Height"));

        TableColumn <User, String> clientWeight = new TableColumn("Weight");
        clientWeight.setCellValueFactory(new PropertyValueFactory<>("Weight"));

        TableColumn <User, String> clientAllergies = new TableColumn("Allergies");
        clientAllergies.setCellValueFactory(new PropertyValueFactory<>("Allergies"));

         TableColumn <User, Integer> clientCalories = new TableColumn("Calories Allowed");
        clientCalories.setCellValueFactory(new PropertyValueFactory<>("calories"));
        clientCalories.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        clientCalories.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<User, Integer>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<User, Integer> event) {
                User changes = event.getRowValue();
                changes.setCalories(event.getNewValue());
                UserService.persistUsers2(users);

            }
        });







        table.getColumns().addAll(clientName,clientPhoneNumber,clientEmail,clientDiet,clientGender,clientHeight,clientWeight,clientAllergies,clientCalories);

        ObservableList<User> data = FXCollections.observableArrayList();
        for (User it : users)
        {
            if (it.getRole().compareTo("Client") == 0)
            {
                data.add(it);
            }
        }

        table.setItems(data);

        window=new Stage();
        VBox vbox= new VBox();
        vbox.getChildren().addAll(table);
        Scene scene=new Scene(vbox);
        window.setTitle("Clients");
       window.setScene(scene);
       window.show();


    }
    @FXML
    public void handleClientsButton() throws IOException{
       // Stage  stage = (Stage) ViewClients.getScene().getWindow();
        Stage stage;



        FXMLLoader loader;
        try{
            handleClientsAction();
            stage = (Stage) ViewClients.getScene().getWindow();

            //loader = new FXMLLoader(getClass().getResource("/Table.fxml"));

            //stage.setScene(new Scene(loader.load()));
            //NutritionistController controller = loader.getController();


            stage.show();

        } catch(Exception e) {
            e.printStackTrace();
            e.getCause();
        }


    }

   // public void EditCalories(){
        //ageColumn.setCellFactory(TextFieldTableCell.<DataModel, Integer>forTableColumn(new IntegerStringConverter()));



    //}


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

