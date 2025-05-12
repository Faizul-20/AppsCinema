package net.javaguides.cinemaapps.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import net.javaguides.cinemaapps.DataBaseConnector.UsersConnector;

public class SignUpController {
    @FXML
    private TextField UsernameText;
    @FXML
    private  TextField EmailText;
    @FXML
    private PasswordField Password;
    @FXML
    private PasswordField ConfirmPassword;
    @FXML
    private Button SignUpButton;
    @FXML
    private Label PasswordConfirm;
    @FXML
    private Button CancelButton;
    @FXML
    private Label UsernameCheck;


    @FXML
    public void initialize(){
        UsernameText.setOnAction(e-> EmailText.requestFocus());
        EmailText.setOnAction( event -> Password.requestFocus());
        Password.setOnAction(e-> ConfirmPassword.requestFocus());
        ConfirmPassword.setOnAction(e-> SignUpButton.fire());
        Password.textProperty().addListener((observable,oldValue,newValue) -> ValidatePassword());
        ConfirmPassword.textProperty().addListener((observable,oldValue,newValue) -> ValidatePassword());
        CancelHandler();
        SignUpHandler();
    }

    private boolean ValidatePassword(){
        String PasswordText = Password.getText();
        String ConfirmPasswordText = ConfirmPassword.getText();
        if (PasswordText.equals(ConfirmPasswordText) && !PasswordText.isEmpty() && !ConfirmPasswordText.isEmpty()){
            PasswordConfirm.setText("Password Same!!!");
            PasswordConfirm.setStyle("-fx-text-fill: green;");
            return true;
        }else {
            PasswordConfirm.setText("Password Is'nt Same!!!");
            PasswordConfirm.setStyle("-fx-text-fill: red;");
            return false;
        }
    }

    @FXML
    private void CancelHandler(){
        SceneController Scene = new SceneController();
        CancelButton.setOnAction(event -> {
        Scene.SceneChange(event,SceneController.getLoginPage());
        });
    }

    public void SignUpHandler(){
        UsersConnector Connect = new UsersConnector();
        SignUpButton.setOnAction(event -> {
            Connect.SignUpData(UsernameText.getText(),Password.getText(),EmailText.getText(),UsernameCheck);
        });
    }

}
