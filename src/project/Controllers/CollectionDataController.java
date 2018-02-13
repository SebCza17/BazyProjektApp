package project.Controllers;

import JPAEntity.CollectionEntity;
import javafx.scene.layout.VBox;
import project.Main;

public class CollectionDataController {

    public VBox vBox;
    CollectionEntity collectionEntity = Main.collectionEntity;

    public void initialize(){
        System.out.println(collectionEntity.getIdcollection());
    }

    private void showWork(){

    }

    public void onClickAdd(){
        Main.showAddWork();
    }
}
