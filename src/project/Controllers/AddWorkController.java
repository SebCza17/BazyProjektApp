package project.Controllers;

import ConnectionClass.WorkQuery;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AddWorkController {

    public TextField AuthorNameField;
    public TextField AuthorSurnameField;
    public TextField AuthorBornField;
    public TextField AuthorDeathField;
    public TextField AuthorPhoneNField;
    public TextField AuthorEmailField;
    public TextField AuthorAddressField;
    public TextField AuthorTitleDescField;
    public TextArea AuthorDescArea;
    public TextField WorkTitleDescField;
    public TextArea WorkDescArea;
    public TextField WorkYearField;
    public TextField WorkEpochField;


    public void onClickAdd(ActionEvent actionEvent) {
        WorkQuery.addWork(AuthorNameField.getText(), AuthorSurnameField.getText(), AuthorBornField.getText(), AuthorDeathField.getText(),
                AuthorPhoneNField.getText(), AuthorEmailField.getText(), AuthorAddressField.getText(),
                AuthorTitleDescField.getText(), AuthorDescArea.getText(),
                WorkTitleDescField.getText(), WorkDescArea.getText(),
                WorkYearField.getText(), WorkEpochField.getText());
    }
}
