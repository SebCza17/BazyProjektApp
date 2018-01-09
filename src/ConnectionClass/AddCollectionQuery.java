package ConnectionClass;

import JPAEntity.CollectionEntity;
import JPAEntity.UserEntity;
import project.Main;

import javax.persistence.EntityManager;

public class AddCollectionQuery {

    public static void addCollectionInit(String phoneNumber, String email, String adress,
                                         String titleLocation, String descriptionLocation,
                                         String titleCollection, String descriptionCollection){

        EntityManager entityManager = MainQuery.initialConnection();
        entityManager.getTransaction().begin();

        CollectionEntity collectionEntity = new CollectionEntity();
        collectionEntity.setUserEntity(Main.userEntity);

        entityManager.persist(collectionEntity);

        entityManager.getTransaction().commit();

        MainQuery.closeConnection(entityManager);
    }
}
