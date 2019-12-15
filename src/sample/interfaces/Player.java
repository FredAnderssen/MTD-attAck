package sample.interfaces;

import java.awt.*;
import java.awt.event.KeyEvent;

public interface Player {
    void loadImage();
    void move();
    int getX();
    int getY();
    int getWidth();
    int getHeight();
    Image getImage();
    void keyPressed(KeyEvent keyEvent);
    void keyReleased(KeyEvent keyEvent);
}
