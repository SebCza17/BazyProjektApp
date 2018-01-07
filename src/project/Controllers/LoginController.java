package project.Controllers;

import ConnectionClass.MainConn;
import JPAEntity.UserEntity;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import project.Main;

import java.util.Objects;


public class LoginController {

    public Button CancelButton;
    public Label ErrorLabel;
    public TextField EmailField;
    public PasswordField PassField;


    @FXML
    private void onClickCancel() {
        Stage stage = (Stage) CancelButton.getScene().getWindow();
        stage.close();
    }

    public void onClickOk() {
        if(validation()){
            ErrorLabel.setText("Login Success!" + Main.userEntity.getPass());
            ErrorLabel.setTextFill(Color.web("Green"));
            Main.initMainFrameAfterLogin();

            Timeline timeline = new Timeline(new KeyFrame(
                    Duration.millis(2000),
                    ae -> onClickCancel()));
            timeline.play();
        }
    }

    private boolean validation() {
        if (!Objects.equals(PassField.getText(), "")) {
            if (!Objects.equals(EmailField.getText(), "")) {
                if(MainConn.checkLogin(EmailField.getText(), PassField.getText())){
                    ErrorLabel.setText("Success!");
                    ErrorLabel.setTextFill(Color.web("Green"));
                    System.out.println("all ok");
                    return true;
                } else {
                    ErrorLabel.setText("Email or Password Incorect!");
                    ErrorLabel.setTextFill(Color.web("Red"));
                    return false;
                }
            } else {
                ErrorLabel.setText("Email field is NULL");
                ErrorLabel.setTextFill(Color.web("Red"));
                return false;
            }
        } else{
            ErrorLabel.setText("Pass field is NULL");
            ErrorLabel.setTextFill(Color.web("Red"));
            return false;
        }
    }
}
