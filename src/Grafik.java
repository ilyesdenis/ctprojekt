import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Grafik extends Application {
    public void showKugelLandOn(int kugelpos) { //TODO a video should show kugel landing on kugelpos
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent loadingScreenRoot = FXMLLoader.load(getClass().getResource("loadingscreen.fxml"));
        primaryStage.setTitle("Roulette");
        primaryStage.setScene(new Scene(loadingScreenRoot));
        primaryStage.show();
    }
}
