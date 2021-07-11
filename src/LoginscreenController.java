import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class LoginscreenController  {

    MySql_Database sql = new MySql_Database();

    String rname ;
    String rpassword ;

    @FXML
    private TextField nameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button signup;
    @FXML
    private AnchorPane menueField;
    @FXML
    private TextField nameField1;
    @FXML
    private PasswordField passwordField1;
    @FXML
    private Text failedlogin;



    public LoginscreenController() throws SQLException {
    }

    public void startmenuStage() throws Exception{
        Pane root = FXMLLoader.load(getClass().getResource("/Resources/menu.fxml"));
        Stage stage = (Stage) nameField.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Menu");
    }


    public void anmelden(ActionEvent event) throws Exception {
        rname = nameField.getText();
        rpassword = passwordField.getText();
        sql.checkData(rname, rpassword);
        if (sql.angemeldet == true) {
            startmenuStage();
        }
        else{
            failedlogin.setText("Anmeldung fehlgeschlagen");
            System.out.println("Anmelden fehlgeschlagen");
        }

    }

    public void register(ActionEvent actionEvent) throws Exception {
        rname = nameField1.getText();
        rpassword = passwordField1.getText();
        sql.setData(rname,rpassword);
        if(sql.regestriert == true){
            startmenuStage();
        }
    }
}
