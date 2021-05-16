package com.pocket.controllers;
import java.util.ResourceBundle;
import com.pocket.model.User;
import com.pocket.services.UserService;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.util.converter.BooleanStringConverter;
import javafx.util.converter.IntegerStringConverter;

import java.io.IOException;
import java.util.List;
import java.net.URL;

public class AdminController {
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
    private TableColumn<User, String> clientName;
    @FXML
    private TableColumn<User, String> clientUsername;
    @FXML
    private TableColumn<User, String> clientPassword;
    @FXML
    private TableColumn<User, Boolean> clientStatus;
    @FXML
    private TableColumn<User, String> clientRole;


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
        TableColumn <User, String> clientUsername = new TableColumn("Username");
        clientUsername.setCellValueFactory(new PropertyValueFactory<>("username"));

        TableColumn <User, String> clientName = new TableColumn("Fullname");
        clientName.setCellValueFactory(new PropertyValueFactory<>("FullName"));

        TableColumn <User, String> clientRole = new TableColumn("Account Type");
        clientRole.setCellValueFactory(new PropertyValueFactory<>("role"));

        TableColumn <User, Boolean> clientStatus = new TableColumn("Account Status");

        clientStatus.setCellValueFactory(User -> new SimpleBooleanProperty(User.getValue().getVerifiedStatus()));
        clientStatus.setCellFactory(TextFieldTableCell.forTableColumn(new BooleanStringConverter()));

        clientStatus.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<User, Boolean>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<User, Boolean> event) {
                User changes = event.getRowValue();
                changes.setVerifiedStatus(event.getNewValue());
                UserService.persistUsers2(users);

            }
        });


        table.getColumns().addAll(clientUsername,clientName,clientRole,clientStatus);

        ObservableList<User> data = FXCollections.observableArrayList();
        for (User it : users)
        {
            if (it.getRole().compareTo("Client") == 0 || it.getRole().compareTo("Nutritionist") == 0)
            {
                data.add(it);
            }
        }

        table.setItems(data);

        window=new Stage();
        VBox vbox= new VBox();
        vbox.getChildren().addAll(table);
        Scene scene=new Scene(vbox);
        window.setTitle("Manage Accounts");
        window.setScene(scene);
        window.show();


    }
    @FXML
    public void handleClientsButton() throws IOException{
        Stage stage;
        try{
            handleClientsAction();
            stage = (Stage) ViewClients.getScene().getWindow();
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

