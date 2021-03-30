package lab09;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static final double stageHeight = 600;
    public static final double stageWidth = 800;
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/sample.fxml"));
        primaryStage.setTitle("Lab 09: Stock Performance");
        primaryStage.setScene(new Scene(root, stageWidth, stageHeight));
        primaryStage.setResizable( false );
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
