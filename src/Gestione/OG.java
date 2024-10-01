package Gestione;

import Oggetti.grafMacchina;
import Oggetti.grafSemaforo;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;

import static java.lang.Thread.ofPlatform;
import static java.lang.Thread.sleep;

public class OG {

    public final ArrayList<Auto> ST1 = new ArrayList<>();
    public final ArrayList<Auto> ST2 = new ArrayList<>();
    public final ArrayList<Auto> ST3 = new ArrayList<>();
    public final ArrayList<Auto> ST4 = new ArrayList<>();

    private boolean flagA = false,flagB = false,flagC = false, flagD = false;
    private int xR=293, yR=-103, xN=377, yN=753, xB=-103, yB=327, xV=853,yV=243;
    private  Graphics g;
    private Timer timer;
    private boolean turno = false;
    public OG(Graphics g){

        this.g=g;

        grafSemaforo sxAlto = new grafSemaforo(250, 190, 30, 30,g);
        grafSemaforo sxBasso = new grafSemaforo(250,410, 30,30,g);
        grafSemaforo dxBasso = new grafSemaforo(450,410, 30,30,g);
        grafSemaforo dxAlto = new grafSemaforo(450,190, 30,30,g);

        timer = new Timer(2000, e -> {
            turno = !turno;
            if (turno) {
                sxBasso.rosso();
                dxAlto.rosso();
                sxAlto.verde();
                dxBasso.verde();
            } else {
                sxAlto.rosso();
                dxBasso.rosso();
                sxBasso.verde();
                dxAlto.verde();
            }
            Notify();
        });
    }

    public synchronized boolean primo(Auto a, int n){
        if(n==1)
            if(!ST1.isEmpty() && ST1.getFirst() == a)
                return true;
        if(n==2)
            if(!ST2.isEmpty() && ST2.getFirst() == a)
                return true;
        if(n==3)
            if(!ST3.isEmpty() && ST3.getFirst() == a)
                return true;
        if(n==4)
            if(!ST4.isEmpty() && ST4.getFirst() == a)
                return true;
        return false;
    }

    public synchronized boolean passa(Auto a, int strada) {
        try {

            switch (strada) {
                //MACCHINA VERTICALE ALTA
                case 1 -> {

                    if(primo(a, strada)){
                        grafMacchina tempM = new grafMacchina(xR, yR, Color.RED, 1, g);
                        tempM.creaMacchinaVert();
                        for (int i = 0; i < 230; i++) {
                            try {
                                tempM = tempM.muoviMacchina(tempM);
                                tempM.creaMacchinaVert();
                                wait(2);
                            } catch (InterruptedException ex) {
                                ex.printStackTrace();
                            }
                        }
                        flagA = true;
                        if (turno) {
                            for (int i = 0; i < 520; i++) {
                                try {
                                    tempM = tempM.muoviMacchina(tempM);
                                    tempM.creaMacchinaVert();
                                    wait(2);
                                } catch (InterruptedException ex) {
                                    ex.printStackTrace();
                                }
                            }
                            ST1.remove(a);
                            return true;
                        }
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        ST1.remove(a);
                        for (int i = 0; i < 520; i++) {
                            try {
                                tempM = tempM.muoviMacchina(tempM);
                                tempM.creaMacchinaVert();
                                wait(2);
                            } catch (InterruptedException ex) {
                                ex.printStackTrace();
                            }
                        }
                        return true;

                    } else {

                        if (ST1.get(1).equals(a) && flagA){

                            grafMacchina tempM = new grafMacchina(xR, yR, Color.RED, 1, g);
                            tempM.creaMacchinaVert();
                            for (int i = 0; i < 110; i++) {
                                try {
                                    tempM = tempM.muoviMacchina(tempM);
                                    tempM.creaMacchinaVert();
                                    wait(2);
                                } catch (InterruptedException ex) {
                                    ex.printStackTrace();
                                }
                            }
                            if (turno) {
                                for (int i = 0; i < 750; i++) {
                                    try {
                                        tempM = tempM.muoviMacchina(tempM);
                                        tempM.creaMacchinaVert();
                                        wait(2);
                                    } catch (InterruptedException ex) {
                                        ex.printStackTrace();
                                    }
                                }
                                flagA = false;
                                ST1.remove(a);
                                return true;
                            }
                            try {
                                wait();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                            for (int i = 0; i < 750; i++) {
                                try {
                                    tempM = tempM.muoviMacchina(tempM);
                                    tempM.creaMacchinaVert();
                                    wait(2);
                                } catch (InterruptedException ex) {
                                    ex.printStackTrace();
                                }
                            }
                            flagA = false;
                            ST1.remove(a);
                            return true;
                        } else {
                            if (ST1.get(1).equals(a)) {
                                return false;
                            }
                            try {
                                wait();
                            } catch (InterruptedException exception) {
                                exception.printStackTrace();
                            }
                        }
                    }
                }

                //MACCHINA ORIZZONTALE SINISTRA
                case 2 -> {

                    if(primo(a, strada)){
                        grafMacchina tempM = new grafMacchina(xB, yB, Color.BLUE,3, g );
                        tempM.creaMacchinaOrizz();
                        for (int i = 0; i < 275; i++) {
                            try {
                                tempM = tempM.muoviMacchina(tempM);
                                tempM.creaMacchinaOrizz();
                                wait(2);
                            } catch (InterruptedException ex) {
                                ex.printStackTrace();
                            }
                        }
                        flagB = true;
                        if (!turno) {

                            for (int i = 0; i < 753; i++) {
                                try {
                                    tempM = tempM.muoviMacchina(tempM);
                                    tempM.creaMacchinaOrizz();
                                    wait(2);
                                } catch (InterruptedException ex) {
                                    ex.printStackTrace();
                                }
                            }
                            ST2.remove(a);
                            return true;
                        }

                        try {
                            wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        ST2.remove(a);
                        for (int i = 0; i < 753; i++) {
                            try {
                                tempM = tempM.muoviMacchina(tempM);
                                tempM.creaMacchinaOrizz();
                                wait(2);
                            } catch (InterruptedException ex) {
                                ex.printStackTrace();
                            }
                        }
                        return true;

                    } else {

                        if (ST2.get(1).equals(a) && flagB) {
                            grafMacchina tempM = new grafMacchina(xB, yB, Color.BLUE,3, g );
                            tempM.creaMacchinaOrizz();
                            for (int i = 0; i < 125; i++) {
                                try {
                                    tempM = tempM.muoviMacchina(tempM);
                                    tempM.creaMacchinaOrizz();
                                    wait(2);
                                } catch (InterruptedException ex) {
                                    ex.printStackTrace();
                                }
                            }
                            if (!turno) {
                                for (int i = 0; i < 753; i++) {
                                    try {
                                        tempM = tempM.muoviMacchina(tempM);
                                        tempM.creaMacchinaOrizz();
                                        wait(2);
                                    } catch (InterruptedException ex) {
                                        ex.printStackTrace();
                                    }
                                }
                                flagB = false;
                                ST2.remove(a);
                                return true;
                            }

                            try {
                                wait();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                            for (int i = 0; i < 753; i++) {
                                try {
                                    tempM = tempM.muoviMacchina(tempM);
                                    tempM.creaMacchinaOrizz();
                                    wait(2);
                                } catch (InterruptedException ex) {
                                    ex.printStackTrace();
                                }
                            }
                            flagB = false;
                            ST2.remove(a);
                            return true;
                        } else {
                            if (ST2.get(1).equals(a)) {
                                return false;
                            }
                            try {
                                wait();
                            } catch (InterruptedException exception) {
                                exception.printStackTrace();
                            }
                        }
                    }

                }

                //MACCHINA VERTICALE BASSA
                case 3 -> {

                    if (primo(a, strada)) {
                        grafMacchina tempM = new grafMacchina(xN, yN, Color.BLACK,2, g );
                        tempM.creaMacchinaVert();
                        for (int i = 0; i < 350; i++) {
                            try {
                                tempM = tempM.muoviMacchina(tempM);
                                tempM.creaMacchinaVert();
                                wait(2);
                            } catch (InterruptedException ex) {
                                ex.printStackTrace();
                            }
                        }
                        flagC = true;
                        if (turno) {
                            for (int i = 0; i < 503; i++) {
                                try {
                                    tempM = tempM.muoviMacchina(tempM);
                                    tempM.creaMacchinaVert();
                                    wait(2);
                                } catch (InterruptedException ex) {
                                    ex.printStackTrace();
                                }
                            }
                            ST3.remove(a);
                            return true;
                        }
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        ST3.remove(a);
                        for (int i = 0; i < 503; i++) {
                            try {
                                tempM = tempM.muoviMacchina(tempM);
                                tempM.creaMacchinaVert();
                                wait(2);
                            } catch (InterruptedException ex) {
                                ex.printStackTrace();
                            }
                        }
                        return true;
                    } else {
                        if (ST3.get(1).equals(a) && flagC) {
                            grafMacchina tempM = new grafMacchina(xN, yN, Color.BLACK, 2, g);
                            tempM.creaMacchinaVert();
                            for (int i = 0; i < 200; i++) {
                                try {
                                    tempM = tempM.muoviMacchina(tempM);
                                    tempM.creaMacchinaVert();
                                    wait(2);
                                } catch (InterruptedException ex) {
                                    ex.printStackTrace();
                                }
                            }

                            if (turno) {
                                for (int i = 0; i < 703; i++) {
                                    try {
                                        tempM = tempM.muoviMacchina(tempM);
                                        tempM.creaMacchinaVert();
                                        wait(2);
                                    } catch (InterruptedException ex) {
                                        ex.printStackTrace();
                                    }
                                }
                                flagC = false;
                                ST3.remove(a);
                                return true;
                            }

                            try {
                                wait();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                            for (int i = 0; i < 703; i++) {
                                try {
                                    tempM = tempM.muoviMacchina(tempM);
                                    tempM.creaMacchinaVert();
                                    wait(2);
                                } catch (InterruptedException ex) {
                                    ex.printStackTrace();
                                }
                            }
                            flagC = false;
                            ST3.remove(a);
                            return true;
                        } else {
                            if (ST3.get(1).equals(a)) {
                                return false;
                            }
                            try {
                                wait();
                            } catch (InterruptedException exception) {
                                exception.printStackTrace();
                            }
                        }
                    }

                }

                //MACCHINA ORIZZONTALE DESTRA
                case 4 -> {

                    if(primo(a, strada)){
                        grafMacchina tempM = new grafMacchina(xV, yV, Color.GREEN,4, g );
                        tempM.creaMacchinaOrizz();
                        for (int i = 0; i < 400; i++) {
                            try {
                                tempM = tempM.muoviMacchina(tempM);
                                tempM.creaMacchinaOrizz();
                                wait(2);
                            } catch (InterruptedException ex) {
                                ex.printStackTrace();
                            }
                        }
                        flagD = true;
                        if (!turno) {

                            for (int i = 0; i < (853); i++) {
                                try {
                                    tempM = tempM.muoviMacchina(tempM);
                                    tempM.creaMacchinaOrizz();
                                    wait(2);
                                } catch (InterruptedException ex) {
                                    ex.printStackTrace();
                                }
                            }
                            ST4.remove(a);
                            return true;
                        }
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        ST4.remove(a);
                        for (int i = 0; i < (853); i++) {
                            try {
                                tempM = tempM.muoviMacchina(tempM);
                                tempM.creaMacchinaOrizz();
                                wait(2);
                            } catch (InterruptedException ex) {
                                ex.printStackTrace();
                            }
                        }
                        return true;
                    } else {
                        if (ST4.get(1).equals(a) && flagD) {
                            grafMacchina tempM = new grafMacchina(xV, yV, Color.GREEN,4, g );
                            tempM.creaMacchinaOrizz();
                            for (int i = 0; i < 170; i++) {
                                try {
                                    tempM = tempM.muoviMacchina(tempM);
                                    tempM.creaMacchinaOrizz();
                                    wait(2);
                                } catch (InterruptedException ex) {
                                    ex.printStackTrace();
                                }
                            }
                            if (!turno) {

                                for (int i = 0; i < (853); i++) {
                                    try {
                                        tempM = tempM.muoviMacchina(tempM);
                                        tempM.creaMacchinaOrizz();
                                        wait(2);
                                    } catch (InterruptedException ex) {
                                        ex.printStackTrace();
                                    }
                                }
                                flagD = false;
                                ST4.remove(a);
                                return true;
                            }
                            try {
                                wait();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                            for (int i = 0; i < (853); i++) {
                                try {
                                    tempM = tempM.muoviMacchina(tempM);
                                    tempM.creaMacchinaOrizz();
                                    wait(2);
                                } catch (InterruptedException ex) {
                                    ex.printStackTrace();
                                }
                            }
                            flagD = false;
                            ST4.remove(a);
                            return true;
                        } else {
                            if (ST4.get(1).equals(a)) {
                                return false;
                            }
                            try {
                                wait();
                            } catch (InterruptedException exception) {
                                exception.printStackTrace();
                            }
                        }
                    }
                }
            }
            return false;

        } catch (NullPointerException exception) {
            return false;
        }
    }
    public void startTimer (){
        timer.start();
    }

    public synchronized void Wait() {
        try {
            wait(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized void Notify() {
        notifyAll();
    }
}