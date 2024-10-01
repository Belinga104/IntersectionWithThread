package Oggetti;

import java.awt.*;

public class grafMacchina {

    private Graphics g;

    //WIDTH HEIGHT RIFERITE ALLE MACCHINE IN VERTICALE, PER LE ORIZZONTALI INVERTO
    //XOY
    //1: VERTICALE VERSO BASSO, 2: VERTICALE VERSO ALTO, 3: ORIZZONTALE VERSO DESTRA, 4: ORIZZONTLE VERSO SINISTRA

    private int x,y,width=60,height=100, XoY=0;

    private Color c;

    public grafMacchina(int x, int y, Color c, int XoY, Graphics g) {
        this.XoY = XoY;
        this.c = c;
        this.x = x;
        this.y= y;
        this.g = g;
    }

    //PER CREARE UNA MACCHINA SULL'ASSE X
    public void creaMacchinaOrizz(){
        //CARROZZERIA
        g.setColor(c);
        g.fillRect(x,y,height,width);

        if(XoY==3){
            //LUCI SX
            g.setColor(Color.YELLOW);
            g.fillRect(x+height,y+10, 3,10);

            //LUCI DX
            g.setColor(Color.YELLOW);
            g.fillRect(x+height, y+width-20,3,10);
        }
        else if(XoY ==4){
            //LUCI SX
            g.setColor(Color.YELLOW);
            g.fillRect(x-3,y+10, 3,10);

            //LUCI DX
            g.setColor(Color.YELLOW);
            g.fillRect(x-3, y+width-20,3,10);
        }
        else{

        }

    }


    //PER CREARE UNA MACCHINA SULL'ASSE Y
    public void creaMacchinaVert(){

        //CARROZZERIA
        g.setColor(c);
        g.fillRect(x,y,width,height);

        if(XoY==1){
            //LUCI SX
            g.setColor(Color.YELLOW);
            g.fillRect(x+10, y+height+1, 10,3);

            //LUCI DX
            g.setColor(Color.YELLOW);
            g.fillRect(x+width-20, y+height+1, 10,3);
        }
        else if(XoY ==2){
            g.setColor(Color.YELLOW);
            g.fillRect(x+10, y-3, 10,3);

            //LUCI DX
            g.setColor(Color.YELLOW);
            g.fillRect(x+width-20, y-3, 10,3);
        }

    }

    public grafMacchina muoviMacchina(grafMacchina mM){
        switch (mM.getXoY()){

            case 1:

                new grafMacchina(mM.getX(), mM.getY(), Color.GRAY, 5, mM.getG()).creaMacchinaVert();
                return new grafMacchina(mM.getX(),mM.getY()+1, mM.getC(), mM.getXoY(), mM.getG());

            case 2:

                new grafMacchina(mM.getX(), mM.getY(), Color.GRAY, 5, mM.getG()).creaMacchinaVert();
                return new grafMacchina(mM.getX(),mM.getY()-1, mM.getC(), mM.getXoY(), mM.getG());

            case 3:

                new grafMacchina(mM.getX(), mM.getY(), Color.GRAY, 5, mM.getG()).creaMacchinaOrizz();
                return new grafMacchina(mM.getX()+1,mM.getY(), mM.getC(), mM.getXoY(), mM.getG());

            case 4:

                new grafMacchina(mM.getX(), mM.getY(), Color.GRAY, 5, mM.getG()).creaMacchinaOrizz();
                return new grafMacchina(mM.getX()-1,mM.getY(), mM.getC(), mM.getXoY(), mM.getG());

        }
        return null;
    }




    public Graphics getG() {
        return g;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getXoY() {
        return XoY;
    }

    public Color getC() {
        return c;
    }

}
