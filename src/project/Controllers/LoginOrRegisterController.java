package project.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import project.Main;


public class LoginOrRegisterController {

    public static Button registerButton;
    public static Button loginButton;

    @FXML
    private void onClickRegister() {
        Main.showRegister();
    }

    @FXML
    private void onClickLogin() {
        Main.showLogin();
    }
}
