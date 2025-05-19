package net.javaguides.cinemaapps.Controller;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.util.Duration;

public class HomePageController {


    @FXML
    private MenuItem LogoutItem;
    @FXML
    private ScrollPane trendingScrollPane;
    @FXML
    private Button LeftButton;
    @FXML
    private Button RightButton;
    private final double ScrollAmount = 0.5;

    public void initialize(){
        LogOutHandler();
        ToLeftSide();
        LeftButton.setOnAction(e->ToLeftSide());
        RightButton.setOnAction(e-> ToRightSide());
    }

    public void LogOutHandler(){
        LogoutItem.setOnAction(e->{
            SceneController Scene = new SceneController();
            Scene.SceneChange(e,SceneController.getLoginPage());
        });
    }

    @FXML
    public void ToLeftSide(){
        double Current = trendingScrollPane.getHvalue();
        double Target = Math.max(0.0,Current - ScrollAmount);
        AnimateScroll(Current,Target);
    }
    @FXML
    public void ToRightSide(){
        double Current = trendingScrollPane.getHvalue();
        double Target = Math.max(0.0,Current + ScrollAmount);
        AnimateScroll(Current,Target);
    }

    private void AnimateScroll(double From,Double To){
        Timeline timeline = new Timeline();
        KeyValue keyValue = new KeyValue(trendingScrollPane.hvalueProperty(),To);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(300),keyValue);
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();
    }

}
