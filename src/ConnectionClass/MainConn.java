package ConnectionClass;

import JPAEntity.UserEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class MainConn {


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

       closeConnection(entityManager);

       return count == 1;
   }

   static void closeConnection(EntityManager entityManager){
       entityManager.close();
   }
}