package sample.interfaces;

import java.awt.*;
import java.awt.event.KeyEvent;

public interface Player {
    public void loadImage();
    public void move();
    public int getX();
    public int getY();
    int getWidth();
    int getHeight();
    public Image getImage();
    public void keyPressed(KeyEvent keyEvent);
    public void keyReleased(KeyEvent keyEvent);


}
