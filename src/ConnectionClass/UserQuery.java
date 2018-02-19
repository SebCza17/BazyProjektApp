package ConnectionClass;

import JPAEntity.*;
import project.Main;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class UserQuery {

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

    public static void editProfile(PersonaldataEntity personaldataEntity,ContactEntity contactEntity,DescriptionEntity descriptionEntity)
    {

        EntityManager entityManager = MainQuery.initialConnection();

        entityManager.getTransaction().begin();

        entityManager.merge(personaldataEntity);
        entityManager.merge(contactEntity);
        entityManager.merge(descriptionEntity);

        entityManager.getTransaction().commit();

        MainQuery.closeConnection(entityManager);
    }

    public static void addProfiledata(
            //PERSONAL DATA
            String name, String surname, String born,
            //CONTACT
            String phoneNumber, String email, String address,
            //DESCRIPTION
            String userTitleDesc, String userDesc

    ){
        EntityManager entityManager = MainQuery.initialConnection();
        entityManager.getTransaction().begin();
                            //          STEP1
        //PersonalData
        PersonaldataEntity personaldataEntity = new PersonaldataEntity();
        personaldataEntity.setName(name);
        personaldataEntity.setSurname(surname);
        personaldataEntity.setBorn(born);
        //Contact
        ContactEntity contactEntity = new ContactEntity();
        contactEntity.setPhonenumber(phoneNumber);
        contactEntity.setEmail(email);
        contactEntity.setAddress(address);
        //Description
        DescriptionEntity descriptionEntity = new DescriptionEntity();
        descriptionEntity.setTitle(userTitleDesc);
        descriptionEntity.setDescription(userDesc);
        //Persist&Commit step 1
        entityManager.persist(personaldataEntity);
        entityManager.persist(contactEntity);
        entityManager.persist(descriptionEntity);
        entityManager.getTransaction().commit();

                            //          STEP2
        //UserData
        entityManager.getTransaction().begin();
        UserdataEntity userdataEntity=new UserdataEntity();
        userdataEntity.setId(Main.userEntity.getIduser());
        userdataEntity.setIdPersonalData(personaldataEntity.getIdpersonaldata());
        userdataEntity.setIdContact(contactEntity.getIdcontact());
        userdataEntity.setIdDescription(descriptionEntity.getIddescription());
        userdataEntity.setIdImage(1);
        //Persist&Commit
        entityManager.persist(userdataEntity);
        entityManager.getTransaction().commit();


        MainQuery.closeConnection(entityManager);

    }


}
