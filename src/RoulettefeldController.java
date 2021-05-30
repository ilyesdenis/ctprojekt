import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.awt.*;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Random;


public class RoulettefeldController implements Initializable {

    Random rand = new Random();

    @FXML
    private MediaView mediaView;
    private File file;
    private Media media;
    private MediaPlayer mediaPlayer;
    public Text spindisplay;
    public Text textKugel;
    //Buttons
    public Rectangle zero,three,two,one,six,five,four,nine,eight,seven,twelve,eleven,firsttwelve,ten,onetoeighteen,even, twentyone,twenty,row1,row2,row3,thirtyfour,thirtyfive,thirtysix,thirtyone;
    public Rectangle thirtytwo,thirtythree,twetnyeight,twentynine,thirty,twentyfive,twentysix,twentyseven,nineteen,twentytwo,twentythree,twentyfour,sixteen,seventeen,eighteen,nineteentothirtysix;
    public Rectangle odd,black,red,thirteen,thirdtwelve,secoundtwelve,fourteen,fifteen;
    int kugelpos;

// winning Number displayed

    @FXML
    void DisplayNumber(ActionEvent event) {
        kugelpos = rand.nextInt(37);
        System.out.println(kugelpos);
        textKugel.setText("Winning Number: "+String.valueOf(kugelpos));
    }


    @Override
    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        file= new File("./src/mov/asd.mp4");
        media=new Media(file.toURI().toString());
        mediaPlayer=new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);
        //spin();//EXPERIMENTAL SHIT

    }



    //public void spin(){
     //   mediaPlayer.play();
      //  spindisplay.setText("ASD");
 //   }

//Buttons
    public void zero(MouseEvent mouseEvent) {
        System.out.println("ZERO");
    }

    public void three(MouseEvent mouseEvent) {
        System.out.println("3");
    }

    public void two(MouseEvent mouseEvent) {
        System.out.println("2");
    }

    public void one(MouseEvent mouseEvent) {
        System.out.println("1");
    }

    public void six(MouseEvent mouseEvent) {
        System.out.println("6");
    }

    public void five(MouseEvent mouseEvent) {
        System.out.println("5");
    }

    public void four(MouseEvent mouseEvent) {
        System.out.println("4");
    }

    public void nine(MouseEvent mouseEvent) {
        System.out.println("9");
    }

    public void eight(MouseEvent mouseEvent) {
        System.out.println("8");
    }

    public void seven(MouseEvent mouseEvent) {
        System.out.println("7");
    }

    public void twelve(MouseEvent mouseEvent) {
        System.out.println("12");
    }

    public void eleven(MouseEvent mouseEvent) {
        System.out.println("11");
    }

    public void ten(MouseEvent mouseEvent) {
        System.out.println("10");
    }

    public void firsttwelve(MouseEvent mouseEvent) {
        System.out.println("1st12");
    }

    public void onetoeighteen(MouseEvent mouseEvent) {
        System.out.println("1to18");
    }

    public void even(MouseEvent mouseEvent) {
        System.out.println("even");
    }

    public void fifteen(MouseEvent mouseEvent) {
    }

    public void fourteen(MouseEvent mouseEvent) {
    }

    public void thirteen(MouseEvent mouseEvent) {
    }

    public void secoundtwelve(MouseEvent mouseEvent) {
    }

    public void thirdtwelve(MouseEvent mouseEvent) {
    }

    public void red(MouseEvent mouseEvent) {

    }

    public void black(MouseEvent mouseEvent) {
    }

    public void odd(MouseEvent mouseEvent) {
    }

    public void nineteentothirtysix(MouseEvent mouseEvent) {
    }

    public void eighteen(MouseEvent mouseEvent) {
    }

    public void seventeen(MouseEvent mouseEvent) {
    }

    public void sixteen(MouseEvent mouseEvent) {
    }

    public void twentyfour(MouseEvent mouseEvent) {
    }

    public void twentythree(MouseEvent mouseEvent) {
    }

    public void twentytwo(MouseEvent mouseEvent) {
    }

    public void twentyseven(MouseEvent mouseEvent) {
    }

    public void twentysix(MouseEvent mouseEvent) {
    }

    public void twentyfive(MouseEvent mouseEvent) {
    }

    public void thirty(MouseEvent mouseEvent) {
    }

    public void twentynine(MouseEvent mouseEvent) {
    }

    public void twetnyeight(MouseEvent mouseEvent) {
    }

    public void thirtythree(MouseEvent mouseEvent) {
    }

    public void thirtytwo(MouseEvent mouseEvent) {
    }

    public void thirtyone(MouseEvent mouseEvent) {
    }

    public void thirtysix(MouseEvent mouseEvent) {
    }

    public void thirtyfive(MouseEvent mouseEvent) {
    }

    public void thirtyfour(MouseEvent mouseEvent) {
    }

    public void row2(MouseEvent mouseEvent) {
    }

    public void row3(MouseEvent mouseEvent) {
    }

    public void row1(MouseEvent mouseEvent) {
    }

    public void twentyone(MouseEvent mouseEvent) {
    }

    public void twenty(MouseEvent mouseEvent) {
    }

    public void nineteen(MouseEvent mouseEvent) {
    }
}
