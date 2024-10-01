package Oggetti;

import javax.swing.*;
import java.awt.*;

public class Grafica extends JPanel {
    private Graphics g;

    public void paint(Graphics g){

        g.setColor(Color.GRAY);
        //STRADA ORIZZONTALE
        g.fillRect(0,235,750,160);
        //STRADA VERTICALE
        g.fillRect(285,0, 160,750);

        // ORIZZ SINISTRA

        g.setColor(Color.WHITE);
        g.fillRect(0,312,285,8);

        //g.fillRect(277, 312, 8, 83);

        //ORIZZ DESTRA
        g.setColor(Color.WHITE);
        g.fillRect(445,312,465,8);

        //g.fillRect(445, 234, 8, 83);

        //VERT ALTO
        g.setColor(Color.WHITE);
        g.fillRect(361,0,8,235);

        //g.fillRect(285, 227, 80, 8);


        //VERT BASSO
        g.setColor(Color.WHITE);
        g.fillRect(361,395,8,245);

        //g.fillRect(361, 395, 90, 8);




    }
}


