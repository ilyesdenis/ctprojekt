import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import jdk.jfr.Experimental;


public class Grafik {
    public void showKugelLandOn(int kugelpos) { //TODO a video should show kugel landing on kugelpos
    }
    boolean clickedtoStart=false;
    @FXML public ProgressBar pb;
   // @FXML public AnchorPane ap; !Experimental!

    /* @FXML  Experimental!!Experimental!!Experimental!!Experimental!!Experimental!!Experimental!!Experimental!
     public void onKeyPressed(KeyEvent keyEvent) {
     if (keyEvent.getCode() == KeyCode.SPACE) {
         System.out.println("Enter Pressed"); //Why the fuck dont´t you work
         this.pb.setProgress(0.1);// ?
     }
 }*/
    @FXML
    public void onMauseClicked(MouseEvent mouseEvent) throws InterruptedException {
        /*if (clickedtoStart=false) { TODO figure out WTF is wrong with this
          */double i = 0;
            do {
                i = i + 0.0001;
                pb.setProgress(i);
                for (int j = 0; j < 1000000; j++) {
                    for (int k = 0; k < 1000000; k++) {
                    }
                }
                ;
            } while (i < 1);
        /* }
       clickedtoStart=true; */

    }

   /* @FXML !Experimental!!Experimental!!Experimental!!Experimental!!Experimental!!Experimental!!Experimental!
    public  void initialise(){
        pb.setProgress(0.1);
    }*/





}
