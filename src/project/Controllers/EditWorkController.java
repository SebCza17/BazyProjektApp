package project.Controllers;

import ConnectionClass.MainQuery;
import ConnectionClass.WorkQuery;
import JPAEntity.*;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.Objects;

public class EditWorkController {
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
    public Button EditButton;


    private static WorkdataEntity workdataEntity = WorkQuery.getWorkData(WorkDataController.workEntity.getIdwork());
    private static DescriptionEntity descriptionEntityWork = MainQuery.getDescription(workdataEntity.getIdDescription());

    private static AuthorEntity authorEntity = MainQuery.getAuthor(WorkDataController.workEntity.getIdauthor());
    private static PersonaldataEntity personaldataEntity = MainQuery.getPersonalData(authorEntity.getIdPersonalData());
    private static ContactEntity contactEntity = MainQuery.getContact(authorEntity.getIdContact());
    private static DescriptionEntity descriptionEntityAuthor = MainQuery.getDescription(authorEntity.getIdDescription());

    public void initialize(){

        AuthorNameField.setText(personaldataEntity.getName());
        AuthorSurnameField.setText(personaldataEntity.getSurname());
        AuthorBornField.setText(personaldataEntity.getBorn());
        AuthorDeathField.setText(personaldataEntity.getDeath());
        AuthorPhoneNField.setText(contactEntity.getPhonenumber());
        AuthorEmailField.setText(contactEntity.getEmail());
        AuthorAddressField.setText(contactEntity.getAddress());
        AuthorTitleDescField.setText(descriptionEntityAuthor.getTitle());
        AuthorDescArea.setText(descriptionEntityAuthor.getDescription());

        WorkTitleDescField.setText(descriptionEntityWork.getTitle());
        WorkDescArea.setText(descriptionEntityWork.getDescription());
        WorkYearField.setText(workdataEntity.getYear());
        WorkEpochField.setText(workdataEntity.getEpoch());
    }

    public void onClickEdit(ActionEvent actionEvent) {

        personaldataEntity.setName(AuthorNameField.getText());
        personaldataEntity.setSurname(AuthorSurnameField.getText());
        personaldataEntity.setBorn(AuthorBornField.getText());
        personaldataEntity.setBorn(AuthorDeathField.getText());
        contactEntity.setPhonenumber(AuthorPhoneNField.getText());
        contactEntity.setEmail(AuthorEmailField.getText());
        contactEntity.setAddress(AuthorAddressField.getText());
        descriptionEntityAuthor.setTitle(AuthorTitleDescField.getText());
        descriptionEntityAuthor.setDescription(AuthorDescArea.getText());

        descriptionEntityWork.setTitle(WorkTitleDescField.getText());
        descriptionEntityWork.setDescription(WorkDescArea.getText());
        workdataEntity.setYear(WorkYearField.getText());
        workdataEntity.setEpoch(WorkEpochField.getText());

        if (!Objects.equals(AuthorNameField.getText(), "")) {
            if (!Objects.equals(WorkTitleDescField.getText(), "")) {

                EditButton.setDisable(true);

                WorkQuery.editWork(personaldataEntity, contactEntity, workdataEntity, descriptionEntityWork, descriptionEntityAuthor);


            } else System.out.println("Error title work");
        } else System.out.println("Error author name ");

    }
}
