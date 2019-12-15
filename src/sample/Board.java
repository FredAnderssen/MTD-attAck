package sample;

import javax.swing.*;
import java.awt.*;


public class Board extends JPanel implements Runnable{
    private final int BOARD_WIDTH = 400;
    private final int BOARD_HEIGHT = 400;
    private final int INIT_X = 200;
    private final int INIT_Y = 0;
    private final int DELAY = 25;
    private Thread _animator;

    private Image body;
    private int _x, _y;

    public Board() {
        initBoard();
    };

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        paintBody(graphics);

    };

    private void paintBody(Graphics graphics){
        graphics.drawImage(body, _x, _y, this);
        Toolkit.getDefaultToolkit().sync();
    }

    private void loadImage(){
        ImageIcon imageIcon = new ImageIcon("src/resources/starland.jpeg");
        body = imageIcon.getImage();
    }

    private void initBoard(){
        setBackground(Color.BLACK);
        setSize(BOARD_WIDTH, BOARD_HEIGHT);

        loadImage();
        _x = INIT_X;
        _y = INIT_Y;
    };

    @Override
    public void addNotify() {
        super.addNotify();
        _animator = new Thread(this);
        _animator.start();
    }

    private void cycle(){
        //quad1
        if(_x >= 200 && _y >= 0 && _y <= 200 ) {
            _x += 1;
            _y += 1;
        }
        //quad2
        if(_y >= 200 && _x >= 200 && _y <= 400){
            _x -= 1;
            _y += 1;
        }
        //quad3
        if(_x <= 200 && _y <= 400 && _y >= 200){
            _x -= 1;
            _y -= 1;
        }
        //quad4
        if(_y <= 200 && _x <= 200) {
            _x += 1;
            _y -= 1;
        }
    }

    @Override
    public void run() {
        long beforeTime, timeDifference, sleep;

        beforeTime = System.currentTimeMillis();
        while(true) {

            cycle();
            repaint();

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
