package project.Controllers;

import ConnectionClass.MainQuery;
import javafx.event.ActionEvent;
import project.Main;


public class AfterLoginMainFrameController {

    public void onClickSignOut(ActionEvent actionEvent) {

        MainQuery.logOut();
        Main.initMainFrameBeforeLogin();
    }

    public void onClickAddCollection() {
        Main.addCollection();
    }
}
