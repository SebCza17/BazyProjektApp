package ConnectionClass;

import JPAEntity.*;
import project.Main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class MainQuery {


    public static EntityManager initialConnection() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
        return entityManagerFactory.createEntityManager();
    }


    public static boolean testConnection() {

        EntityManager entityManager = null;
        try {
            entityManager = initialConnection();
        } catch (Exception e) {
            System.out.println("Cannot Connection to Database");
            return false;
        } finally {
            if (entityManager != null) {
                closeConnection(entityManager);
            }

        }
        return true;
    }

    public static boolean checkEmail(String email){
       EntityManager entityManager = initialConnection();

       Query query = entityManager.createQuery("SELECT COUNT(s.email) FROM UserEntity s WHERE s.email = '" + email +  "'");
       Long count = (Long) query.getSingleResult();

       closeConnection(entityManager);

       return count == 0;
   }

    public static boolean checkLogin(String email, String password){
       EntityManager entityManager = initialConnection();

       Query query = entityManager.createQuery("SELECT COUNT(s.iduser) FROM UserEntity s where s.email ='" + email + "' and s.pass = '" + password + "'");
       Long count = (Long) query.getSingleResult();



       if(count == 1){
           Query query1 = entityManager.createQuery("SELECT s FROM UserEntity s where s.email ='" + email + "' and s.pass = '" + password + "'");
           List<UserEntity> userEntities = query1.getResultList();
           Main.userEntity = userEntities.get(0);
           closeConnection(entityManager);
           return true;
       } else {
           closeConnection(entityManager);
           return false;
       }
   }

    public static DescriptionEntity getDescription(EntityManager entityManager, int i){

        Query query = entityManager.createQuery("SELECT s from DescriptionEntity s WHERE s.iddescription =" + i);
        List<DescriptionEntity> descriptionEntities = query.getResultList();
        DescriptionEntity descriptionEntity = descriptionEntities.get(0);

        return descriptionEntity;
    }
    public static DescriptionEntity getDescription(int i){
        EntityManager entityManager = initialConnection();

        Query query = entityManager.createQuery("SELECT s from DescriptionEntity s WHERE s.iddescription =" + i);
        List<DescriptionEntity> descriptionEntities = query.getResultList();
        DescriptionEntity descriptionEntity = descriptionEntities.get(0);

        closeConnection(entityManager);

        return descriptionEntity;
    }

    public static ContactEntity getContact(int i){
        EntityManager entityManager = MainQuery.initialConnection();

        Query query = entityManager.createQuery("SELECT s from ContactEntity s WHERE s.idcontact =" + i);
        List<ContactEntity> contactEntities = query.getResultList();
        ContactEntity contactEntity = contactEntities.get(0);

        MainQuery.closeConnection(entityManager);

        return contactEntity;
    }

    public static LocationEntity getLocation(EntityManager entityManager, int i){

        Query query = entityManager.createQuery("SELECT s from LocationEntity s WHERE s.idlocation =" + i);
        List<LocationEntity> locationEntities = query.getResultList();
        LocationEntity locationEntity = locationEntities.get(0);

        return locationEntity;
    }
    public static LocationEntity getLocation(int i){
        EntityManager entityManager = MainQuery.initialConnection();

        Query query = entityManager.createQuery("SELECT s from LocationEntity s WHERE s.idlocation =" + i);
        List<LocationEntity> locationEntities = query.getResultList();
        LocationEntity locationEntity = locationEntities.get(0);

        MainQuery.closeConnection(entityManager);

        return locationEntity;
    }

    public static PersonaldataEntity getPersonalData(EntityManager entityManager, int i){

        Query query = entityManager.createQuery("SELECT s from PersonaldataEntity s WHERE s.idpersonaldata =" + i);
        List<PersonaldataEntity> personalEntities = query.getResultList();
        PersonaldataEntity personaldataEntity = personalEntities.get(0);

        return personaldataEntity;
    }
    public static PersonaldataEntity getPersonalData(int i){
        EntityManager entityManager = MainQuery.initialConnection();

        Query query = entityManager.createQuery("SELECT s from PersonaldataEntity s WHERE s.idpersonaldata =" + i);
        List<PersonaldataEntity> personalEntities = query.getResultList();
        PersonaldataEntity personaldataEntity = personalEntities.get(0);

        MainQuery.closeConnection(entityManager);

        return personaldataEntity;
    }

    public static UserdataEntity getUserData(){
        EntityManager entityManager = MainQuery.initialConnection();

        Query query = entityManager.createQuery("SELECT s from UserdataEntity s WHERE s.id =" + Main.userEntity.getIduser());
        List<UserdataEntity> userDataEntities = query.getResultList();
        UserdataEntity userdataEntity = userDataEntities.get(0);

        MainQuery.closeConnection(entityManager);

        return userdataEntity;
    }



    public static AuthorEntity getAuthor(EntityManager entityManager ,int i){

        Query query = entityManager.createQuery("SELECT s from AuthorEntity s WHERE s.idauthor =" + i);
        List<AuthorEntity> authorEntities = query.getResultList();
        AuthorEntity authorEntity = authorEntities.get(0);

        return authorEntity;
    }
    public static AuthorEntity getAuthor(int i){
        EntityManager entityManager = MainQuery.initialConnection();

        Query query = entityManager.createQuery("SELECT s from AuthorEntity s WHERE s.idauthor =" + i);
        List<AuthorEntity> authorEntities = query.getResultList();
        AuthorEntity authorEntity = authorEntities.get(0);

        MainQuery.closeConnection(entityManager);

        return authorEntity;
    }

    public static boolean checkUserDataExist(){
        boolean exist = false;
        EntityManager entityManager = MainQuery.initialConnection();
        Query query = entityManager.createQuery("SELECT s from UserdataEntity s WHERE s.id =" + Main.userEntity.getIduser());
        List<UserdataEntity> userdataEntities = query.getResultList();
        if (userdataEntities.size()>0){
            exist=true;
        }
        MainQuery.closeConnection(entityManager);
        return exist;
    }

   public static void logOut(){
       Main.userEntity = null;
   }

   public static void closeConnection(EntityManager entityManager){
       entityManager.close();
   }
}
