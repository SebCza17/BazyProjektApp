package ConnectionClass;

import JPAEntity.*;
import project.Main;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class CollectionQuery {

    public static void addCollection(String phoneNumber, String email, String adress,
                                     String titleLocation, String descriptionLocation,
                                     String titleCollection, String descriptionCollection){

        EntityManager entityManager = MainQuery.initialConnection();
        entityManager.getTransaction().begin();

        //step 1
        ContactEntity contactEntity = new ContactEntity();
        contactEntity.setPhonenumber(phoneNumber);
        contactEntity.setEmail(email);
        contactEntity.setAddress(adress);

        DescriptionEntity descriptionEntityLocation = new DescriptionEntity();
        descriptionEntityLocation.setTitle(titleLocation);
        descriptionEntityLocation.setDescription(descriptionLocation);

        DescriptionEntity descriptionEntityCollection = new DescriptionEntity();
        descriptionEntityCollection.setTitle(titleCollection);
        descriptionEntityCollection.setDescription(descriptionCollection);


        entityManager.persist(contactEntity);
        entityManager.persist(descriptionEntityLocation);
        entityManager.persist(descriptionEntityCollection);

        entityManager.getTransaction().commit();

        //step2
        entityManager.getTransaction().begin();

        LocationEntity locationEntity = new LocationEntity();
        locationEntity.setIddescription(descriptionEntityLocation.getIddescription());
        locationEntity.setIdcontact(contactEntity.getIdcontact());


        entityManager.persist(locationEntity);
        entityManager.getTransaction().commit();

        //step3
        entityManager.getTransaction().begin();

        CollectionEntity collectionEntity = new CollectionEntity();
        collectionEntity.setIdlocation(locationEntity.getIdlocation());
        collectionEntity.setIdUser(Main.userEntity.getIduser());
        collectionEntity.setIddescription(descriptionEntityCollection.getIddescription());

        entityManager.persist(collectionEntity);
        entityManager.getTransaction().commit();

        MainQuery.closeConnection(entityManager);
    }


    public static List<CollectionEntity> getCollection(){
        EntityManager entityManager = MainQuery.initialConnection();

        Query query = entityManager.createQuery("SELECT s from CollectionEntity s WHERE s.idUser =" + Main.userEntity.getIduser());
        List<CollectionEntity> collectionEntities = query.getResultList();

        MainQuery.closeConnection(entityManager);

        return collectionEntities;
    }

//    public static DescriptionEntity getCollectionDescription(int i){
//        EntityManager entityManager = MainQuery.initialConnection();
//
//        Query query = entityManager.createQuery("SELECT s from DescriptionEntity s WHERE s.iddescription =" + i);
//        List<DescriptionEntity> descriptionEntities = query.getResultList();
//        DescriptionEntity descriptionEntity = descriptionEntities.get(0);
//
//        MainQuery.closeConnection(entityManager);
//
//        return descriptionEntity;
//    }
}
