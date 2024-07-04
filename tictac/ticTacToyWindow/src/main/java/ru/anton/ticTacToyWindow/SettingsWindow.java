package ru.anton.lesson01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsWindow extends JFrame {
    private static final int WINDOW_HEIGHT = 230;
    private static final int WINDOW_WIDTH = 350;


    // Кнопки
    JButton btmStart;
    JRadioButton btnSizeField;

    public SettingsWindow (GameWindow gameWindow) {
        setLocationRelativeTo(gameWindow);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        add(panelSettings(gameWindow), BorderLayout.SOUTH);

        setVisible(false);



    }
    public void print (String str) {
        System.out.println("Some offer");
        int a = 11 + 3;
        for (int i = 0; i < a; i++) {
            System.out.println("Cycle: " + i);
        }
    }

    public Component panelSettings (GameWindow gameWindow) {
        btmStart = new JButton("Start new Game");
        btmStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameWindow.startNewGame(0, 3, 3, 3);
                gameWindow.pointGame();
            }
        });
        btnSizeField = new JRadioButton("Select size the game field");

        JPanel panelSettings = new JPanel(new GridLayout(4, 1));

        panelSettings.add(btmStart);
        return panelSettings;

    }
}
