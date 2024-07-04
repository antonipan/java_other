package ru.anton.homework02.view;

import ru.anton.homework02.model.Server;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServerUI extends JFrame implements ViewComponents{
    // Локация
    private static final int WINDOW_WIDTH = 500;
    private static final int WINDOW_HEIGHT = 500;
    private static final int POS_X = 600;
    private static final int POS_Y = 50;
    private static final String TITLE = "Сервер";

    private JButton btnStart, btnStop;
    private JTextArea textCenter;

    public Server getServer() {
        return server;
    }

    private Server server;

    public ServerUI() {
        server = new Server(this);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocation(POS_X, POS_Y);
        setTitle(TITLE);

        createPanel();

        setVisible(true);
    }

    /**
     * Метод создания панели из вложенных панелей
     */
    private void createPanel() {
        textCenter = new JTextArea();
        add(textCenter, BorderLayout.CENTER);
        add(createButtons(), BorderLayout.SOUTH);
    }

    /**
     * Метод создания кнопок
     * @return - собранную из кнопок панель
     */
    private Component createButtons() {
        btnStart = new JButton("Старт");
        btnStop = new JButton("Стоп");

        JPanel panel = new JPanel(new GridLayout(1, 2));

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (server.isWorking()) {
                    postChatWindow("Сервер уже работает");
                } else {
                    server.setWorking(true);
                    postChatWindow("Сервер запустился... ");
                }
            }
        });

        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (server.isWorking()) {
                    server.breakConnection();
                    server.setWorking(false);
                    postChatWindow("Сервер перестал работать.");
                } else {
                    postChatWindow("Сервер уже не работает");
                }
            }
        });

        panel.add(btnStart);
        panel.add(btnStop);
        return panel;
    }

    @Override
    public void acceptMessage(String message) {
        postChatWindow(message);
    }

    @Override
    public void sendMessage(String message) {
        System.out.println("functional isn't realisated");
    }

    private void postChatWindow(String text) {
        textCenter.setEditable(true);
        textCenter.append(text + "\n");
        textCenter.setEditable(false);
    }

}
