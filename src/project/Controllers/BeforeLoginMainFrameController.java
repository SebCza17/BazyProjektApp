package project.Controllers;

import javafx.fxml.FXML;
//import javafx.scene.control.MenuBar;
//import javafx.stage.Stage;
import project.Main;

public class BeforeLoginMainFrameController {

    //public MenuBar CancelButton;

    @FXML
    private void onClickRegister() {
        Main.showRegister();
    }

    @FXML
    private void onClickLogin() {
        Main.showLogin();
    }

    /*@FXML
    private void onClickClose() {
        Stage stage = (Stage) CancelButton.getScene().getWindow();
        stage.close();

    }       */
}
