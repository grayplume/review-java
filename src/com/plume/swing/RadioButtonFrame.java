package com.plume.swing;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class RadioButtonFrame extends JFrame {

    public static void main(String[] args) {
        EventQueue.invokeLater(()->{
            RadioButtonFrame simpleFrame = new RadioButtonFrame();
            simpleFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            simpleFrame.setSize(500,300);
            simpleFrame.setLocationByPlatform(true);
            simpleFrame.setTitle("测试单选框");
            // simpleFrame.setResizable(false);
            simpleFrame.setVisible(true);
        });
    }


    private JPanel buttonPanel;
    private ButtonGroup group;
    private JLabel label;
    private static final int DEFAULT_SIZE = 36;

    public RadioButtonFrame(){
        // add the sample text label
        label = new JLabel("The quick brown fox jumps over the lazy dog.");
        label.setFont(new Font("Serif",Font.PLAIN,DEFAULT_SIZE));
        add(label,BorderLayout.CENTER);

        // add the radio buttons
        buttonPanel = new JPanel();
        group = new ButtonGroup();

        addRadioButton("Small",8);
        addRadioButton("Medium",12);
        addRadioButton("Large",18);
        addRadioButton("Extra",36);

        // 设置边框
        Border etchedBorder = BorderFactory.createEtchedBorder();
        TitledBorder titledBorder = BorderFactory.createTitledBorder(etchedBorder, "test");
        buttonPanel.setBorder(titledBorder);

        add(buttonPanel,BorderLayout.SOUTH);
        pack();
    }

    public void addRadioButton(String name,int size){
        boolean selected = size == DEFAULT_SIZE;
        JRadioButton button = new JRadioButton(name, selected);
        group.add(button);
        buttonPanel.add(button);

        // this listener sets the label font size
        ActionListener listener = e -> label.setFont(new Font("Serif",Font.PLAIN,size));

        button.addActionListener(listener);
    }
}
