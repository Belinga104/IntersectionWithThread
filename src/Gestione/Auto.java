package Gestione;

import java.util.Objects;

public class Auto extends Thread {
    private final int strada;
    private final OG OG;

    public Auto(int strada, OG OG) {
        this.strada = strada;
        this.OG = OG;
    }

    public void run() {
        OG.Wait();
        while (!OG.passa(this, strada)) {}
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Auto auto = (Auto) o;
        return strada == auto.strada && Objects.equals(OG, auto.OG);
    }

}
