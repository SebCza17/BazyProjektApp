package project.Controllers;

import ConnectionClass.MainConn;
import ConnectionClass.RegisterConnControler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.Objects;


public class RegisterController {

    public Button CancelButton;
    public TextField EmailField;
    public PasswordField PassField;
    public PasswordField Pass2Field;


    @FXML
    private void onClickCancel(ActionEvent event) {
        Stage stage = (Stage) CancelButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void onClickOK() {
        if (validation()) {
            RegisterConnControler.addUser(EmailField.getText(), Pass2Field.getText());
        }
        else {
            System.out.println("Cos poszlo nie tak");
        }


    }

    private boolean validation(){
        if (Objects.equals(PassField.getText(), Pass2Field.getText())) {
            if (!Objects.equals(EmailField.getText(), "")) {
                if(MainConn.checkEmail(EmailField.getText())) {
                    System.out.println("all ok");
                    return true;
                } else {
                    System.out.println("Istnieje juz taki email");
                    return false;
                }
            } else {
                System.out.println("Blad Emaila");
                return false;
            }
        } else {
            System.out.println("Błąd Hasla");
            return false;
        }
    }
}
