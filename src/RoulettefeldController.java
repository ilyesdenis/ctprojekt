import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.skin.CellSkinBase;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
//import java.util.Random;


public class RoulettefeldController implements Initializable {


    public AnchorPane ap;
    @FXML
    private MediaView mediaView;
    private File file;
    private Media media;
    private MediaPlayer mediaPlayer;
    public Text spindisplay;
    public Text textKugel;
    public Circle DisplayWinningNumber;
    @FXML
    private Label LbPayout;
    @FXML
    private Button BtSpin;
    @FXML
    private Button BtStartNextRound;
    @FXML
    private Label LbWinNumCircle;
    public Label LbBettingAmount;
    //Buttons
    public AnchorPane zero, three, two, one, six, five, four, nine, eight, seven, twelve, eleven, firsttwelve, ten, onetoeighteen, even, twentyone, twenty, row1, row2, row3, thirtyfour, thirtyfive, thirtysix, thirtyone;
    public AnchorPane thirtytwo, thirtythree, twetnyeight, twentynine, thirty, twentyfive, twentysix, twentyseven, nineteen, twentytwo, twentythree, twentyfour, sixteen, seventeen, eighteen, nineteentothirtysix;
    public AnchorPane odd, red, thirteen,black, thirdtwelve, secoundtwelve, fourteen, fifteen;
    /*  bet IDs:
     * 0-36-the numbers, 37-firsttwelve, 38-onetoeighteen, 39-even, 40-secoundtwelve,41-thirdtwelve
     * 42-red, 43-black, 44-odd, 45-nineteentothirtysix, 47-row2, 48-row3, 49-row1
     * */
    private String[] fieldnames={"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24",
            "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "firsttwelve", "onetoeighteen", "even", "secoundtwelve", "thirdtwelve", "red", "black","odd", "nineteentothirtysix","WTF", "row2", "row3", "row1"};
    int kugelpos, spin = 0 ;
    @FXML
    private ListView lw;
    @FXML
    public Label guthaben;
    private int[] bets=new int[50];
    private int[] chipson=new int[50];
    int chips=0;
    private Calc calc=new Calc();

    private int[]  redNumbers = {1,3,5,7,9,12,14,16,18,19,21,23,25,27,30,32,34,36};
    private int[]  blackNumbers = {2,4,6,8,10,11,13,15,17,20,22,24,26,28,29,31,33,35};

    private boolean isred=false;
//chip images -------------------------------------------------------------------------------------------------------------------------------------------------------

    Image img2= new Image("file:./src/img/chip2.png",50,50,true,true);
    Image img3= new Image("file:./src/img/chip5.png",50,50,true,true);
    Image img4= new Image("file:./src/img/chip10.png",50,50,true,true);

    ImageView iv2=new ImageView(img2);
    ImageView iv3=new ImageView(img3);
    ImageView iv4=new ImageView(img4);

    HashMap<String, ImageView> ivs = new HashMap<String, ImageView>();
    private MySql_Database sql=new MySql_Database();


//-------------------------------------------------------------------------------------------------------------------------------------------------------------------




// If Spin Button Clicked------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    @FXML
    void DisplayNumber(ActionEvent event) throws InterruptedException {

        BtSpin.setText(" !! Wheel spun !! "); // if spin Button clicked change text to "wheel spun" !! fix after time to change it back to spn

        LbWinNumCircle.setText(String.valueOf(kugelpos));
        LbPayout.setText(" You Won: " + getwin());

        BtSpin.setStyle("-fx-background-color: #2cab27"); // if Spin button clicked change color to green
        // TO show which Color the winning number has NEEED TO FIX THIS(RED)---Denis
        for (int i =0; i< 18;i++){
            if (kugelpos == redNumbers[i] ) {
                DisplayWinningNumber.setFill(Color.RED);
            }
        }
        for (int i =0; i< 18;i++){
            if (kugelpos == blackNumbers[i] ) {
                DisplayWinningNumber.setFill(Color.BLACK);
                LbWinNumCircle.setTextFill(Color.WHITE); // to see label if circle is colored black
            }
        }
        if (kugelpos== 0) {
            DisplayWinningNumber.setFill(Color.GREEN);
        }





        spin(); // display wheel video
        this.kugelpos=getspin();
        spin++;
        resetbets();
        refreshguthaben();
        System.out.println("--------------------------------------------");
    }


    @Override
    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        file = new File("./src/mov/asd.mp4"); // loads the mp4 file
        media = new Media(file.toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);
        refreshguthaben();

        for(int i = 0; i < 50; i++){
            for (int j=0;j<50;j++) {
                ivs.put(j+"chipone" + i, new ImageView(new Image("file:./src/img/chip1.png", 50, 50, true, true)));
                ivs.put(j + "chiptwo" + i, new ImageView(new Image("file:./src/img/chip2.png", 50, 50, true, true)));
                ivs.put(j + "chipfive" + i, new ImageView(new Image("file:./src/img/chip5.png", 50, 50, true, true)));
                ivs.put(j+"chipten" + i, new ImageView(new Image("file:./src/img/chip10.png",50,50,true,true)));
                ivs.put(j+"chiptwenty" + i, new ImageView(new Image("file:./src/img/chip20.png",50,50,true,true)));
                ivs.put(j+"chiptwentyfive" + i, new ImageView(new Image("file:./src/img/chip25.png",50,50,true,true)));
                ivs.put(j + "chipfifty" + i, new ImageView(new Image("file:./src/img/chip50.png", 50, 50, true, true)));
                ivs.put(j+"chiphoundred" + i, new ImageView(new Image("file:./src/img/chip100.png",50,50,true,true)));
                ivs.put(j+"chiptwohounderdfifty" + i, new ImageView(new Image("file:./src/img/chip250.png",50,50,true,true)));
                ivs.put(j+"chipfivehoundred" + i, new ImageView(new Image("file:./src/img/chip500.png",50,50,true,true)));
                ivs.put(j+"chipthausend" + i, new ImageView(new Image("file:./src/img/chip1000.png",50,50,true,true)));
                ivs.put(j+"chiptwothausend" + i, new ImageView(new Image("file:./src/img/chip2000.png",50,50,true,true)));
                ivs.put(j+"chipfivethausend" + i, new ImageView(new Image("file:./src/img/chip5000.png",50,50,true,true)));
            }
        }

    }


    public void spin(){
        mediaPlayer.seek(Duration.millis(0)); //jump to sec 0
        mediaPlayer.play();
        //spindisplay.setText("ASD");
    }
// end of spin button ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


// if Start next round button clicked ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


    @FXML
    void StartNextRound(ActionEvent event) throws InterruptedException {
        //resetGame(); // method still not created

    }
    // end of start next round -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    //roulettefield -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


    public void setbeton(int field, MouseEvent mouseEvent,AnchorPane calledby){ //sets the bet on bets and visual
        if (mouseEvent.getButton()== MouseButton.PRIMARY){
            if (sql.checkGuthaben(chips) == true) {
                bets[field]=bets[field]+chips;
                stack(calledby,chipson[field],field);
                chipson[field]++;
                refreshlist();
                try {
                    sql.setChips(chips);
                    refreshguthaben();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }else if(mouseEvent.getButton()== MouseButton.SECONDARY){
            calledby.getChildren().clear();
            try {
                sql.changeCredit(bets[field]);
            } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
            bets[field]=0;
            chipson[field]=0;
            refreshlist();
            refreshguthaben();
        }
    }

    private void refreshlist() {
        lw.getItems().clear();
        for (int i = 0; i <50 ; i++) {
            if (bets[i]>0){
                lw.getItems().add(fieldnames[i]+" --- "+bets[i]);
            }
        }
    }

    public void zero(MouseEvent mouseEvent) {
        setbeton(0,mouseEvent,zero); //
    }

    public void three(MouseEvent mouseEvent) {
        setbeton(3,mouseEvent,three);
    }

    public void two(MouseEvent mouseEvent) {
        setbeton(2,mouseEvent,two);
    }

    public void one(MouseEvent mouseEvent) {
        setbeton(1,mouseEvent,one);
    }

    public void six(MouseEvent mouseEvent) {
        setbeton(6,mouseEvent,six);
    }

    public void five(MouseEvent mouseEvent) {
        setbeton(5,mouseEvent,five);
    }

    public void four(MouseEvent mouseEvent) {
        setbeton(4,mouseEvent,four);
    }

    public void nine(MouseEvent mouseEvent) {
        setbeton(9,mouseEvent,nine);
    }

    public void eight(MouseEvent mouseEvent) {
        setbeton(8,mouseEvent,eight);
    }

    public void seven(MouseEvent mouseEvent) {
        setbeton(7,mouseEvent,seven);
    }

    public void twelve(MouseEvent mouseEvent) {
        setbeton(12,mouseEvent,twelve);
    }

    public void eleven(MouseEvent mouseEvent) {
        setbeton(11,mouseEvent,eleven);
    }

    public void ten(MouseEvent mouseEvent) {
        setbeton(10,mouseEvent,ten);
    }

    public void firsttwelve(MouseEvent mouseEvent) {
        setbeton(37,mouseEvent,firsttwelve);
    }

    public void onetoeighteen(MouseEvent mouseEvent) {
        setbeton(38,mouseEvent,onetoeighteen);
    }

    public void even(MouseEvent mouseEvent) {
        setbeton(39,mouseEvent,even);
    }

    public void fifteen(MouseEvent mouseEvent) {
        setbeton(15,mouseEvent,fifteen);
    }

    public void fourteen(MouseEvent mouseEvent) {
        setbeton(14,mouseEvent,fourteen);
    }

    public void thirteen(MouseEvent mouseEvent) {
        setbeton(13,mouseEvent,thirteen);
    }

    public void secoundtwelve(MouseEvent mouseEvent) {
        setbeton(40,mouseEvent,secoundtwelve);
    }

    public void thirdtwelve(MouseEvent mouseEvent) {
        setbeton(41,mouseEvent,thirdtwelve);
    }

    public void red(MouseEvent mouseEvent) {
        setbeton(42,mouseEvent,red);
    }

    public void black(MouseEvent mouseEvent) {
        setbeton(43,mouseEvent,black);
        // System.out.println("DEBUG BLACK");
    }

    public void odd(MouseEvent mouseEvent) {
        setbeton(44,mouseEvent,odd);
    }

    public void nineteentothirtysix(MouseEvent mouseEvent) {
        setbeton(45,mouseEvent,nineteentothirtysix);
    }

    public void eighteen(MouseEvent mouseEvent) {
        setbeton(18,mouseEvent,eighteen);
    }

    public void seventeen(MouseEvent mouseEvent) {
        setbeton(17,mouseEvent,seventeen);
    }

    public void sixteen(MouseEvent mouseEvent) {
        setbeton(16,mouseEvent,sixteen);
    }

    public void twentyfour(MouseEvent mouseEvent) {
        setbeton(24,mouseEvent,twentyfour);
    }

    public void twentythree(MouseEvent mouseEvent) {
        setbeton(23,mouseEvent,twentythree);
    }

    public void twentytwo(MouseEvent mouseEvent) {
        setbeton(22,mouseEvent,twentytwo);
    }

    public void twentyseven(MouseEvent mouseEvent) {
        setbeton(27,mouseEvent,twentyseven);
    }

    public void twentysix(MouseEvent mouseEvent) {
        setbeton(26,mouseEvent,twentysix);
    }

    public void twentyfive(MouseEvent mouseEvent) {
        setbeton(25,mouseEvent,twentyfive);
    }

    public void thirty(MouseEvent mouseEvent) {
        setbeton(30,mouseEvent,thirty);
    }

    public void twentynine(MouseEvent mouseEvent) {
        setbeton(29,mouseEvent,twentynine);
    }

    public void twetnyeight(MouseEvent mouseEvent) {
        setbeton(28,mouseEvent,twetnyeight);
    }

    public void thirtythree(MouseEvent mouseEvent) {
        setbeton(33,mouseEvent,thirtythree);;
    }

    public void thirtytwo(MouseEvent mouseEvent) {
        setbeton(32,mouseEvent,thirtytwo);
    }

    public void thirtyone(MouseEvent mouseEvent) {
        setbeton(31,mouseEvent,thirtyone);
    }

    public void thirtysix(MouseEvent mouseEvent) {
        setbeton(36,mouseEvent,thirtysix);
    }

    public void thirtyfive(MouseEvent mouseEvent) {
        setbeton(35,mouseEvent,thirtyfive);
    }

    public void thirtyfour(MouseEvent mouseEvent) {
        setbeton(34,mouseEvent,thirtyfour);
    }

    public void row2(MouseEvent mouseEvent) {
        setbeton(47,mouseEvent,row2);
    }

    public void row3(MouseEvent mouseEvent) {
        setbeton(48,mouseEvent,row3);
    }

    public void row1(MouseEvent mouseEvent) {
        setbeton(49,mouseEvent,row1);
    }

    public void twentyone(MouseEvent mouseEvent) {
        setbeton(21,mouseEvent,twentyone);
    }

    public void twenty(MouseEvent mouseEvent) {
        setbeton(20,mouseEvent,twenty);
    }

    public void nineteen(MouseEvent mouseEvent) {
        setbeton(19,mouseEvent,nineteen);
    }



// END OF ROULETTEFIELD -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    public int getspin() {
        return calc.spinit();
    } //handled in Calc
    public int getwin() { return calc.calculateWin(bets); } //handled in Calc
    private void resetbets() {
        for (int i = 0; i <50 ; i++) {
            bets[i]=0;
            //  fieldnames[i].getChildren().clear();// visual chip reset
        }
        //Quick and dirty reset
        zero.getChildren().clear();
        three.getChildren().clear();
        two.getChildren().clear();
        one.getChildren().clear();
        six.getChildren().clear();
        five.getChildren().clear();
        four.getChildren().clear();
        nine.getChildren().clear();
        eight.getChildren().clear();
        seven.getChildren().clear();
        twelve.getChildren().clear();
        eleven.getChildren().clear();
        firsttwelve.getChildren().clear();
        ten.getChildren().clear();
        onetoeighteen.getChildren().clear();
        even.getChildren().clear();
        twentyone.getChildren().clear();
        twenty.getChildren().clear();
        row1.getChildren().clear();
        row2.getChildren().clear();
        row3.getChildren().clear();
        thirtyfour.getChildren().clear();
        thirtyfive.getChildren().clear();
        thirtysix.getChildren().clear();
        thirtyone.getChildren().clear();
        thirtytwo.getChildren().clear();
        thirtythree.getChildren().clear();
        twetnyeight.getChildren().clear();
        twentynine.getChildren().clear();
        thirty.getChildren().clear();
        twentyfive.getChildren().clear();
        twentysix.getChildren().clear();
        twentyseven.getChildren().clear();
        nineteen.getChildren().clear();
        twentytwo.getChildren().clear();
        twentythree.getChildren().clear();
        twentyfour.getChildren().clear();
        sixteen.getChildren().clear();
        seventeen.getChildren().clear();
        eighteen.getChildren().clear();
        nineteentothirtysix.getChildren().clear();
        odd.getChildren().clear();
        red.getChildren().clear();
        thirteen.getChildren().clear();
        black.getChildren().clear();
        thirdtwelve.getChildren().clear();
        secoundtwelve.getChildren().clear();
        fourteen.getChildren().clear();
        fifteen.getChildren().clear();
        refreshlist();
    }





// getting betting amount ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    @FXML
    void bettingAmount1(MouseEvent event) {
        chips = 1;
        LbBettingAmount.setText( " Your betting amounnt is : " + chips);

    }
    @FXML
    void bettingAmount2(MouseEvent event) {
        chips = 2;
        LbBettingAmount.setText( " Your betting amounnt is : " + chips);

    }

    @FXML
    void bettingAmount5(MouseEvent event) {
        chips = 5;
        LbBettingAmount.setText( " Your betting amounnt is : " + chips);

    }

    @FXML
    void bettingAmount10(MouseEvent event){
        chips =10;
        LbBettingAmount.setText( " Your betting amounnt is : " + chips);

    }


    @FXML
    void bettingAmount20(MouseEvent event) {
        chips = 20;
        LbBettingAmount.setText( " Your betting amounnt is : " + chips);

    }

    @FXML
    void bettingAmount25(MouseEvent event) {
        chips = 25;
        LbBettingAmount.setText( " Your betting amounnt is : " + chips);
    }

    @FXML
    void bettingAmount50(MouseEvent event) {
        chips = 50;
        LbBettingAmount.setText( " Your betting amounnt is : " + chips);
    }

    @FXML
    void bettingAmount100(MouseEvent event) {
        chips = 100;
        LbBettingAmount.setText( " Your betting amounnt is : " + chips);

    }

    @FXML
    void bettingAmount250(MouseEvent event) {
        chips =250;
        LbBettingAmount.setText( " Your betting amounnt is : " + chips);
    }

    @FXML
    void bettingAmount500(MouseEvent event) {
        chips =500;
        LbBettingAmount.setText( " Your betting amounnt is : " + chips);
    }
    @FXML
    void bettingAmount1000(MouseEvent event) {
        chips =100;
        LbBettingAmount.setText( " Your betting amounnt is : " + chips);
    }

    @FXML
    void bettingAmount2000(MouseEvent event) {
        chips = 2000;
        LbBettingAmount.setText( " Your betting amounnt is : " + chips);
    }

    @FXML
    void bettingAmount5000(MouseEvent event) {
        chips = 5000;
        LbBettingAmount.setText( " Your betting amounnt is : " + chips);
    }

    boolean idk=false;
    @FXML
   /* public void stackit(MouseEvent mouseEvent) throws Exception {
        if(idk==false) {
            iv.setY(-100);
            sp.getChildren().add(iv);
            sp.setBottomAnchor(iv, (double) 0);
            sp.getChildren().add(iv2);
            sp.setBottomAnchor(iv2, (double) 2);
            sp.getChildren().add(iv3);
            sp.setBottomAnchor(iv3, (double) 4);
            sp.getChildren().add(iv4);
            sp.setBottomAnchor(iv4, (double) 6);
            idk=true;
        }else{
        sp.getChildren().clear();
        idk=false;
        }
    }*/
    public void stack(AnchorPane calledby,int chipsonfield,int fieldid){
        switch (chips){
            case 0:
                System.out.println("ERROR: Bet is 0");
                break;
            case 1:
                calledby.getChildren().add(ivs.get(fieldid+"chipone"+chipsonfield));
                calledby.setBottomAnchor(ivs.get(fieldid+"chipone"+chipsonfield),(double)chipsonfield);
                //lw.getItems().add(fieldnames[fieldid]+"   1");
                break;
            case 2:
                calledby.getChildren().add(ivs.get(fieldid+"chiptwo"+chipsonfield));
                calledby.setBottomAnchor(ivs.get(fieldid+"chiptwo"+chipsonfield),(double)chipsonfield);
                break;
            case 5:
                calledby.getChildren().add(ivs.get(fieldid+"chipfive"+chipsonfield));
                calledby.setBottomAnchor(ivs.get(fieldid+"chipfive"+chipsonfield),(double)chipsonfield);
                break;
            case 10:
                calledby.getChildren().add(ivs.get(fieldid+"chipten"+chipsonfield));
                calledby.setBottomAnchor(ivs.get(fieldid+"chipten"+chipsonfield),(double)chipsonfield);
                break;
            case 20:
                calledby.getChildren().add(ivs.get(fieldid+"chiptwenty"+chipsonfield));
                calledby.setBottomAnchor(ivs.get(fieldid+"chiptwenty"+chipsonfield),(double)chipsonfield);
                break;
            case 25:
                calledby.getChildren().add(ivs.get(fieldid+"chiptwentyfive"+chipsonfield));
                calledby.setBottomAnchor(ivs.get(fieldid+"chiptwentyfive"+chipsonfield),(double)chipsonfield);
                break;
            case 50:
                calledby.getChildren().add(ivs.get(fieldid+"chipfifty"+chipsonfield));
                calledby.setBottomAnchor(ivs.get(fieldid+"chipfifty"+chipsonfield),(double)chipsonfield);
                break;
            case 100:
                calledby.getChildren().add(ivs.get(fieldid+"chiphoundred"+chipsonfield));
                calledby.setBottomAnchor(ivs.get(fieldid+"chiphoundred"+chipsonfield),(double)chipsonfield);
                break;
            case 250:
                calledby.getChildren().add(ivs.get(fieldid+"chiptwohounderdfifty"+chipsonfield));
                calledby.setBottomAnchor(ivs.get(fieldid+"chiptwohounderdfifty"+chipsonfield),(double)chipsonfield);
                break;
            case 500:
                calledby.getChildren().add(ivs.get(fieldid+"chipfivehoundred"+chipsonfield));
                calledby.setBottomAnchor(ivs.get(fieldid+"chipfivehoundred"+chipsonfield),(double)chipsonfield);
                break;
            case 1000:
                calledby.getChildren().add(ivs.get(fieldid+"chipthausend"+chipsonfield));
                calledby.setBottomAnchor(ivs.get(fieldid+"chipthausend"+chipsonfield),(double)chipsonfield);
                break;
            case 2000:
                calledby.getChildren().add(ivs.get(fieldid+"chiptwothausend"+chipsonfield));
                calledby.setBottomAnchor(ivs.get(fieldid+"chiptwothausend"+chipsonfield),(double)chipsonfield);
                break;
            case 5000:
                calledby.getChildren().add(ivs.get(fieldid+"chipfivethausend"+chipsonfield));
                calledby.setBottomAnchor(ivs.get(fieldid+"chipfivethausend"+chipsonfield),(double)chipsonfield);
                break;
        }
    }

    public void backtomenu(MouseEvent mouseEvent) throws IOException {
        Pane root = FXMLLoader.load(getClass().getResource("/Resources/menu.fxml"));
        Stage stage = (Stage) lw.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Menu");
    }

    public void refreshguthaben(){
        guthaben.setText(String.valueOf(sql.getGuthaben())+"$");
    }
}//eoc