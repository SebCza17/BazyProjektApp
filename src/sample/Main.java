package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();

        Button btn1 = new Button("Test");
        Button btn2 = new Button("cos");
        Button btn3 = new Button("zmień tekst w środku");
        Button btn4 = new Button("Micek ssie");
        Button btn5 = new Button("Urban ssie");
        Button btn6 = new Button("Testtttt");
        Button btn7 = new Button("dupa");
    }


    public static void main(String[] args) {
        launch(args);
    }
}
