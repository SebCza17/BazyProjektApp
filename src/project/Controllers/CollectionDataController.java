package project.Controllers;

import ConnectionClass.MainQuery;
import JPAEntity.CollectionEntity;
import JPAEntity.WorkEntity;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import project.Main;

import javax.persistence.EntityManager;

import static ConnectionClass.WorkQuery.getWorkData;
import static ConnectionClass.WorkQuery.getWorks;

import java.util.List;

public class CollectionDataController {

    public VBox vBox;
    public static CollectionEntity collectionEntity = Main.collectionEntity;

    public void initialize(){
        collectionEntity = Main.collectionEntity;
        System.out.println(collectionEntity.getIdcollection());
        showWork();
    }

    private void showWork(){

        List<WorkEntity> workEntities = getWorks();


        EntityManager entityManager = MainQuery.initialConnection();

        for (int i = 0; i < workEntities.size(); i++) {

            WorkEntity workEntity = workEntities.get(i);

            Region region = new Region();

            HBox hBox = new HBox();

            hBox.setHgrow(region, Priority.ALWAYS);


            Label label = new Label(i + 1 + ". " + MainQuery.getDescription(entityManager ,getWorkData(entityManager ,workEntity.getIdwork()).getIdDescription()).getTitle());
            Label label1 = new Label(MainQuery.getPersonalData(entityManager ,MainQuery.getAuthor(entityManager ,workEntity.getIdauthor()).getIdPersonalData()).getName());

            label.setStyle("-fx-font-size: 16px");
            label1.setPadding(new Insets(10, 0, 0, 0));

            hBox.setCursor(Cursor.HAND);
            
           hBox.setOnMouseClicked(new javafx.event.EventHandler<javafx.scene.input.MouseEvent>() {
               @Override
               public void handle(javafx.scene.input.MouseEvent event) {
                   int idWork = workEntity.getIdwork();

                    System.out.println("test" + idWork);
                    Main.workEntity = workEntity;
                    Main.showWorkData();
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

    public void onClickAdd(ActionEvent actionEvent){
        Main.showAddWork();
        Main.stageClose(actionEvent);
    }

    public void onClickEditColl(ActionEvent actionEvent) {
        Main.editCollection();
    }
}
