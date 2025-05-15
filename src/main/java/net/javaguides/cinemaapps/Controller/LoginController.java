package net.javaguides.cinemaapps.Controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import net.javaguides.cinemaapps.DataBaseConnector.UsersConnector;

public class LoginController {
    UsersConnector User = new UsersConnector();
    @FXML
    private TextField UsernameText;
    @FXML
    private PasswordField Passwordfield;
    @FXML
    private Label WarningLabel;
    @FXML
    private  Button LoginButton;
    @FXML
    private Button SignUpButton;

    @FXML
    public void initialize(){
        FireHandlerUsername(new ActionEvent());
        FireHandlerPassword(new ActionEvent());
        LoginHandler();
        SignUpHandler();
    }

    @FXML
    public void FireHandlerPassword(ActionEvent event){
        Passwordfield.setOnAction(e-> LoginButton.fire());
    }
    @FXML
    public void FireHandlerUsername(ActionEvent event) {
        UsernameText.setOnAction(e -> Passwordfield.requestFocus() );
    }
    @FXML
    public void LoginHandler(){
        LoginButton.setOnAction(e->{
            boolean LoginResult = User.LoginCheck(UsernameText.getText(),Passwordfield.getText());
            if (LoginResult){
                SceneController Scene = new SceneController();
                //Stage PrimaryStage = new Stage();
                Scene.SceneChange(SceneController.getHomePage(),SceneController.getStyleHomepage());
            }else {
                WarningLabel.setText("Password Kamu Salah!!!");
                WarningLabel.setVisible(true);
            }
        });
    }

    @FXML
    public void SignUpHandler(){
        SceneController Scene = new SceneController();
        //Stage PrimaryStage = new Stage();
        SignUpButton.setOnAction(event->{
            Scene.SceneChange(event,SceneController.getSignUpPage());
        });
    }

}
