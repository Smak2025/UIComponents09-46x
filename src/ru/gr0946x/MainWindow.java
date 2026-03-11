package ru.gr0946x;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    private final int MIN_SZ = GroupLayout.PREFERRED_SIZE;
    private final int MAX_SZ = GroupLayout.DEFAULT_SIZE;

    private JPanel mainPanel;
    private JPanel controlPanel;

    private JLabel lblXMin;
    private JLabel lblXMax;
    private JSpinner xMin;
    private JSpinner xMax;

    private JCheckBox cb1;
    private JCheckBox cb2;

    public MainWindow(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(600, 400));
        var gl = new GroupLayout(getContentPane());
        setLayout(gl);
        mainPanel = new JPanel();
        mainPanel.setBackground(Color.WHITE);
        controlPanel = new JPanel();
        gl.setVerticalGroup(gl.createSequentialGroup()
                .addGap(8)
                .addComponent(mainPanel, MAX_SZ, MAX_SZ, MAX_SZ)
                .addGap(8)
                .addComponent(controlPanel, MIN_SZ, MIN_SZ, MIN_SZ)
                .addGap(8)
        );
        gl.setHorizontalGroup(gl.createSequentialGroup()
                .addGap(8)
                .addGroup(gl.createParallelGroup()
                        .addComponent(mainPanel, MAX_SZ, MAX_SZ, MAX_SZ)
                        .addComponent(controlPanel, MAX_SZ, MAX_SZ, MAX_SZ)
                )
                .addGap(8)
        );

        var cpLayout = new GroupLayout(controlPanel);
        controlPanel.setLayout(cpLayout);

        lblXMin = new JLabel("xMin");
        lblXMax = new JLabel("xMax");

        xMin = new JSpinner();
        xMax = new JSpinner();

        cb1 = new JCheckBox("Первая опция");
        cb2 = new JCheckBox("Вторая опция");

        cpLayout.setVerticalGroup(cpLayout.createSequentialGroup()
                .addGap(8)
                .addGroup(
                        cpLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                .addComponent(xMin, MIN_SZ, MIN_SZ, MIN_SZ)
                                .addComponent(xMax, MIN_SZ, MIN_SZ, MIN_SZ)
                                .addComponent(lblXMin, MIN_SZ, MIN_SZ, MIN_SZ)
                                .addComponent(lblXMax, MIN_SZ, MIN_SZ, MIN_SZ)
                                .addComponent(cb1, MIN_SZ, MIN_SZ, MIN_SZ)
                )
                .addGap(8)
                .addGroup(
                        cpLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                .addComponent(cb2, MIN_SZ, MIN_SZ, MIN_SZ)
                )
                .addGap(8)
        );

        cpLayout.setHorizontalGroup(cpLayout.createSequentialGroup()
                .addGap(8)
                .addComponent(lblXMin, MIN_SZ, MIN_SZ, MIN_SZ)
                .addGap(8)
                .addComponent(xMin, 100, 100, MIN_SZ)
                .addGap(24)
                .addComponent(lblXMax, MIN_SZ, MIN_SZ, MIN_SZ)
                .addGap(8)
                .addComponent(xMax, 100, 100, MIN_SZ)
                .addGap(30, 30, Integer.MAX_VALUE)
                .addGroup(
                        cpLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(cb1, MIN_SZ, MIN_SZ, MIN_SZ)
                                .addComponent(cb2, MIN_SZ, MIN_SZ, MIN_SZ)
                )
        );
    }
}
