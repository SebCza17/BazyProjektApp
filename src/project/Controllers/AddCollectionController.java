package project.Controllers;

import ConnectionClass.AddCollectionQuery;
import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

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
        if(!Objects.equals(AdresField.getText(), "")){
            if(!Objects.equals(TitleCollectionField.getText(), "")){

                AddCollectionQuery.addCollectionInit(
                        PhoneNField.getText(), EmailField.getText(), AdresField.getText(),
                        TitleLocationField.getText(), DescriptionLocationArea.getText(),
                        TitleCollectionField.getText(), DescriptionCollectionArea.getText());

            } else System.out.println("Błąd title collection");
        } else System.out.println("Błąd adres");
    }
}
