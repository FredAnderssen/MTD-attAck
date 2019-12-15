package sample;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class Board extends JPanel implements Runnable {
    private final int BOARD_WIDTH = 400;
    private final int BOARD_HEIGHT = 400;
    private final int INIT_X = 200;
    private final int INIT_Y = 0;
    private final int DELAY = 25;
    private Thread _animator;

    private Spaceship spaceship;
    private Image body;
    private int _x, _y;

    public Board() {
        initBoard();
    };

    private void initBoard(){
        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.BLACK);
        setSize(BOARD_WIDTH, BOARD_HEIGHT);

        spaceship = new Spaceship();

        loadImage();
        _x = INIT_X;
        _y = INIT_Y;
    };

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        paintBody(graphics);
    };

    private void paintBody(Graphics graphics){
        graphics.drawImage(body, _x, _y, this);
        graphics.drawImage(spaceship.getImage(), spaceship.getX(), spaceship.getY(), this);
        Toolkit.getDefaultToolkit().sync();
    }

    private void loadImage(){
        ImageIcon imageIcon = new ImageIcon("src/resources/starland.jpeg");
        body = imageIcon.getImage();
    }

    @Override
    public void addNotify() {
        super.addNotify();
        _animator = new Thread(this);
        _animator.start();
    }

    private void cycle(){
        int xSpeed = 2;
        int ySpeed = 2;
        //quad1
        if(_x >= 200 && _y >= 0 && _y <= 200 ) {
            _x += xSpeed;
            _y += ySpeed;
        }
        //quad2
        if(_y >= 200 && _x >= 200 && _y <= 400){
            _x -= xSpeed;
            _y += ySpeed;
        }
        //quad3
        if(_x <= 200 && _y <= 400 && _y >= 200){
            _x -= xSpeed;
            _y -= ySpeed;
        }
        //quad4
        if(_y <= 200 && _x <= 200) {
            _x += xSpeed;
            _y -= ySpeed;
        }
    }

    private void step() {
        spaceship.move();

        repaint(spaceship.getX()-1, spaceship.getY()-1,
                spaceship.getWidth()+2, spaceship.getHeight()+2);
    }

    private class TAdapter extends KeyAdapter {
        @Override
        public void keyReleased(KeyEvent keyEvent) {
            spaceship.keyReleased(keyEvent);
        }

        @Override
        public void keyPressed(KeyEvent keyEvent) {
            spaceship.keyPressed(keyEvent);
        }
    }

    @Override
    public void run() {
        long beforeTime, timeDifference, sleep;

        beforeTime = System.currentTimeMillis();
        while(true) {

            cycle();
            repaint();
            step();

            timeDifference = System.currentTimeMillis() - beforeTime;
            sleep = DELAY - timeDifference;

            if(sleep < 0){
                sleep = 2;
            }

            try {
                Thread.sleep(sleep);
            } catch (InterruptedException exception){
                String msg = String.format("Thread interrupted: %s", exception.getMessage());

                JOptionPane.showMessageDialog(this, msg, "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
            beforeTime = System.currentTimeMillis();
        }


    }








}
