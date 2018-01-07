package project.Controllers;

import ConnectionClass.MainConn;
import ConnectionClass.RegisterConnControler;
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

import java.util.Objects;


public class RegisterController {

    public Button CancelButton;
    public TextField EmailField;
    public PasswordField PassField;
    public PasswordField Pass2Field;
    public Label ErrorLabel;


    @FXML
    private void onClickCancel() {
        Stage stage = (Stage) CancelButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void onClickOK() {
        if (validation()) {
            RegisterConnControler.addUser(EmailField.getText(), Pass2Field.getText());
            Timeline timeline = new Timeline(new KeyFrame(
                    Duration.millis(2000),
                    ae -> onClickCancel()));
            timeline.play();
        }


    }

    private boolean validation(){
        if (Objects.equals(PassField.getText(), Pass2Field.getText())) {
            if (!Objects.equals(EmailField.getText(), "")) {
                if(MainConn.checkEmail(EmailField.getText())) {
                    ErrorLabel.setText("Success!");
                    ErrorLabel.setTextFill(Color.web("Green"));
                    System.out.println("all ok");
                    return true;
                } else {
                    ErrorLabel.setText("Email is already Use!");
                    ErrorLabel.setTextFill(Color.web("Red"));
                    return false;
                }
            } else {
                ErrorLabel.setText("Incorrect Email!");  //TO DO validation email construction
                ErrorLabel.setTextFill(Color.web("Red"));
                return false;
            }
        } else {
            ErrorLabel.setText("Passwords are different!");
            ErrorLabel.setTextFill(Color.web("Red"));
            return false;
        }
    }
}
