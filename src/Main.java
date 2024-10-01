import Gestione.Auto;
import Gestione.OG;

import static java.lang.Thread.sleep;

public class Main {

    public static void main(String[] args) {
        mainFrame mF = new mainFrame();
        OG OG = new OG(mF.grafica.getGraphics());
        OG.startTimer();

        while (true){
            try {
               sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            double s = Math.random();
            if (s <= 0.25) {
                Auto auto = new Auto(1, OG);
                OG.ST1.add(auto);
                auto.start();
            }
            if (s > 0.25 && s <= 0.5) {
                Auto auto = new Auto(2, OG);
                OG.ST2.add(auto);
                auto.start();
            }
            if (s > 0.5 && s <= 0.75) {
                Auto auto = new Auto(3, OG);
                OG.ST3.add(auto);
                auto.start();
            }
            if (s > 0.75) {
                Auto auto = new Auto(4, OG);
                OG.ST4.add(auto);
                auto.start();
            }
        }
    }
}