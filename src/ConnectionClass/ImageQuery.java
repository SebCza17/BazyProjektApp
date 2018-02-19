package ConnectionClass;
import JPAEntity.ImagesEntity;
import JPAEntity.UserdataEntity;
import javafx.scene.image.Image;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.*;
import java.net.MalformedURLException;
import java.util.List;

public class ImageQuery {

    public static byte[] convertFile(File pictureFile){

        byte[] picInBytes = new byte[(int) pictureFile.length()];
        try {
            FileInputStream fileInputStream = new FileInputStream(pictureFile);
            fileInputStream.read(picInBytes);
            fileInputStream.close();
        }catch (IOException e){
            System.out.print("buuuu");
        }

        return picInBytes;
    }

    public static int addProfilePicture(File pictureFile){
        EntityManager entityManager = MainQuery.initialConnection();
        entityManager.getTransaction().begin();

        //DODAWANIE ZDJĘCIA DO BAZY
        ImagesEntity imagesEntity= new ImagesEntity();

        byte[] picInBytes = convertFile(pictureFile);

        imagesEntity.setPicture(picInBytes);

        entityManager.persist(imagesEntity);
        entityManager.getTransaction().commit();

        return imagesEntity.getIdimage();
    }

    public static Image getPicture(int i) throws MalformedURLException {
        EntityManager entityManager = MainQuery.initialConnection();
        Query query = entityManager.createQuery("SELECT s from ImagesEntity s WHERE s.idimage ="+ i );
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

        Image image = new Image(file.toURL().toString());

        return image;
    }


}