package Oggetti;

import java.awt.*;

public class grafSemaforo {

    private Graphics g;

    private int x,y,width,height;

    public grafSemaforo(int x, int y, int width, int height, Graphics g){
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
        this.g=g;
    }
        public void rosso() {
            g.setColor(Color.RED);
            g.fillOval(x,y,width,height);
        }
        public void verde () {
            g.setColor(Color.GREEN);
            g.fillOval(x,y,width,height);
        }

}
