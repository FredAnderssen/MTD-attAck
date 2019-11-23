package sample;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Board extends JPanel {
    private Image starland;

    public Board() {
        initBoard();
    };

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        drawSquare(graphics);
        graphics.drawImage(starland, 0, 0, null);

    }

    public void drawSquare(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D) graphics;

        RenderingHints renderinghints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        renderinghints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        graphics2D.setRenderingHints(renderinghints);

        Dimension size = getSize();
        double width = size.getWidth();
        double height = size.getHeight();

        Rectangle2D rectangle2D = new Rectangle2D.Double(0,0, width, height);
        initGraphics2D(graphics2D);
        graphics2D.fill(rectangle2D);
        graphics2D.draw(rectangle2D);
    }

    private void initGraphics2D(Graphics2D graphics2D) {
        graphics2D.setStroke(new BasicStroke(1));
        graphics2D.setColor(new Color(6, 183, 155));
    }

    private void initBoard() {
        loadStarlandImage();

    }

    private void loadStarlandImage() {
        ImageIcon imageIcon = new ImageIcon("src/resources/starland.jpeg");
        starland = imageIcon.getImage();
    }




}
