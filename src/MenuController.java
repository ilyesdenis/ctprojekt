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


public class MenuController {
    public javafx.scene.shape.Rectangle play;

    public void startknopf(MouseEvent mouseEvent) throws Exception{
        System.out.println("du hurensohn");

    }

    @FXML
    public void mausbewegtPlay(MouseEvent mouseEvent) throws Exception{
        System.out.println("Penis");
        play.setStrokeWidth(2000);
        



    }

    public void mausbewegtOptions(MouseEvent mouseEvent) {
    }

    public void mausbewegtExit(MouseEvent mouseEvent) {
    }
}
