package project;

import ConnectionClass.MainQuery;
import JPAEntity.CollectionEntity;
import JPAEntity.UserEntity;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private static Stage primaryStage;
    private static BorderPane FrameBeforeLogin;
    private static BorderPane FrameAfterLogin;
    private static GridPane LoginOrRegister;
    private static GridPane MyProfile;
    private static AnchorPane CollectionView;
    private static AnchorPane CollectionData;

    public static UserEntity userEntity = null;
    public static CollectionEntity collectionEntity = null;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("BazyProjektApp");

        initMainFrameBeforeLogin();
    }

    public static void initMainFrameBeforeLogin() {
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("FXML/BeforeLoginMainFrame.fxml"));
            FrameBeforeLogin = loader.load();

            Scene scene = new Scene(FrameBeforeLogin);
            primaryStage.setScene(scene);
            primaryStage.show();

            initLoginOrRegister();

        } catch (IOException e){
            e.printStackTrace();
        }

    }

    public static void initMainFrameAfterLogin() {
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("FXML/AfterLoginMainFrame.fxml"));
            FrameAfterLogin = loader.load();

            Scene scene = new Scene(FrameAfterLogin);
            primaryStage.setScene(scene);
            primaryStage.show();

            initCollectionView();

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private static void initLoginOrRegister() {
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("FXML/LoginOrRegister.fxml"));
            LoginOrRegister = loader.load();

            FrameBeforeLogin.setCenter(LoginOrRegister);

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void initMyProfile() {
         try{ FXMLLoader loader = new FXMLLoader();
             loader.setLocation(Main.class.getResource("FXML/MyProfile.fxml"));
             MyProfile = loader.load();

             FrameAfterLogin.setCenter(MyProfile);

        }catch (IOException e) {
             e.printStackTrace();
    }

    }

    public static void initCollectionView(){
        try{ FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("FXML/CollectionView.fxml"));
            CollectionView = loader.load();

            FrameAfterLogin.setCenter(CollectionView);
            BorderPane.setAlignment(CollectionView, Pos.TOP_LEFT);
            

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void showRegister(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("FXML/Register.fxml"));
            AnchorPane page = loader.load();

            Stage registerStage = new Stage();
            //registerStage.setTitle("Rejestracja nowego użytkownika");
            registerStage.initModality(Modality.WINDOW_MODAL);
            registerStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            registerStage.setScene(scene);

            registerStage.setMinHeight(259);
            registerStage.setMaxHeight(259);
            registerStage.setMinWidth(216);
            registerStage.setMaxWidth(216);

            registerStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void showCollectionData(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("FXML/CollectionData.fxml"));
            AnchorPane page = loader.load();

            Stage collectionDataStage = new Stage();
            //collectionDataStage.initModality(Modality.WINDOW_MODAL);
            collectionDataStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            collectionDataStage.setScene(scene);

            collectionDataStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void showAddWork(){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("FXML/AddWork.fxml"));
            Accordion page = loader.load();

            Stage newWork = new Stage();
            newWork.initModality(Modality.WINDOW_MODAL);
            newWork.initOwner(primaryStage);
            Scene scene = new Scene(page);
            newWork.setScene(scene);
            //newWork.setMinWidth(506);
            //newWork.setMinHeight(379);

            newWork.showAndWait();


        } catch (IOException e){
            e.printStackTrace();
        }

    }

    public static void showLogin(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("FXML/Login.fxml"));
            AnchorPane page = loader.load();

            Stage registerStage = new Stage();
            registerStage.initModality(Modality.WINDOW_MODAL);
            registerStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            registerStage.setScene(scene);

            registerStage.setMinHeight(259);
            registerStage.setMaxHeight(259);
            registerStage.setMinWidth(216);
            registerStage.setMaxWidth(216);

            registerStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addCollection(){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("FXML/AddCollection.fxml"));
            Accordion page = loader.load();

            Stage newCollection = new Stage();
            newCollection.initModality(Modality.WINDOW_MODAL);
            newCollection.initOwner(primaryStage);
            Scene scene = new Scene(page);
            newCollection.setScene(scene);
            newCollection.setMinWidth(506);
            newCollection.setMinHeight(379);

            newCollection.showAndWait();


        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

       MainQuery.testConnection();

        launch(args);
    }
}
