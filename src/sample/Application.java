package sample;

import javax.swing.JFrame;
import java.awt.EventQueue;

public class Application extends JFrame {

    public Application() {
        initUI();
    }

    private void initUI() {
        add(new Board());
        setSize(450, 400);
        setTitle("aTack Tower Defense");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Application aTack = new Application();
            aTack.setVisible(true);
        });
    }



}
