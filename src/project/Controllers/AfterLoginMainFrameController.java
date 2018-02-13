package project.Controllers;

import ConnectionClass.MainQuery;
import JPAEntity.CollectionEntity;
import JPAEntity.DescriptionEntity;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.VBox;
import project.Main;

import java.util.List;

import static ConnectionClass.CollectionQuery.getCollection;
//import static ConnectionClass.CollectionQuery.getCollectionDescription;
import static ConnectionClass.MainQuery.getDescription;

public class AfterLoginMainFrameController {

    public void onClickSignOut(ActionEvent actionEvent) {

        MainQuery.logOut();
        Main.initMainFrameBeforeLogin();
    }

    public void onClickAddCollection() {
        Main.addCollection();
    }

    public void onClickMyProfile() {
        Main.initMyProfile();
    }



}
