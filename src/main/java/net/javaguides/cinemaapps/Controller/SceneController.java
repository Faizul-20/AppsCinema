package net.javaguides.cinemaapps.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import javafx.stage.Window;

public class SceneController {
    private static String LOGIN_PAGE = "/net/javaguides/cinemaapps/LoginApps.fxml";
    private static String SIGN_UP_PAGE = "/net/javaguides/cinemaapps/SignUp.fxml";
    private static String HOME_PAGE = "/net/javaguides/cinemaapps/HomePage.fxml";
    private static  String STYLE_HOMEPAGE = "/net/javaguides/cinemaapps/Css/HomePage.css";

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

            //Check Apakah Menu Tombol Handler Adalah menu Atau Node
            if (event.getSource() instanceof MenuItem) {
                //Untuk MenuItem
                Stage stage = (Stage) Stage.getWindows().filtered(Window::isShowing).get(0);
                stage.setTitle("EMUY CINEMA");
                stage.setScene(new Scene(root));
                stage.show();
            } else {
                //Untuk Node
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setTitle("EMUY CINEMA");
                stage.setScene(new Scene(root));
                stage.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void SceneChange(String urlLocation, String cssLocation) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(urlLocation));
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource(cssLocation).toExternalForm());

            Stage stage = (Stage) Stage.getWindows().filtered(Window::isShowing).get(0);
            stage.setTitle("EMUY CINEMA");
            stage.setScene(scene);
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

    public static String getHomePage() {
        return HOME_PAGE;
    }

    public static String getStyleHomepage() {
        return STYLE_HOMEPAGE;
    }
}
