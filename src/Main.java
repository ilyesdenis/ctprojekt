import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main extends Application {
    Stage primaryStage;








    // start of programm

    public static void main(String[] args) throws Exception {
	LoadingscreenController loadingscreenController =new LoadingscreenController();
       // grafik.initialise(); Experimental!!Experimental!!Experimental!!Experimental!!Experimental!!Experimental!!Experimental!
    Application.launch();
    }




    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/Resources/loadingscreen.fxml"));
        primaryStage.setTitle("Roulette v0.0.01");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

}
