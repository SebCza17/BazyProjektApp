package project.Controllers;

import ConnectionClass.MainQuery;
import javafx.event.ActionEvent;
import javafx.scene.layout.VBox;
import project.Main;


public class AfterLoginMainFrameController {

    public VBox vBox;

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
