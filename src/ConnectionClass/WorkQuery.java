package ConnectionClass;

import JPAEntity.*;
import project.Controllers.CollectionDataController;
import project.Controllers.WorkDataController;
import project.Main;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;

public class WorkQuery {
    public static void addWork(
            //Author
            String name, String surname, String born, String death,  //AuthorPersonalData
            String phoneNumber, String email, String address,    //Author Contact
            String authorTitleDesc, String authorDesc,   //Author Description
            //Work Description
            String workTitleDesc, String workDesc,

            //Work Data
            String year,
            String epoch) {
        EntityManager entityManager = MainQuery.initialConnection();
        entityManager.getTransaction().begin();


        //STEP 1

        //AuthorPersonalData
        PersonaldataEntity personaldataEntity = new PersonaldataEntity();
        personaldataEntity.setName(name);
        personaldataEntity.setSurname(surname);
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


        entityManager.persist(personaldataEntity);
        entityManager.persist(contactEntity);
        entityManager.persist(authorDescriptionEntity);
        entityManager.persist(workDescriptionEntity);
        //       entityManager.persist(workdataEntity);
        entityManager.getTransaction().commit();

        //STEP 2.0
        entityManager.getTransaction().begin();

        AuthorEntity authorEntity = new AuthorEntity();
        authorEntity.setIdContact(contactEntity.getIdcontact());
        authorEntity.setIdDescription(authorDescriptionEntity.getIddescription());
        authorEntity.setIdPersonalData(personaldataEntity.getIdpersonaldata());

        entityManager.persist(authorEntity);
        entityManager.getTransaction().commit();

        //STEP 3
        entityManager.getTransaction().begin();

        WorkEntity workEntity = new WorkEntity();
        workEntity.setIdauthor(authorEntity.getIdauthor());
        workEntity.setIdcollection(CollectionDataController.collectionEntity.getIdcollection());


        entityManager.persist(workEntity);
        entityManager.getTransaction().commit();

        //STEP 4
        entityManager.getTransaction().begin();

        WorkdataEntity workdataEntity = new WorkdataEntity();
        workdataEntity.setIdWork(workEntity.getIdwork());
        workdataEntity.setYear(year);
        workdataEntity.setEpoch(epoch);
        workdataEntity.setIdDescription(workDescriptionEntity.getIddescription());
        workdataEntity.setIdImage(2);

        entityManager.persist(workdataEntity);
        entityManager.getTransaction().commit();

        MainQuery.closeConnection(entityManager);


    }

    public static List<WorkEntity> getWorks() {
        EntityManager entityManager = MainQuery.initialConnection();

        Query query = entityManager.createQuery("SELECT s from WorkEntity s WHERE s.idcollection =" + CollectionDataController.collectionEntity.getIdcollection());
        List<WorkEntity> workEntities = query.getResultList();

        MainQuery.closeConnection(entityManager);

        return workEntities;
    }

    public static WorkdataEntity getWorkData(EntityManager entityManager ,int i) {

        Query query = entityManager.createQuery("SELECT s from WorkdataEntity s WHERE s.idWork =" + i);
        List<WorkdataEntity> workdataEntities = query.getResultList();
        WorkdataEntity workdataEntity = workdataEntities.get(0);

        return workdataEntity;
    }

    public static WorkdataEntity getWorkData(int i) {
        EntityManager entityManager = MainQuery.initialConnection();

        Query query = entityManager.createQuery("SELECT s from WorkdataEntity s WHERE s.idWork =" + i);
        List<WorkdataEntity> workdataEntities = query.getResultList();
        WorkdataEntity workdataEntity = workdataEntities.get(0);

        MainQuery.closeConnection(entityManager);

        return workdataEntity;
    }

    public static void editImageId(int i){
        EntityManager entityManager = MainQuery.initialConnection();

        entityManager.getTransaction().begin();

        WorkdataEntity workdataEntity=getWorkData(WorkDataController.workEntity.getIdwork());
        workdataEntity.setIdImage(i);

        entityManager.merge(workdataEntity);
        entityManager.getTransaction().commit();
        MainQuery.closeConnection(entityManager);
    }
}
