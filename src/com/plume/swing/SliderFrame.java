package com.plume.swing;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.Hashtable;

public class SliderFrame extends JFrame {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            SliderFrame simpleFrame = new SliderFrame();
            simpleFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            simpleFrame.setSize(400, 700);
            simpleFrame.setLocationByPlatform(true);
            simpleFrame.setTitle("测试滑动条");
            simpleFrame.setVisible(true);
        });
    }

    private JPanel sliderPanel;
    private JTextField textField;
    private ChangeListener listener;

    public SliderFrame() {
        sliderPanel = new JPanel(new GridLayout(0, 1));

        // common listener for all sliders
        listener = e -> {
            JSlider source = (JSlider) e.getSource();
            textField.setText("" + source.getValue());
        };

        // add a plain slider
        JSlider slider = new JSlider();
        addSlider(slider, "Plain");

        // add a slider with major and minor ticks
        slider = new JSlider();
        slider.setPaintTicks(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        addSlider(slider, "Ticks");

        // add a slider that snaps to ticks
        slider = new JSlider();
        slider.setPaintTicks(true);
        slider.setSnapToTicks(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        addSlider(slider, "Snap to ticks");

        // add a slider with no track
        slider = new JSlider();
        slider.setPaintTicks(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        slider.setPaintTrack(false);
        addSlider(slider, "No track");

        // add an inverted slider
        slider = new JSlider();
        slider.setPaintTicks(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        slider.setInverted(true);
        addSlider(slider, "Inverted");

        // add a slider with numeric labels
        slider = new JSlider();
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        addSlider(slider, "Labels");

        // add a slider with alphabetic labels
        slider = new JSlider();
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);

        Hashtable<Integer, Component> labelTable = new Hashtable<>();
        labelTable.put(0, new JLabel("A"));
        labelTable.put(20, new JLabel("B"));
        labelTable.put(40, new JLabel("C"));
        labelTable.put(60, new JLabel("D"));
        labelTable.put(80, new JLabel("E"));
        labelTable.put(100, new JLabel("F"));

        slider.setLabelTable(labelTable);
        addSlider(slider, "Custom labels");

        // add a slider with icon labels
        slider = new JSlider();
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setSnapToTicks(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(20);
        labelTable = new Hashtable<Integer, Component>();

        // add card images
        labelTable.put(0, new JLabel(new ImageIcon("icon.png")));
        labelTable.put(20, new JLabel(new ImageIcon("icon.png")));
        labelTable.put(40, new JLabel(new ImageIcon("icon.png")));
        labelTable.put(60, new JLabel(new ImageIcon("icon.png")));
        labelTable.put(80, new JLabel(new ImageIcon("icon.png")));
        labelTable.put(100, new JLabel(new ImageIcon("icon.png")));

        slider.setLabelTable(labelTable);
        addSlider(slider, "Icon labels");

        // add the text field the displays the slider value
        textField = new JTextField();
        add(sliderPanel, BorderLayout.CENTER);
        add(textField, BorderLayout.SOUTH);
        pack();
    }

    public void addSlider(JSlider slider, String description) {
        slider.addChangeListener(listener);

        JLabel descLabel = new JLabel(description);
        descLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        sliderPanel.add(slider);
        sliderPanel.add(descLabel);
    }
}