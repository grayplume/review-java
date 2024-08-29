package com.plume.swing;

import javax.swing.*;
import java.awt.*;

public class ComboBoxFrame extends JFrame {

    public static void main(String[] args) {
        EventQueue.invokeLater(()->{
            ComboBoxFrame simpleFrame = new ComboBoxFrame();
            simpleFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            simpleFrame.setSize(500,300);
            simpleFrame.setLocationByPlatform(true);
            simpleFrame.setTitle("测试选框");
            // simpleFrame.setResizable(false);
            simpleFrame.setVisible(true);
        });
    }

    private JComboBox<String> faceCombo;
    private JLabel label;
    private static final int DEFAULT_SIZE = 24;

    public ComboBoxFrame(){
        // add the sample text label
        label = new JLabel("The quick brown fox jumps over the lazy dog.");
        label.setFont(new Font("Serif",Font.PLAIN,DEFAULT_SIZE));
        add(label,BorderLayout.CENTER);

        // make a combo box and face name
        faceCombo = new JComboBox<>();
        faceCombo.addItem("Serif");
        faceCombo.addItem("SansSerif");
        faceCombo.addItem("Monospaced");
        faceCombo.addItem("Dialog");
        faceCombo.addItem("DialogInput");

        // the combo listener changes the label font to the selected face name
        faceCombo.addActionListener(e -> {
            label.setFont(
                    new Font(faceCombo.getItemAt(faceCombo.getSelectedIndex()),
                            Font.PLAIN,DEFAULT_SIZE)
            );
        });

        // add combo box to a panel at the frame's southern border
        JPanel comboPanel = new JPanel();
        comboPanel.add(faceCombo);
        add(comboPanel,BorderLayout.SOUTH);
        pack();
    }
}
