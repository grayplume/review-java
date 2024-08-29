package com.plume.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CheckBoxFrame extends JFrame {

    public static void main(String[] args) {
        EventQueue.invokeLater(()->{
            CheckBoxFrame simpleFrame = new CheckBoxFrame();
            simpleFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            simpleFrame.setSize(500,300);
            simpleFrame.setLocationByPlatform(true);
            simpleFrame.setTitle("测试复选框");
            // simpleFrame.setResizable(false);
            simpleFrame.setVisible(true);
        });
    }

    private JLabel label;
    private JCheckBox bold;
    private JCheckBox italic;
    private static final int FONTSIZE = 24;

    public CheckBoxFrame(){

        // add the sample text label
        label = new JLabel("The quick brown fox jumps over the lazy dog.");
        label.setFont(new Font("Serif",Font.BOLD,FONTSIZE));
        add(label,BorderLayout.CENTER);

        // this listener sets the font attribute of the label to the checkbox state
        ActionListener listener = event ->{
            int mode = 0;
            if (bold.isSelected()) mode += Font.BOLD;
            if (italic.isSelected()) mode += Font.ITALIC;
            label.setFont(new Font("Serif",mode,FONTSIZE));
        };

        // add the check boxes
        JPanel buttonPanel = new JPanel();

        bold = new JCheckBox("Bold");
        bold.addActionListener(listener);
        bold.setSelected(true);
        buttonPanel.add(bold);

        italic = new JCheckBox("Italic");
        italic.addActionListener(listener);
        buttonPanel.add(italic);

        add(buttonPanel,BorderLayout.SOUTH);
        pack();

    }
}
