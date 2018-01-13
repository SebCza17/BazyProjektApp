package project.Controllers;

import ConnectionClass.CollectionQuery;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.util.Duration;
import javafx.stage.Stage;

import java.util.Objects;


public class AddCollectionController {


    public TextField PhoneNField;
    public TextField EmailField;
    public TextField AdresField;
    public TextField TitleLocationField;
    public TextArea DescriptionLocationArea;
    public TextField TitleCollectionField; //Important!
    public TextArea DescriptionCollectionArea;

    public void onClickAdd(ActionEvent actionEvent) {
        if (!Objects.equals(AdresField.getText(), "")) {
            if (!Objects.equals(TitleCollectionField.getText(), "")) {

                CollectionQuery.addCollection(
                        PhoneNField.getText(), EmailField.getText(), AdresField.getText(),
                        TitleLocationField.getText(), DescriptionLocationArea.getText(),
                        TitleCollectionField.getText(), DescriptionCollectionArea.getText());
               // showCollection();
                stageClose(actionEvent);
            } else System.out.println("Błąd title collection");
        } else System.out.println("Błąd adres");
    }

    private void stageClose(ActionEvent actionEvent){
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
}
