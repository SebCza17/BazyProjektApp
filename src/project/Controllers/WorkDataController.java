package project.Controllers;

import ConnectionClass.ImageQuery;
import ConnectionClass.MainQuery;
import ConnectionClass.UserQuery;
import ConnectionClass.WorkQuery;
import JPAEntity.WorkEntity;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import project.Main;

import java.io.File;
import java.net.MalformedURLException;

public class WorkDataController {
    public ImageView imageView;
    public Label yearLabel;
    public Label authorLabel;
    public Label titleWorkLabel;

    public static WorkEntity workEntity = Main.workEntity;

    public void initialize() throws MalformedURLException {

        titleWorkLabel.setText(MainQuery.getDescription(WorkQuery.getWorkData(workEntity.getIdwork()).getIdDescription()).getTitle());
        authorLabel.setText(MainQuery.getPersonalData(MainQuery.getAuthor(workEntity.getIdauthor()).getIdPersonalData()).getName());
        yearLabel.setText(WorkQuery.getWorkData(workEntity.getIdwork()).getYear());

        imageView.setImage(ImageQuery.getPicture(WorkQuery.getWorkData(workEntity.getIdwork()).getIdImage()));
    }

    public void onClickAddImage(ActionEvent actionEvent) {

        FileChooser chooser = new FileChooser();
        chooser.setTitle("Open File");
        chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
        File file = chooser.showOpenDialog(new Stage());

        int i = ImageQuery.addProfilePicture(file);
        WorkQuery.editImageId(i);

    }

    public void onClickEdit(ActionEvent actionEvent) {
        Main.showEditWork();
    }
}


