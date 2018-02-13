package ConnectionClass;

import JPAEntity.*;
import project.Main;

import javax.persistence.EntityManager;
import java.util.Date;

public class WorkQuery {
    public static void addCollection(
            //Author
            String name, String surname, Short age, java.sql.Date born, java.sql.Date death,  //PersonalData
            String phoneNumber, String email, String address,    //Contact
            String authorTitleDesc, String authorDesc,   //Author Description
            //Work Description
            String workTitleDesc, String workDesc,

            //Work Data
            String year,
            String epoch)
    {
        EntityManager entityManager = MainQuery.initialConnection();
        entityManager.getTransaction().begin();


        //STEP 1

        //AuthorPersonalData
        PersonaldataEntity personaldataEntity = new PersonaldataEntity();
        personaldataEntity.setName(name);
        personaldataEntity.setSurname(surname);
        personaldataEntity.setAge(age);
        personaldataEntity.setBorn(born);
        if (death != null) {
            personaldataEntity.setDeath(death);
        }
        //AuthorContact
        ContactEntity contactEntity = new ContactEntity();
        contactEntity.setPhonenumber(phoneNumber);
        contactEntity.setEmail(email);
        contactEntity.setAddress(address);
        //AuthorDesc
        DescriptionEntity authorDescriptionEntity = new DescriptionEntity();
        authorDescriptionEntity.setTitle(authorTitleDesc);
        authorDescriptionEntity.setDescription(authorDesc);
        //WorkDesc
        DescriptionEntity workDescriptionEntity = new DescriptionEntity();
        workDescriptionEntity.setTitle(workTitleDesc);
        workDescriptionEntity.setDescription(workDesc);
//                //WorkData
//            WorkdataEntity workdataEntity= new WorkdataEntity();
//            workdataEntity.setYear(year);
//            workdataEntity.setEpoch(epoch);


        entityManager.persist(contactEntity);
        entityManager.persist(authorDescriptionEntity);
        entityManager.persist(workDescriptionEntity);
 //       entityManager.persist(workdataEntity);
        entityManager.getTransaction().commit();

        //STEP 2.0
        entityManager.getTransaction().begin();

        AuthorEntity authorEntity= new AuthorEntity();
        authorEntity.setIdContact(contactEntity.getIdcontact());
        authorEntity.setIdDescription(authorDescriptionEntity.getIddescription());
        authorEntity.setIdPersonalData(personaldataEntity.getIdpersonaldata());

        entityManager.persist(authorEntity);
        entityManager.getTransaction().commit();

        //STEP 3
        entityManager.getTransaction().begin();

        WorkEntity workEntity = new WorkEntity();
        //workEntity.setIdcollection(Main.userEntity.);
        workEntity.setIdauthor(authorEntity.getIdauthor());

        //WorkData
        WorkdataEntity workdataEntity= new WorkdataEntity();
        workdataEntity.setId(workEntity.getIdwork());
        workdataEntity.setYear(year);
        workdataEntity.setEpoch(epoch);


        entityManager.persist(workdataEntity);
        entityManager.persist(workEntity);
        entityManager.getTransaction().commit();

        MainQuery.closeConnection(entityManager);



    }
}
