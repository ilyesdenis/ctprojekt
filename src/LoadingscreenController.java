import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.util.Duration;


public class LoadingscreenController implements Initializable{
    private static final Integer STARTTIME = 15;
    private IntegerProperty timeSeconds =
            new SimpleIntegerProperty(STARTTIME*100);
    private Timeline timeline;

    boolean clickedtoStart=false;
    @FXML public ProgressBar pb;
    @FXML
    public void startloginStage() throws Exception{
        Pane root = FXMLLoader.load(getClass().getResource("/Resources/loginscreen.fxml"));
        Stage stage = (Stage) pb.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Login");
    }

    @FXML
    public void onMauseClicked(MouseEvent mouseEvent) throws Exception {
        if (timeline != null) //TODO figure out why this very sophisticated timer don`t work
        {
            timeline.stop();
        }
        timeSeconds.set((STARTTIME + 1) * 100);
        timeline = new Timeline();
        timeline.getKeyFrames().add(

                new KeyFrame(Duration.seconds(STARTTIME + 1), new KeyValue(timeSeconds, 0)));
        timeline.playFromStart();
        startloginStage();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        pb.progressProperty().bind(timeSeconds.divide(STARTTIME * 100.0).subtract(1).multiply(-1));
    }


}
