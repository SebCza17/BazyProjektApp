package project;

import ConnectionClass.MainQuery;
import JPAEntity.CollectionEntity;
import JPAEntity.UserEntity;
import JPAEntity.WorkEntity;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import project.Controllers.ConnectionOffController;
import project.Controllers.LoginOrRegisterController;

import java.io.IOException;

public class Main extends Application {

    private static Stage primaryStage;
    private static BorderPane FrameBeforeLogin;
    private static BorderPane FrameAfterLogin;
    private static GridPane LoginOrRegister;
    private static GridPane ConnectionOff;
    private static GridPane MyProfile;
    private static AnchorPane CollectionView;
    private static AnchorPane CollectionData;

    public static UserEntity userEntity = null;
    public static CollectionEntity collectionEntity = null;
    public static WorkEntity workEntity = null;

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

            //primaryStage.setMinWidth(825);
            //primaryStage.setMaxWidth(825);

            //primaryStage.setMinHeight(650);
            //primaryStage.setMaxHeight(650);

            primaryStage.setResizable(false);

            if(MainQuery.testConnection()){

                initLoginOrRegister();
            }
            else{
                initConnectionOff();
            }

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

            primaryStage.setMinWidth(825);
            primaryStage.setMaxWidth(825);

            primaryStage.setMinHeight(650);
            primaryStage.setMaxHeight(650);

            primaryStage.setResizable(false);

            initCollectionView();

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void initLoginOrRegister() {
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("FXML/LoginOrRegister.fxml"));
            LoginOrRegister = loader.load();

            FrameBeforeLogin.setCenter(LoginOrRegister);

        }catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void initConnectionOff() {
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("FXML/ConnectionOff.fxml"));
            ConnectionOff = loader.load();

            FrameBeforeLogin.setCenter(ConnectionOff);

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
            collectionDataStage.setResizable(false);
            collectionDataStage.titleProperty().setValue("Work List");

            collectionDataStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void showWorkData(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("FXML/WorkData.fxml"));
            AnchorPane page = loader.load();

            Stage workDataStage = new Stage();
            workDataStage.initModality(Modality.WINDOW_MODAL);
            workDataStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            workDataStage.setScene(scene);
            workDataStage.setResizable(false);

            workDataStage.showAndWait();

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

            newWork.setResizable(false);

            newWork.showAndWait();


        } catch (IOException e){
            e.printStackTrace();
        }

    }

    public static void showEditWork(){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("FXML/EditWork.fxml"));
            Accordion page = loader.load();

            Stage newWork = new Stage();
            newWork.initModality(Modality.WINDOW_MODAL);
            newWork.initOwner(primaryStage);
            Scene scene = new Scene(page);
            newWork.setScene(scene);
            //newWork.setMinWidth(506);
            //newWork.setMinHeight(379);

            newWork.setResizable(false);

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
            registerStage.setResizable(false);

            registerStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void editProfile(){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("FXML/EditProfile.fxml"));
            AnchorPane page = loader.load();

            Stage editProfile = new Stage();
            editProfile.initModality(Modality.WINDOW_MODAL);
            editProfile.initOwner(primaryStage);
            Scene scene = new Scene(page);
            editProfile.setScene(scene);

            editProfile.setResizable(false);

            editProfile.showAndWait();


        } catch (IOException e){
            e.printStackTrace();
        }

    }

    public static void editCollection(){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("FXML/EditCollection.fxml"));
            Accordion page2 = loader.load();

            Stage editCollection = new Stage();
            editCollection.initModality(Modality.WINDOW_MODAL);
            editCollection.initOwner(primaryStage);
            Scene scene = new Scene(page2);
            editCollection.setScene(scene);
            editCollection.setMinWidth(506);
            editCollection.setMaxWidth(506);
            editCollection.setMinHeight(379);
            editCollection.setMaxHeight(379);
            editCollection.setResizable(false);

            editCollection.showAndWait();


        } catch (IOException e){
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
            newCollection.setMaxWidth(506);
            newCollection.setMinHeight(379);
            newCollection.setMaxHeight(379);
            newCollection.setResizable(false);

            newCollection.showAndWait();


        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        launch(args);
    }


    public static void stageClose(ActionEvent actionEvent){
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    public static void set_cursor_waiting(final Scene scene)
    {
        Runnable r=new Runnable() {

            @Override
            public void run() {
                scene.setCursor(Cursor.WAIT);
            }
        };
        Thread t=new Thread(r);
        t.start();
    }
    public static void set_cursor_normal(final Scene scene)
    {
        Runnable r=new Runnable() {

            @Override
            public void run() {
                scene.setCursor(Cursor.DEFAULT);
            }
        };
        Thread t=new Thread(r);
        t.start();
    }
}
