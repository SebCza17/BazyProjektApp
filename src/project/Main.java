package project;

import ConnectionClass.MainConn;
import JPAEntity.UserEntity;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private static Stage primaryStage;
    private BorderPane FrameBeforeLogin;
    private static BorderPane FrameAfterLogin;
    private GridPane LoginOrRegister;

    public static UserEntity userEntity = null;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("BazyProjektApp");

        initMainFrameBeforeLogin();

        initLoginOrRegister();
    }

    public void initMainFrameBeforeLogin() {
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("FXML/BeforeLoginMainFrame.fxml"));
            FrameBeforeLogin = loader.load();

            Scene scene = new Scene(FrameBeforeLogin);
            primaryStage.setScene(scene);
            primaryStage.show();
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
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void initLoginOrRegister() {
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("FXML/LoginOrRegister.fxml"));
            LoginOrRegister = loader.load();

            FrameBeforeLogin.setCenter(LoginOrRegister);

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

    public static void main(String[] args) {

       MainConn.test();

        launch(args);
    }
}
