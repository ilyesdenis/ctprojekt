import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
//import java.util.Random;


public class RoulettefeldController implements Initializable {

  //  Random rand = new Random();

    @FXML

    private MediaView mediaView;
    private File file;
    private Media media;
    private MediaPlayer mediaPlayer;
    public Text spindisplay;
    public Text textKugel;
    //Buttons
    public Rectangle zero, three, two, one, six, five, four, nine, eight, seven, twelve, eleven, firsttwelve, ten, onetoeighteen, even, twentyone, twenty, row1, row2, row3, thirtyfour, thirtyfive, thirtysix, thirtyone;
    public Rectangle thirtytwo, thirtythree, twetnyeight, twentynine, thirty, twentyfive, twentysix, twentyseven, nineteen, twentytwo, twentythree, twentyfour, sixteen, seventeen, eighteen, nineteenToThirtysix;
    public Rectangle odd, black, red, thirteen, third12, secondtwelve, fourteen, fifteen;
    int kugelpos, spin = 0;


    private int[] bets=new int[50];
    int chips=10;
    private Calc calc=new Calc();


// winning Number displayed

    @FXML
    void DisplayNumber(ActionEvent event) throws InterruptedException {
        spin();
        this.kugelpos=getspin();
        spin++;
       // kugelpos = rand.nextInt(37);
        System.out.println(kugelpos);
        textKugel.setText("Winning Number: " + String.valueOf(kugelpos) + "\n amount of spins" + String.valueOf(spin)+"\n won:"+getwin());
        resetbets();
        System.out.println("--------------------------------------------");
    }


    @Override
    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        file = new File("./src/mov/asd.mp4");
        media = new Media(file.toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);
        //spin();//EXPERIMENTAL SHIT

    }


 public void spin(){
        mediaPlayer.seek(Duration.millis(0)); //jump to sec 0
        mediaPlayer.play();
       //spindisplay.setText("ASD");
      }

    //Buttons
    public void zero(MouseEvent mouseEvent) {
        System.out.println("ZERO");
        bets[0]=bets[0]+chips;
    }

    public void three(MouseEvent mouseEvent) {
        System.out.println("3");
        bets[3]=bets[3]+chips;
    }

    public void two(MouseEvent mouseEvent) {
        System.out.println("2");
        bets[2]=bets[2]+chips;
    }

    public void one(MouseEvent mouseEvent) {
        System.out.println("1");
        bets[1]=bets[1]+chips;
    }

    public void six(MouseEvent mouseEvent) {
        System.out.println("6");
        bets[6]=bets[6]+chips;
    }

    public void five(MouseEvent mouseEvent) {
        System.out.println("5");
        bets[5]=bets[5]+chips;
    }

    public void four(MouseEvent mouseEvent) {
        System.out.println("4");
        bets[4]=bets[4]+chips;
    }

    public void nine(MouseEvent mouseEvent) {
        System.out.println("9");
        bets[9]=bets[9]+chips;
    }

    public void eight(MouseEvent mouseEvent) {
        System.out.println("8");
        bets[8]=bets[8]+chips;
    }

    public void seven(MouseEvent mouseEvent) {
        System.out.println("7");
        bets[7]=bets[7]+chips;
    }

    public void twelve(MouseEvent mouseEvent) {
        System.out.println("12");
        bets[12]=bets[12]+chips;
    }

    public void eleven(MouseEvent mouseEvent) {
        System.out.println("11");
        bets[11]=bets[11]+chips;
    }

    public void ten(MouseEvent mouseEvent) {
        System.out.println("10");
        bets[10]=bets[10]+chips;
    }

    public void firsttwelve(MouseEvent mouseEvent) {
        System.out.println("1st12");
        bets[37]=bets[37]+chips;
    }

    public void onetoeighteen(MouseEvent mouseEvent) {
        System.out.println("1to18");
        bets[38]=bets[38]+chips;
    }

    public void even(MouseEvent mouseEvent) {
        System.out.println("even");
        bets[39]=bets[39]+chips;
    }

    public void fifteen(MouseEvent mouseEvent) {
        bets[15]=bets[15]+chips;
    }

    public void fourteen(MouseEvent mouseEvent) {
        bets[14]=bets[14]+chips;
    }

    public void thirteen(MouseEvent mouseEvent) {
        bets[13]=bets[13]+chips;
    }

    public void secoundtwelve(MouseEvent mouseEvent) {
        bets[40]=bets[40]+chips;
    }

    public void thirdtwelve(MouseEvent mouseEvent) {
        bets[41]=bets[41]+chips;
    }

    public void red(MouseEvent mouseEvent) {
        bets[42]=bets[42]+chips;
    }

    public void black(MouseEvent mouseEvent) {
        bets[43]=bets[43]+chips;
       // System.out.println("DEBUG BLACK");
    }

    public void odd(MouseEvent mouseEvent) {
        bets[44]=bets[44]+chips;
    }

    public void nineteentothirtysix(MouseEvent mouseEvent) {
        bets[45]=bets[45]+chips;
    }

    public void eighteen(MouseEvent mouseEvent) {
        bets[18]=bets[18]+chips;
    }

    public void seventeen(MouseEvent mouseEvent) {
        bets[17]=bets[17]+chips;
    }

    public void sixteen(MouseEvent mouseEvent) {
        bets[16]=bets[16]+chips;
    }

    public void twentyfour(MouseEvent mouseEvent) {
        bets[24]=bets[24]+chips;
    }

    public void twentythree(MouseEvent mouseEvent) {
        bets[23]=bets[23]+chips;
    }

    public void twentytwo(MouseEvent mouseEvent) {
        bets[22]=bets[22]+chips;
    }

    public void twentyseven(MouseEvent mouseEvent) {
        bets[27]=bets[27]+chips;
    }

    public void twentysix(MouseEvent mouseEvent) {
        bets[26]=bets[26]+chips;
    }

    public void twentyfive(MouseEvent mouseEvent) {
        bets[25]=bets[25]+chips;
    }

    public void thirty(MouseEvent mouseEvent) {
        bets[30]=bets[30]+chips;
    }

    public void twentynine(MouseEvent mouseEvent) {
        bets[19]=bets[19]+chips;
    }

    public void twetnyeight(MouseEvent mouseEvent) {
        bets[28]=bets[28]+chips;
    }

    public void thirtythree(MouseEvent mouseEvent) {
        bets[33]=bets[33]+chips;
    }

    public void thirtytwo(MouseEvent mouseEvent) {
        bets[32]=bets[32]+chips;
    }

    public void thirtyone(MouseEvent mouseEvent) {
        bets[31]=bets[31]+chips;
    }

    public void thirtysix(MouseEvent mouseEvent) {
        bets[36]=bets[36]+chips;
    }

    public void thirtyfive(MouseEvent mouseEvent) {
        bets[35]=bets[35]+chips;
    }

    public void thirtyfour(MouseEvent mouseEvent) {
        bets[34]=bets[34]+chips;
    }

    public void row2(MouseEvent mouseEvent) {
        bets[47]=bets[47]+chips;
    }

    public void row3(MouseEvent mouseEvent) {
        bets[48]=bets[48]+chips;
    }

    public void row1(MouseEvent mouseEvent) {
        bets[49]=bets[49]+chips;
    }

    public void twentyone(MouseEvent mouseEvent) {
        bets[21]=bets[21]+chips;
    }

    public void twenty(MouseEvent mouseEvent) {
        bets[20]=bets[20]+chips;
    }

    public void nineteen(MouseEvent mouseEvent) {
        bets[19]=bets[19]+chips;
    }

    public int getspin() {
        return calc.spinit();
    }
    public int getwin() { return calc.calculateWin(bets); }
    private void resetbets() {
        for (int i = 0; i <50 ; i++) {
          bets[i]=0;
        }
    }
}
