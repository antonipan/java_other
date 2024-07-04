package ru.anton.lesson01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame {
    private static final int WINDOW_HEIGHT = 500;
    private static final int WINDOW_WIDTH = 600;
    private static final int WINDOW_POSX = 800;
    private static final int WINDOW_POSY = 300;

    Map map;
    SettingsWindow settingsWindow;

    JButton startButton;
    JButton exitButton;

    GameWindow() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Tic-Tac-Game");
        setResizable(false);
        setLocationRelativeTo(null);

        createWindow();

        setVisible(true);
    }


    void startNewGame (int mode, int fsx, int fsy, int vLen) {
        settingsWindow.setVisible(false);
        map.startNemGame(mode, fsx, fsy, vLen);
    }

    public void createWindow() {
        map = new Map();
        settingsWindow = new SettingsWindow(this);

        add(createButtons(), BorderLayout.SOUTH);
        add(map, BorderLayout.CENTER);
    }

    public Component createButtons () {
        startButton = new JButton("Start");
        exitButton = new JButton("Exit");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settingsWindow.setVisible(true);
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JPanel pButtons = new JPanel(new GridLayout(1, 2));
        pButtons.add(startButton);
        pButtons.add(exitButton);

        return pButtons;
    }

    public void pointGame() {
        map.setVisible(true);
    }
}
