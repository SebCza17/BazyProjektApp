package ConnectionClass;

import JPAEntity.UserEntity;

import javax.persistence.EntityManager;

public class UserRegisterQuery {

    public static void addUser(String email, String password){

        EntityManager entityManager = MainQuery.initialConnection();
        entityManager.getTransaction().begin();

        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(email);
        userEntity.setPass(password);
        userEntity.setPermissions("Default");

        entityManager.persist(userEntity);
        entityManager.getTransaction().commit();

        MainQuery.closeConnection(entityManager);

    }


}
