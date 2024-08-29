package com.plume.swing;

import javax.swing.*;
import java.awt.*;

public class SimpleFrameTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(()->{
            SimpleFrame simpleFrame = new SimpleFrame();
            simpleFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            simpleFrame.setResizable(true);
            simpleFrame.setVisible(true);
        });
    }
}
class SimpleFrame extends JFrame{
    private static final int DEFAULT_WIDTH = 1500;
    private static final int DEFAULT_HEIGHT = 1000;

    public SimpleFrame(){

        add(new MouseComponent());
        pack();

        // add(new NotHelloWorldComponent());
        // pack();

        // Toolkit toolkit = Toolkit.getDefaultToolkit();
        // Dimension screenSize = toolkit.getScreenSize();
        // int screenWidth = screenSize.width;
        // int screenHeight = screenSize.height;
        //
        // setSize(screenWidth/2,screenHeight/2);
        // setTitle("测试");
        // setLocationByPlatform(true);
        //
        // Image image = new ImageIcon("icon.png").getImage();
        // setIconImage(image);


        // setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
    }

}
class MyComponent extends JComponent{
    public void paintComponent(Graphics g){
        // -------
    }
}

class NotHelloWorldComponent extends JComponent{
    public static final int MESSAGE_X = 75;
    public static final int MESSAGE_Y = 100;
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    public void paintComponent(Graphics g){
        // -------
        Font font = new Font("SansSerif", Font.BOLD, 14);
        g.setFont(font);
        g.setColor(Color.GREEN);
        g.drawString("Not a Hello,World program",MESSAGE_X,MESSAGE_Y);
    }

    public Dimension getPreferredSize(){
        return new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT);
    }
}