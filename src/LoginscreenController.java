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

public class LoginscreenController {
    String name = "kek";
    String password = "1234";
    String a;
    String b;
    @FXML
    private TextField nameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button signup;
    @FXML
    private AnchorPane menueField;

    public LoginscreenController() {
    }
    @FXML
    public void startmenuStage() throws Exception{
        Pane root = FXMLLoader.load(getClass().getResource("/Resources/menu.fxml"));
        Stage stage = (Stage) nameField.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Menu");
    }
    @FXML
    public void initialize(URL url, ResourceBundle rb) {
    }

    public void anmelden(ActionEvent event) throws Exception {
        if (this.nameField.getText().equals(this.name) && this.passwordField.getText().equals(this.password)) {
            System.out.println("Anmeldung erfolgreich");
            startmenuStage();
        } else {
            System.out.println("Anmeldung fehlgeschlagen");
        }

    }

    public void showLIne(MouseEvent mouseEvent) {
    }
}
