package project.Controllers;

import ConnectionClass.CollectionQuery;
import ConnectionClass.MainQuery;
import JPAEntity.CollectionEntity;
import JPAEntity.ContactEntity;
import JPAEntity.DescriptionEntity;
import JPAEntity.LocationEntity;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import project.Main;

import java.util.Objects;

public class EditCollectionController {

    public TextField PhoneNField;
    public TextField EmailField;
    public TextField AdresField;
    public TextField TitleLocationField;
    public TextArea DescriptionLocationArea;
    public TextField TitleCollectionField; //Important!
    public TextArea DescriptionCollectionArea;
    public Button editButton;

    private CollectionEntity collectionEntity = CollectionDataController.collectionEntity;
    private LocationEntity locationEntity = MainQuery.getLocation(collectionEntity.getIdlocation());
    private ContactEntity contactEntity = MainQuery.getContact(locationEntity.getIdcontact());

    private DescriptionEntity descriptionEntityLocation = MainQuery.getDescription(locationEntity.getIddescription());
    private DescriptionEntity descriptionEntityCollection = MainQuery.getDescription(collectionEntity.getIddescription());

    public void initialize() {

        PhoneNField.setText(contactEntity.getPhonenumber());
        EmailField.setText(contactEntity.getEmail());
        AdresField.setText(contactEntity.getAddress());

        TitleLocationField.setText(descriptionEntityLocation.getTitle());
        DescriptionLocationArea.setText(descriptionEntityLocation.getDescription());

        TitleCollectionField.setText(descriptionEntityCollection.getTitle());
        DescriptionCollectionArea.setText(descriptionEntityCollection.getDescription());

    }

    public void onClickEdit(ActionEvent actionEvent) {

        if (!Objects.equals(AdresField.getText(), "")) {
            if (!Objects.equals(TitleCollectionField.getText(), "")) {

                editButton.setDisable(true);

                contactEntity.setPhonenumber(PhoneNField.getText());
                contactEntity.setEmail(EmailField.getText());
                contactEntity.setAddress(AdresField.getText());

                descriptionEntityLocation.setTitle(TitleLocationField.getText());
                descriptionEntityLocation.setDescription(DescriptionLocationArea.getText());

                descriptionEntityCollection.setTitle(TitleCollectionField.getText());
                descriptionEntityCollection.setDescription(DescriptionCollectionArea.getText());

                CollectionQuery.updateCollection(descriptionEntityLocation, contactEntity, descriptionEntityCollection);

                stageClose(actionEvent);
            } else System.out.println("Error title collection");
        } else System.out.println("Error address");
    }

    private void stageClose(ActionEvent actionEvent) {
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

}
