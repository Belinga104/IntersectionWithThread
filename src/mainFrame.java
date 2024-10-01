import Oggetti.Grafica;

import javax.swing.*;
import java.awt.*;

public class mainFrame {
    public static Grafica grafica = new Grafica();
    public mainFrame()  {
        JFrame frame = new JFrame("Incrocio");

        Container c = frame.getContentPane();
        c.add(grafica);

        frame.setSize(750, 650);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}
