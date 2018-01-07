package project.Controllers;

import ConnectionClass.MainConn;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import project.Main;

import javax.management.Notification;


public class AfterLoginMainFrameController {

    public void onClickSignOut(ActionEvent actionEvent) {

        MainConn.logOut();
        Main.initMainFrameBeforeLogin();
    }
}
