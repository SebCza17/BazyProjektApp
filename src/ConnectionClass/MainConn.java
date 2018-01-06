package ConnectionClass;

import JPAEntity.UserEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class MainConn {


    public static EntityManager initialConnection() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
        return entityManagerFactory.createEntityManager();
    }

   public static void test(){

       EntityManager entityManager = initialConnection();

       Query query = entityManager.createQuery("Select s from UserEntity s");
       List<UserEntity> userEntityList = query.getResultList();
       UserEntity userEntity = userEntityList.get(0);
       System.out.println(userEntity.getEmail());

       closeConnection(entityManager);

   }

   public static void closeConnection(EntityManager entityManager){
       entityManager.close();
   }
}
