package sample;

import sample.interfaces.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

class Spaceship implements Player {
    private int _dx;
    private int _dy;
    private int _x = 40;
    private int _y = 60;
    private int _w;
    private int _h;
    private Image image;

    public Spaceship() {
        loadImage();
    }

    public void loadImage(){
        ImageIcon imageIcon = new ImageIcon("src/resources/xwing.png");
        var tempImage = imageIcon.getImage();
        image = tempImage.getScaledInstance(70, 70, Image.SCALE_SMOOTH);
    }

    public void move() {
        _x += _dx;
        _y += _dy;
    }

    public int getX() {

        return _x;
    }

    public int getY() {

        return _y;
    }

    public int getWidth() {

        return _w;
    }

    public int getHeight() {

        return _h;
    }

    public Image getImage() {
        return image;
    }

    public void keyPressed(KeyEvent keyEvent) {
        int key = keyEvent.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            _dx = -2;
        }

        if (key == KeyEvent.VK_RIGHT) {
            _dx = 2;
        }

        if (key == KeyEvent.VK_UP) {
            _dy = -2;
        }

        if (key == KeyEvent.VK_DOWN) {
            _dy = 2;
        }
    }

    public void keyReleased(KeyEvent keyEvent) {
        int key = keyEvent.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            _dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            _dx = 0;
        }

        if (key == KeyEvent.VK_UP) {
            _dy = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            _dy = 0;
        }
    }

}
