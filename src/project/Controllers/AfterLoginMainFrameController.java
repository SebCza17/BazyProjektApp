package project.Controllers;

import ConnectionClass.MainQuery;
import javafx.event.ActionEvent;
import javafx.scene.layout.BorderPane;
import project.Main;

//import static ConnectionClass.CollectionQuery.getCollectionDescription;


public class AfterLoginMainFrameController {

    public BorderPane borderPane;


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
