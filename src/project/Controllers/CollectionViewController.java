package project.Controllers;

import ConnectionClass.CollectionQuery;
import ConnectionClass.MainQuery;
import JPAEntity.CollectionEntity;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.util.Duration;
import project.Main;


import javax.persistence.EntityManager;
import java.util.List;

import static ConnectionClass.CollectionQuery.getCollections;

public class CollectionViewController {

    public VBox vBox;
    public AnchorPane anchorPane;
    public AnchorPane stage;
    int maxShow = 5;

    public void initialize(){

        showCollection(0);

    }

    private void showCollection(int i) {

        List<CollectionEntity> collectionEntities = getCollections();

        EntityManager entityManager = MainQuery.initialConnection();

        
        for (; i < collectionEntities.size() && i < maxShow; i++) {

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

                    stage.setCursor(Cursor.WAIT);

                    Timeline timeline = new Timeline(new KeyFrame(
                            Duration.millis(1)));
                    timeline.play();


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
        Region region = new Region();
        Region region1 = new Region();

        HBox hBox = new HBox();

        hBox.setHgrow(region, Priority.ALWAYS);
        hBox.setHgrow(region1, Priority.ALWAYS);

        Button button = new Button("More");

        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                
                vBox.getChildren().remove(hBox);

                if(collectionEntities.size()>maxShow) {
                    int oldMax = maxShow;
                    maxShow += maxShow;
                    showCollection(oldMax);
                }
            }
        });

        hBox.getChildren().setAll(region,button,region1);
        vBox.getChildren().add(hBox);

        MainQuery.closeConnection(entityManager);
    }

    //

//set_cursor_waiting(scene);

//void wait(0.0001)

//task...

//set_cursor_normal(scene);

//

}
