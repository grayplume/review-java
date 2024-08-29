package com.plume.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class DrawTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(()->{
            DrawFrame drawFrame = new DrawFrame();
            drawFrame.setTitle("画图");
            drawFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            drawFrame.setVisible(true);
        });
    }
}
/**
 * frame
 */
class DrawFrame extends JFrame{
    public DrawFrame(){
        add(new DrawComponent());
        pack();
    }
}
/**
 * component
 */
class DrawComponent extends JComponent{
    private static final int DEFAULT_WIDTH = 400;
    private static final int DEFAULT_HEIGHT = 400;

    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;



        double leftX = 100;
        double topY = 100;
        double width = 200;
        double height = 150;

        Rectangle2D.Double rect = new Rectangle2D.Double(leftX, topY, width, height);
        g2.setPaint(Color.RED);
        g2.fill(rect);
        // g2.draw(rect);

        g2.setPaint(Color.BLACK);

        // draw the enclosed ellipse
        Ellipse2D.Double ellipse = new Ellipse2D.Double();
        ellipse.setFrame(rect);
        g2.draw(ellipse);

        // draw a diagonal line
        g2.draw(new Line2D.Double(leftX,topY,leftX+width,topY+height));

        // draw a circle with the same center
        double centerX = rect.getCenterX();
        double centerY = rect.getCenterY();
        double radius = 150;

        Ellipse2D.Double circle = new Ellipse2D.Double();
        circle.setFrameFromCenter(centerX,centerY,centerX+radius,centerY+radius);
        g2.draw(circle);
    }
    public Dimension getPreferredSize(){
        return new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT);
    }
}
