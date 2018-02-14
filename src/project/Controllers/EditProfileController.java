package project.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class EditProfileController {

    public Button CancelButton;

    @FXML
    private void onClickCancel() {
        Stage stage = (Stage) CancelButton.getScene().getWindow();
        stage.close();
    }
}
