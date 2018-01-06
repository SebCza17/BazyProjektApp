package project;

import ConnectionClass.MainConn;
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
