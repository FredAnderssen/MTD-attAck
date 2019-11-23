package sample;

import javax.swing.JPanel;
import java.awt.*;

public class Board extends JPanel {

    //TODO temporarily added
    public Board() {};

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        drawSquare(g);
    }

    public void drawSquare(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;


    }

}
