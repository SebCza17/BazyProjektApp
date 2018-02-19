package project.Controllers;

import ConnectionClass.ImageQuery;
import ConnectionClass.MainQuery;
import ConnectionClass.UserQuery;
import JPAEntity.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import project.Main;

import javax.persistence.EntityManager;
import java.io.File;
import java.net.MalformedURLException;


public class MyProfileController {
    public Label nameValue;
    public Label surnameValue;
    public Label bornValue;
    public Label phoneValue;
    public Label emailValue;
    public Label addressValue;
    public Label titleValue;
    public Label descValue;
    public ImageView profileImage;
    public Button addPhotoButton;


    public void initialize() throws MalformedURLException {

        if(!MainQuery.checkUserDataExist()) addPhotoButton.setDisable(true);
        else addPhotoButton.setDisable(false);

            if (MainQuery.checkUserDataExist()){

            UserdataEntity userdataEntity=MainQuery.getUserData();
            PersonaldataEntity personaldataEntity = MainQuery.getPersonalData(userdataEntity.getIdPersonalData());
            ContactEntity contactEntity = MainQuery.getContact(userdataEntity.getIdContact());
            DescriptionEntity descriptionEntity = MainQuery.getDescription(userdataEntity.getIdDescription());

            nameValue.setText(personaldataEntity.getName());
            surnameValue.setText(personaldataEntity.getSurname());
            bornValue.setText(personaldataEntity.getBorn());
            phoneValue.setText(contactEntity.getPhonenumber());
            emailValue.setText(contactEntity.getEmail());
            addressValue.setText(contactEntity.getAddress());
            titleValue.setText(descriptionEntity.getTitle());
            descValue.setText(descriptionEntity.getDescription());
//????

            profileImage.setImage(ImageQuery.getPicture(userdataEntity.getIdImage()));


        }
    }

    public void onClickBack(){
        Main.initMainFrameAfterLogin();
    }

    @FXML
    protected void onClickAddPhoto(ActionEvent event) {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Open File");
        chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
        File file = chooser.showOpenDialog(new Stage());

        int i = ImageQuery.addProfilePicture(file);
        UserQuery.editImageId(i);

        Main.initMyProfile();

    }

    public void onClickEdit(){
        Main.editProfile();
    }
}
