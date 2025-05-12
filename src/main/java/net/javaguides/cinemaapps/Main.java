package net.javaguides.cinemaapps;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.*;
import javafx.scene.*;
import net.javaguides.cinemaapps.Controller.SceneController;
import net.javaguides.cinemaapps.DataBaseConnector.UsersConnector;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        UsersConnector Connect = new UsersConnector();
        Connect.ConnectData();
        SceneController sceneController = new SceneController();
        sceneController.SceneChange(SceneController.getLoginPage(),primaryStage);
    }

}
