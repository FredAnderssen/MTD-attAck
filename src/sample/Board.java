package sample;

import javax.swing.*;
import java.awt.*;


public class Board extends JPanel implements Runnable{
    private final int BOARD_WIDTH = 350;
    private final int BOARD_HEIGHT = 350;
    private final int INIT_X = -40;
    private final int INIT_Y = -40;
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
        //setPreferredSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));

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
        _x += 1;
        _y += 1;

        if(_y > BOARD_HEIGHT){
            _x = INIT_X;
            _y = INIT_Y;
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
