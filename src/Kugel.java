import java.util.Random;

public class Kugel{
    Random rand = new Random();
    Grafik grafik=new Grafik();
    public int getKugelendpos(){
        int kugelpos = rand.nextInt(37);//spinning the wheel
        grafik.showKugelLandOn(kugelpos);// Grafik is called to display a video of the "Kugel" landing on kugelpos
        return kugelpos;
    }


}
