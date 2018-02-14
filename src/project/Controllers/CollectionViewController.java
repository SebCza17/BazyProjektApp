package project.Controllers;

import ConnectionClass.MainQuery;
import JPAEntity.CollectionEntity;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import project.Main;


import java.util.List;

import static ConnectionClass.CollectionQuery.getCollection;

public class CollectionViewController {

    public VBox vBox;
    public AnchorPane anchorPane;

    public void initialize(){

        showCollection();


    }

    private void showCollection() {

        List<CollectionEntity> collectionEntities = getCollection();

        for (int i = 0; i < collectionEntities.size(); i++) {

            CollectionEntity collectionEntity = collectionEntities.get(i);


            Label label = new Label(i + 1 + " " + MainQuery.getDescription(collectionEntity.getIddescription()).getTitle());
            label.setCursor(Cursor.HAND);
            label.setOnMouseClicked(new javafx.event.EventHandler<javafx.scene.input.MouseEvent>() {
                @Override
                public void handle(javafx.scene.input.MouseEvent event) {
                    int idCollection = collectionEntity.getIdcollection();

                    System.out.println("test" + idCollection);
                    Main.collectionEntity = collectionEntity;
                    Main.showCollectionData();
                }
            });
            vBox.getChildren().add(label);
        }
    }


}
