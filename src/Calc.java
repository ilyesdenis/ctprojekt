import java.util.Random;
/*  bet IDs:
* 0-36-the numbersx, 37-firsttwelvex, 38-onetoeighteenx, 39-evenx, 40-secoundtwelvex,41-thirdtwelvex
* 42-redx, 43-blackx, 44-oddx, 45-nineteentothirtysixx, 47-row2x, 48-row3x, 49-row1x
*
*
* */

public class Calc {

    private int[] bets;
    Random rand = new Random();
    private int kugelpos;

    public int spinit() {
        kugelpos = rand.nextInt(37);
        return kugelpos;
    }

    public int calculateWin(int[] bets) {
        this.bets = bets;
        int win = 0;
        for (int i = 0; i < 50; i++) {
          //  int kugelpos = spinit();
            if (bets[i]>0) { // bet on i is set
                if (i < 37) {
                    //*36
                    if (kugelpos == i) {
                        win = win + 36 * bets[i];//direct win, factor x36
                        System.out.println("direct win on"+i);
                    }
                }
                //*2
                if (i == 39) { //39 even
                    //System.out.println("DEBUG 39 EVEN");
                    if (kugelpos % 2 == 0) {
                       // System.out.println("DEBUG 39 ISEVEN");
                        win = win + 2 * bets[39];// even win, factor x2
                    }
                }
                if (i == 44) { //44 odd
                    if (kugelpos % 2 == 1) {
                        win = win + 2 * bets[44];// odd win, factor x2
                    }
                }
                if (i == 38) { //38 onetoeighteen
                    if ((kugelpos > 0) && (kugelpos < 19)) {
                        win = win + 2 * bets[38];// 1-18 win, factor x2
                    }
                }
                if (i == 45) { //45 nineteentothirtysix
                    if ((kugelpos > 18) && (kugelpos < 37)) {
                        win = win + 2 * bets[45];// 1-18 win, factor x2
                    }
                }
                if (i == 42) { //42 red ,checks for 43 black too
                    if ((kugelpos == 1) || (kugelpos == 3) || (kugelpos == 5) || (kugelpos == 7) || (kugelpos == 9) || (kugelpos == 12) || (kugelpos == 14) || (kugelpos == 16) || (kugelpos == 18) || (kugelpos == 19) || (kugelpos == 21) || (kugelpos == 23) || (kugelpos == 25) || (kugelpos == 27) || (kugelpos == 30) || (kugelpos == 32) || (kugelpos == 34) || (kugelpos == 36)) {
                        win = win + 2 * bets[42];// red win, factor x2
                    }/*else if ((bets[43] > 0) && (kugelpos>0)) { //////////DOES  NOT WORK!!!!!!!!!!!!!
                        win = win + 2 * bets[43];// black win, factor x2
                    }*/
                }
                if(i==43){
                    if ((kugelpos == 2) || (kugelpos == 4) || (kugelpos == 6) || (kugelpos == 8) || (kugelpos == 10) || (kugelpos == 11) || (kugelpos == 13) || (kugelpos == 15) || (kugelpos == 17) || (kugelpos == 20) || (kugelpos == 22) || (kugelpos == 24) || (kugelpos == 26) || (kugelpos == 28) || (kugelpos == 29) || (kugelpos == 31) || (kugelpos == 33)|| (kugelpos == 35)) {
                        win = win + 2 * bets[43];// black win, factor x2
                    }
                }


                //x3
                if (i == 37) { //37 first12
                    if ((kugelpos > 0) && (kugelpos < 13)) {
                        win = win + 3 * bets[37]; //first 12 win, factor x3
                    }
                }
                if (i == 40) { //40 secoundtwelve
                    if ((kugelpos > 12) && (kugelpos < 25)) {
                        win = win + 3 * bets[40]; //secound 12 win, factor x3
                    }
                }
                if (i == 41) { //41 thirdtwelve
                    if ((kugelpos > 24) && (kugelpos < 37)) {
                        win = win + 3 * bets[41]; //third 12 win, factor x3
                    }
                }
                if (i == 49) { //49 row1
                    if (kugelpos % 3 == 1) {
                        win = win + 3 * bets[49]; //row1 win, factor x3
                    }
                }
                if (i == 47) { //47 row2
                    if (kugelpos % 3 == 2) {
                        win = win + 3 * bets[47]; //row2 win, factor x3
                    }
                }
                if (i == 48) { //49 row1
                    if (kugelpos % 3 == 0) {
                        win = win + 3 * bets[48]; //row3 win, factor x3
                    }
                }
            }
        }
        System.out.println("win:"+win);
        return win;

    }
}