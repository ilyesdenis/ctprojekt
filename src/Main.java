import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) throws Exception {
	Grafik grafik=new Grafik();
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
