package project.Controllers;

import ConnectionClass.MainQuery;
import JPAEntity.CollectionEntity;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import project.Main;


import javax.persistence.EntityManager;
import java.util.List;

import static ConnectionClass.CollectionQuery.getCollections;

public class CollectionViewController {

    public VBox vBox;
    public AnchorPane anchorPane;

    public void initialize(){

        showCollection();

    }

    private void showCollection() {

        List<CollectionEntity> collectionEntities = getCollections();

        EntityManager entityManager = MainQuery.initialConnection();

        for (int i = 0; i < collectionEntities.size(); i++) {

            CollectionEntity collectionEntity = collectionEntities.get(i);

            Region region = new Region();

            HBox hBox = new HBox();

            hBox.setHgrow(region, Priority.ALWAYS);




            Label label = new Label(i + 1 + ". " + MainQuery.getDescription(entityManager ,collectionEntity.getIddescription()).getTitle());
            Label label1 = new Label(MainQuery.getDescription(entityManager ,MainQuery.getLocation(entityManager ,collectionEntity.getIdlocation()).getIddescription()).getTitle());


            label.setStyle("-fx-font-size: 16px");
            label1.setPadding(new Insets(10, 0, 0, 0));

            hBox.setCursor(Cursor.HAND);
            hBox.setOnMouseClicked(new javafx.event.EventHandler<javafx.scene.input.MouseEvent>() {
                @Override
                public void handle(javafx.scene.input.MouseEvent event) {
                    int idCollection = collectionEntity.getIdcollection();

                    System.out.println("test" + idCollection);
                    Main.collectionEntity = collectionEntity;
                    Main.showCollectionData();
                }
            });

            hBox.setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    hBox.setStyle("-fx-background-color: #e5f2ff;");
                }
            });

            hBox.setOnMouseExited(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    hBox.setStyle(null);
                }
            });



            hBox.getChildren().addAll(label,region, label1);

            vBox.getChildren().add(hBox);
        }

        MainQuery.closeConnection(entityManager);
    }


}
