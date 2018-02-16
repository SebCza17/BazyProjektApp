package project.Controllers;

import ConnectionClass.MainQuery;
import JPAEntity.ContactEntity;
import JPAEntity.DescriptionEntity;
import JPAEntity.PersonaldataEntity;
import JPAEntity.UserdataEntity;
import javafx.scene.control.Label;
import project.Main;



public class MyProfileController {
    public Label nameValue;
    public Label surnameValue;
    public Label bornValue;
    public Label phoneValue;
    public Label emailValue;
    public Label addressValue;
    public Label titleValue;
    public Label descValue;


    public void initialize(){

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

        }
    }

    public void onClickBack(){
        Main.initMainFrameAfterLogin();
    }

    public void onClickEdit(){
        Main.editProfile();
    }
}
