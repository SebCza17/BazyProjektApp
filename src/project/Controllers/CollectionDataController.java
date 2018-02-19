package project.Controllers;

import ConnectionClass.MainQuery;
import ConnectionClass.WorkQuery;
import JPAEntity.CollectionEntity;
import JPAEntity.WorkEntity;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
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
    public Button adminButton;
    int maxShow = 5;

    public void initialize(){
        if(!Main.userEntity.getPermissions().equals("Admin")) adminButton.setVisible(false);

        collectionEntity = Main.collectionEntity;
        System.out.println(collectionEntity.getIdcollection());
        showWork(0);
    }

    public void addSomeMoreWork(){
        for (int i = 0; i < 10; i++){
            WorkQuery.addWork("Mistrz Painta" + i, "Gumis", "10-10-2010", "11-10-2010",
                    "123123", "SAS@gmail.com", "Daleka22", "GdybyMialNogi", "to i tak nic",
                    "Wielka Sztuka", "dasdzxczxc", "1550", "sredniowiecze");
        }
    }

    private void showWork(int i){

        List<WorkEntity> workEntities = getWorks();


        EntityManager entityManager = MainQuery.initialConnection();

        for (; i < workEntities.size() && i < maxShow; i++) {

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

                if(workEntities.size()>maxShow) {
                    int oldMax = maxShow;
                    maxShow += maxShow;
                    showWork(oldMax);
                }
            }
        });

        hBox.getChildren().setAll(region,button,region1);
        vBox.getChildren().add(hBox);

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
