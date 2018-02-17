package ConnectionClass;
import JPAEntity.ImagesEntity;
import JPAEntity.UserdataEntity;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.*;
import java.util.List;

public class ImageQuery {

    public static void addProfilePicture(File pictureFile){
        EntityManager entityManager = MainQuery.initialConnection();
        entityManager.getTransaction().begin();

        //DODAWANIE ZDJĘCIA DO BAZY
        ImagesEntity imagesEntity= new ImagesEntity();

        byte[] picInBytes = new byte[(int) pictureFile.length()];
        try {
            FileInputStream fileInputStream = new FileInputStream(pictureFile);
            fileInputStream.read(picInBytes);
            fileInputStream.close();
        }catch (IOException e){
            System.out.print("buuuu");
        }
        imagesEntity.setPicture(picInBytes);

        entityManager.persist(imagesEntity);
        entityManager.getTransaction().commit();


                            //PRZYPISYWANIE DO PROFILU
        entityManager.getTransaction().begin();

        UserdataEntity userdataEntity=MainQuery.getUserData();
        userdataEntity.setIdImage(imagesEntity.getIdimage());

        entityManager.merge(userdataEntity);
        entityManager.getTransaction().commit();
        MainQuery.closeConnection(entityManager);
    }

    public static void getPicture(ImagesEntity imagesEntity){
        EntityManager entityManager = MainQuery.initialConnection();
        Query query = entityManager.createQuery("SELECT s from ImagesEntity s WHERE s.idimage ="+imagesEntity.getIdimage());
        List<ImagesEntity> imagesEntities = query.getResultList();
        ImagesEntity imagesEntity1 = imagesEntities.get(0);



        byte[] bytes = imagesEntity1.getPicture();
        File file = new File("src//andrzej2.jpg");

        try {
            OutputStream os = new FileOutputStream(file);
            os.write(bytes);
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}