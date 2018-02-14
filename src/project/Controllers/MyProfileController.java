package project.Controllers;

import project.Main;

public class MyProfileController {

    public void onClickBack(){
        Main.initMainFrameAfterLogin();
    }

    public void onClickEdit(){
        Main.editProfile();
    }
}
