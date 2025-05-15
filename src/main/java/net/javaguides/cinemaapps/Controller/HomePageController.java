package net.javaguides.cinemaapps.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;

public class HomePageController {


    @FXML
    private MenuItem LogoutItem;
    @FXML
    private Button LeftButton;
    @FXML
    private Button RightButton;

    public void initialize(){
        LogOutHandler();
    }

    public void LogOutHandler(){
        LogoutItem.setOnAction(e->{
            SceneController Scene = new SceneController();
            Scene.SceneChange(e,SceneController.getLoginPage());
        });
    }

}
