package project.Controllers;

import ConnectionClass.UserQuery;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.Objects;

public class EditProfileController {

    public Button CancelButton;
    public Button okButton;
    public TextField ProfileNameField;
    public TextField ProfileSurnameField;
    public TextField ProfileBornField;
    public TextField ProfilePhoneField;
    public TextField ProfileEmailField;
    public TextField ProfileAddressField;
    public TextField ProfileTitleField;
    public TextArea ProfileDescriptionField;

    public void onClickEdit(ActionEvent actionEvent) {


                UserQuery.editProfile(ProfileNameField.getText(),ProfileSurnameField.getText(),ProfileBornField.getText(),
                        ProfilePhoneField.getText(),ProfileEmailField.getText(), ProfileAddressField.getText(),ProfileTitleField.getText(),ProfileDescriptionField.getText());
                stageClose(actionEvent);

    }



    @FXML
    private void onClickCancel() {
        Stage stage = (Stage) CancelButton.getScene().getWindow();
        stage.close();
    }

    private void stageClose(ActionEvent actionEvent){
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
}
