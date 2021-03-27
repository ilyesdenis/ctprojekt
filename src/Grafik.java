import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;


public class Grafik extends Application {
    public void showKugelLandOn(int kugelpos) { //TODO a video should show kugel landing on kugelpos
    }

    @FXML
    public ProgressBar pb;



    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent loadingScreenRoot = FXMLLoader.load(getClass().getResource("Resources/loadingscreen.fxml"));
        primaryStage.setTitle("Roulette");
        primaryStage.setScene(new Scene(loadingScreenRoot));
        primaryStage.show();
        // pb.setProgress(0.1); //TODO MAKE IT WORK!!!!!!!!!!!!!!!!!!!!


    }





}
