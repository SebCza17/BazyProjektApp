package project.Controllers;

import ConnectionClass.CollectionQuery;
import ConnectionClass.WorkQuery;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import project.Main;

import java.util.Objects;

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
    public Button AddButton;


    public void onClickAdd(ActionEvent actionEvent) {

        if (!Objects.equals(AuthorNameField.getText(), "")) {
            if (!Objects.equals(WorkTitleDescField.getText(), "")) {

                AddButton.setDisable(true);

                WorkQuery.addWork(AuthorNameField.getText(), AuthorSurnameField.getText(), AuthorBornField.getText(), AuthorDeathField.getText(),
                        AuthorPhoneNField.getText(), AuthorEmailField.getText(), AuthorAddressField.getText(),
                        AuthorTitleDescField.getText(), AuthorDescArea.getText(),
                        WorkTitleDescField.getText(), WorkDescArea.getText(),
                        WorkYearField.getText(), WorkEpochField.getText());

                stageClose(actionEvent);

            } else System.out.println("Error title work");
        } else System.out.println("Error author name ");

    }

    private void stageClose(ActionEvent actionEvent){
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
}


