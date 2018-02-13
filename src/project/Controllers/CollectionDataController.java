package project.Controllers;

import JPAEntity.CollectionEntity;
import javafx.scene.layout.VBox;
import project.Main;

public class CollectionDataController {

    public VBox vBox;
    public static CollectionEntity collectionEntity = Main.collectionEntity;

    public void initialize(){
        collectionEntity = Main.collectionEntity;
        System.out.println(collectionEntity.getIdcollection());
    }

    private void showWork(){

    }

    public void onClickAdd(){
        Main.showAddWork();
    }
}
