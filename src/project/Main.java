package project;

import JPAEntity.UserEntity;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.IOException;
import java.util.List;

public class Main extends Application {

    private Stage primaryStage;
    private BorderPane MainScene;
    private GridPane LoginOrRegister;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("BazyProjektApp");

        initMainScene();

        initLoginOrRegister();
    }

    public void initMainScene() {
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("FXML/MainScene.fxml"));
            MainScene = loader.load();

            Scene scene = new Scene(MainScene);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void initLoginOrRegister() {
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("FXML/LoginOrRegister.fxml"));
            LoginOrRegister = loader.load();

            MainScene.setCenter(LoginOrRegister);

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Query query = entityManager.createQuery("Select s from UserEntity s");
        List<UserEntity> userEntityList = query.getResultList();
        UserEntity userEntity = userEntityList.get(0);
        System.out.println(userEntity.getEmail());


        launch(args);
    }
}
