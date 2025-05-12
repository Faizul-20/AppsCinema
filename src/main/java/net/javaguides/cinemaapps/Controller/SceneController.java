package net.javaguides.cinemaapps.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneController {
    private static String LOGIN_PAGE = "/net/javaguides/cinemaapps/LoginApps.fxml";
    private static String SIGN_UP_PAGE = "/net/javaguides/cinemaapps/SignUp.fxml";

    public void SceneChange(String URL_Location,Stage primaryStage){
        try {
            Parent root =  FXMLLoader.load(getClass().getResource(URL_Location));
            primaryStage.setTitle("EMUY CINEMA");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void SceneChange(ActionEvent event, String urlLocation) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(urlLocation));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("EMUY CINEMA");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static String getLoginPage() {
        return LOGIN_PAGE;
    }

    public static String getSignUpPage() {
        return SIGN_UP_PAGE;
    }
}
