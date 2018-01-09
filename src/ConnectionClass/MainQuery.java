package ConnectionClass;

import JPAEntity.UserEntity;
import project.Main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class MainQuery {


    static EntityManager initialConnection() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
        return entityManagerFactory.createEntityManager();
    }

   public static void test(){

       EntityManager entityManager = initialConnection();



       closeConnection(entityManager);

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

   public static void logOut(){
       Main.userEntity = null;
   }

   static void closeConnection(EntityManager entityManager){
       entityManager.close();
   }
}
