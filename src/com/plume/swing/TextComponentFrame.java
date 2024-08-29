package com.plume.swing;

import javax.swing.*;
import java.awt.*;

public class TextComponentFrame extends JFrame {


    public static void main(String[] args) {
        EventQueue.invokeLater(()->{
            TextComponentFrame simpleFrame = new TextComponentFrame();
            simpleFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            // simpleFrame.setResizable(false);
            simpleFrame.setVisible(true);
        });
    }

    public static final int TEXTAREA_ROWS = 8;
    public static final int TEXTAREA_COLUMNS = 20;

    private static final int DEFAULT_WIDTH = 1000;
    private static final int DEFAULT_HEIGHT = 600;


    public TextComponentFrame(){

        JTextField textField = new JTextField();
        JPasswordField passwordField = new JPasswordField();

        JPanel northPanel = new JPanel();
        northPanel.setLayout(new GridLayout(2,2));
        northPanel.add(new JLabel("User name:",SwingConstants.RIGHT));
        northPanel.add(textField);
        northPanel.add(new JLabel("Password:",SwingConstants.RIGHT));
        northPanel.add(passwordField);

        add(northPanel,BorderLayout.NORTH);

        JTextArea textArea = new JTextArea(TEXTAREA_ROWS, TEXTAREA_COLUMNS);
        JScrollPane scrollPane = new JScrollPane(textArea);

        add(scrollPane,BorderLayout.CENTER);

        // add button to append text into the text area
        JPanel southPanel = new JPanel();

        JButton insertButton = new JButton("Insert");
        southPanel.add(insertButton);
        insertButton.addActionListener(e -> {
            textArea.append("User name:" + textField.getText() + " Password:" + new String(passwordField.getPassword()) + "\n");
        });

        add(southPanel,BorderLayout.SOUTH);
        pack();

        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
        setLocationByPlatform(true);
        setTitle("测试用户输入");

    }

}
