package project.Controllers;

import ConnectionClass.CollectionQuery;
import ConnectionClass.MainQuery;
import javafx.event.ActionEvent;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.BorderPane;
import project.Main;

//import static ConnectionClass.CollectionQuery.getCollectionDescription;


public class AfterLoginMainFrameController {

    public BorderPane borderPane;
    public MenuItem adminItem1;
    public SeparatorMenuItem adminSeparator;

    public void initialize(){
        if(!Main.userEntity.getPermissions().equals("Admin")) {
            adminSeparator.setVisible(false);
            adminItem1.setVisible(false);
        }
    }

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


    public void addSomeMoreCollection(ActionEvent actionEvent) {

            for (int i = 0; i < 10; i++) {
                CollectionQuery.addCollection("123", "Spam@gmail.com", "Spamowa35/34", "Wielkie Muzeum",
                        "dasdsadsad", "SpamAdminSample" + i, "zxcxzcxzc");
            }
    }
}
