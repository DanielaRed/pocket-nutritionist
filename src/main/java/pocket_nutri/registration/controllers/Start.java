package pocket_nutri.registration.controllers;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import pocket_nutri.registration.services.UserService;

public class Start {

    @FXML
    private ChoiceBox role;

    @FXML
    private Button next;

    @FXML
    public void initialize() {
        role.getItems().addAll("Client", "Nutritionist");
    }

    public void loadMenu() throws Exception
    {
        Stage stage;
        Parent root;

        if((String) role.getValue() == "Client") {
            UserService.loadUsersFromFile();

            stage = (Stage) next.getScene().getWindow();
            root = FXMLLoader.load(getClass().getClassLoader().getResource("ClientRegistration.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        }

        if((String) role.getValue() == "Nutritionist") {
            UserService.loadUsersFromFile();

            //Stage primaryStage = new Stage();
            stage = (Stage) next.getScene().getWindow();
            root = FXMLLoader.load(getClass().getClassLoader().getResource("NutritionistRegistration.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        /*
        if((String) role.getValue() == "Client") {
            UserService.loadUsersFromFile();

            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("ClientRegistration.fxml"));
            primaryStage.setTitle("Registration Example");
            primaryStage.setScene(new Scene(root, 300, 275));
            primaryStage.show();

        }

        if((String) role.getValue() == "Nutritionist") {
            UserService.loadUsersFromFile();

            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("NutritionistRegistration.fxml"));
            primaryStage.setTitle("Registration Example");
            primaryStage.setScene(new Scene(root, 300, 325));
            primaryStage.show();
        }
        */

    }

}
