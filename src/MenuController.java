import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.w3c.dom.css.CSS2Properties;
import javafx.scene.paint.Color;


public class MenuController {
    public javafx.scene.shape.Rectangle play;
    public javafx.scene.shape.Rectangle options;
    public javafx.scene.shape.Rectangle exit;
    public javafx.scene.shape.Polygon pfeilrechts;
    public javafx.scene.shape.Polygon pfeillinks;
    public javafx.scene.text.Text playerZahl;

    public int playerAnzahl = 1;
    public String a = "penis";

    public void startknopf(MouseEvent mouseEvent) throws Exception{
        Pane root = FXMLLoader.load(getClass().getResource("/Resources/roulettefeld.fxml"));
        Stage stage = (Stage) play.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("The Game");
    }

    @FXML
    public void mausbewegtPlay(MouseEvent mouseEvent) throws Exception{
        play.setStroke(Color.YELLOW);
    }
    public void mausbewegtOptions(MouseEvent mouseEvent) {
        options.setStroke(Color.YELLOW);
    }
    public void mausbewegtExit(MouseEvent mouseEvent) {
        exit.setStroke(Color.YELLOW);
    }
    public void mausrausOptions(MouseEvent mouseEvent) {
    options.setStroke(Color.BLACK);
    }
    public void mausrausExit(MouseEvent mouseEvent) {
        exit.setStroke(Color.BLACK);
    }
    public void mausrausPlay(MouseEvent mouseEvent) {
        play.setStroke(Color.BLACK);
    }
    public void pfeilrechtsBewegt(MouseEvent mouseEvent) {
        pfeilrechts.setStroke(Color.YELLOW);
    }
    public void pfleillinksBewegt(MouseEvent mouseEvent) {
        pfeillinks.setStroke(Color.YELLOW);
    }
    public void pfeilrechtsRaus(MouseEvent mouseEvent) {
        pfeilrechts.setStroke(Color.BLACK);
    }
    public void pfeillinksRaus(MouseEvent mouseEvent) {
        pfeillinks.setStroke(Color.BLACK);
    }

    public void pfeilrechtsPressed(MouseEvent mouseEvent) {
        if (playerAnzahl < 4) {
            playerAnzahl++;
            String a = String.valueOf(playerAnzahl);
            playerZahl.setText(a);
        }
    }

    public void pfeillinksPressed(MouseEvent mouseEvent) {
        if (playerAnzahl > 1){
            playerAnzahl--;
            String a = String.valueOf(playerAnzahl);
            playerZahl.setText(a);
        }
    }
}
