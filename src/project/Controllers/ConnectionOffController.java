package project.Controllers;

import ConnectionClass.MainQuery;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import project.Main;

public class ConnectionOffController {
    public Button offButton;

    public void initialize(){

    }
    public void onClickOff(ActionEvent actionEvent) {
        if(MainQuery.testConnection()) Main.initLoginOrRegister();
    }
}
