package ConnectionClass;

import JPAEntity.UserEntity;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class RegisterConnControler {

    public static void addUser(String email, String password){

        EntityManager entityManager = MainConn.initialConnection();
        entityManager.getTransaction().begin();

        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(email);
        userEntity.setPass(password);
        userEntity.setPermissions("Default");

        entityManager.persist(userEntity);
        entityManager.getTransaction().commit();

        MainConn.closeConnection(entityManager);

    }


}
