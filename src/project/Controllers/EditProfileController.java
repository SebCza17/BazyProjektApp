package project.Controllers;

import ConnectionClass.MainQuery;
import ConnectionClass.UserQuery;
import JPAEntity.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import project.Main;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
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

    public void initialize(){

        if (MainQuery.checkUserDataExist()){

            UserdataEntity userdataEntity=MainQuery.getUserData();
            PersonaldataEntity personaldataEntity = MainQuery.getPersonalData(userdataEntity.getIdPersonalData());
            ContactEntity contactEntity = MainQuery.getContact(userdataEntity.getIdContact());
            DescriptionEntity descriptionEntity = MainQuery.getDescription(userdataEntity.getIdDescription());

            ProfileNameField.setText(personaldataEntity.getName());
            ProfileSurnameField.setText(personaldataEntity.getSurname());
            ProfileBornField.setText(personaldataEntity.getBorn());
            ProfilePhoneField.setText(contactEntity.getPhonenumber());
            ProfileEmailField.setText(contactEntity.getEmail());
            ProfileAddressField.setText(contactEntity.getAddress());
            ProfileTitleField.setText(descriptionEntity.getTitle());
            ProfileDescriptionField.setText(descriptionEntity.getDescription());

        }
    }

    public void onClickEdit(ActionEvent actionEvent) {

                if(MainQuery.checkUserDataExist()){

                    UserdataEntity userdataEntity=MainQuery.getUserData();
                    PersonaldataEntity personaldataEntity = MainQuery.getPersonalData(userdataEntity.getIdPersonalData());
                    ContactEntity contactEntity = MainQuery.getContact(userdataEntity.getIdContact());
                    DescriptionEntity descriptionEntity = MainQuery.getDescription(userdataEntity.getIdDescription());

                    descriptionEntity.setTitle(ProfileTitleField.getText());
                    descriptionEntity.setDescription(ProfileDescriptionField.getText());

                    contactEntity.setAddress(ProfileAddressField.getText());
                    contactEntity.setEmail(ProfileEmailField.getText());
                    contactEntity.setPhonenumber(ProfilePhoneField.getText());

                    personaldataEntity.setName(ProfileNameField.getText());
                    personaldataEntity.setSurname(ProfileSurnameField.getText());
                    personaldataEntity.setBorn(ProfileBornField.getText());

                    UserQuery.editProfile(personaldataEntity,contactEntity,descriptionEntity);
                    Main.stageClose(actionEvent);

                }else {
                    UserQuery.addProfiledata(ProfileNameField.getText(), ProfileSurnameField.getText(), ProfileBornField.getText(),
                            ProfilePhoneField.getText(), ProfileEmailField.getText(), ProfileAddressField.getText(), ProfileTitleField.getText(), ProfileDescriptionField.getText());
                    Main.stageClose(actionEvent);
                }

        Main.initMyProfile();

    }



    @FXML
    private void onClickCancel() {
        Stage stage = (Stage) CancelButton.getScene().getWindow();
        stage.close();
    }


}
