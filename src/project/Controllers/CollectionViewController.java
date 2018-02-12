package project.Controllers;

import JPAEntity.CollectionEntity;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.util.List;

import static ConnectionClass.CollectionQuery.getCollection;
import static ConnectionClass.CollectionQuery.getCollectionDescription;

public class CollectionViewController {

    public VBox vBox;

    public void initialize(){
        showCollection();
    }

    private void showCollection() {

        List<CollectionEntity> collectionEntities = getCollection();

        for (int i = 0; i < collectionEntities.size(); i++) {

            CollectionEntity collectionEntity = collectionEntities.get(i);
            //DescriptionEntity descriptionEntity = getCollectionDescription(collectionEntity.getIddescription());

            Label label = new Label(i + 1 + " " + getCollectionDescription(collectionEntity.getIddescription()).getTitle());
           // vBox.getChildren().add(label);
        }
    }
}
