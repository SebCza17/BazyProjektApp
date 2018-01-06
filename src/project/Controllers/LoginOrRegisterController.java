package project.Controllers;

import javafx.fxml.FXML;
import project.Main;


public class LoginOrRegisterController {

    @FXML
    private void onClickRegister() {
        Main.showRegister();
    }

    @FXML
    private void onClickLogin() {
        Main.showLogin();
    }
}
