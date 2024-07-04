package ru.anton.homework02.view;

import ru.anton.homework02.model.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ClientUI extends JFrame implements ViewComponents {
    private static final int WINDOW_WIDTH = 500;
    private static final int WINDOW_HEIGHT = 500;

    private JTextArea chatWindow;
    private JTextField addressIP, port, login, tfMessage;
    private JPasswordField password;
    private JPanel panelUp;
    private JPanel panelDown;
    private JButton btnLogin;
    private JButton btnSend;

    private Client client;
    private ServerUI serverView;


    public ClientUI(ServerUI serverView) {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(100+100*Client.numberClient, 150 + 50*Client.numberClient);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Клиентское приложение... ");
        setResizable(false);

        this.serverView = serverView;
        client = new Client(this, serverView.getServer());

        createPanel();

        setVisible(true);
    }

    private void createPanel() {
        add(createPanelUp(), BorderLayout.NORTH);
        add(createChat());
        add(createPanelDown(), BorderLayout.SOUTH);
    }

    private Component createPanelUp() {
        panelUp = new JPanel(new GridLayout(2, 3));
        addressIP = new JTextField("10.0.0.1");
        port = new JTextField("3333");
        login = new JTextField();
        login.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                login.getText();
            }
        });
        password = new JPasswordField("0000");
        btnLogin = new JButton("Подключиться");
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(login.getText().isEmpty()){
                    postChatWindow("Введите ваш логин... ");
                    return;
                }
                client.setName(login.getText());
                client.setConnection();
                if(client.getStatusConnected()) {
                    panelUp.setVisible(false);
                } else {
                    panelUp.setVisible(true);
                }
            }
        });

        panelUp.add(addressIP);
        panelUp.add(port);
        panelUp.add(new JPanel());
        panelUp.add(login);
        panelUp.add(password);
        panelUp.add(btnLogin);

        return panelUp;
    }

    private Component createChat() {
        chatWindow = new JTextArea();
        chatWindow.setEditable(false);
        return new JScrollPane(chatWindow); // TODO: 09.11.2023 Задать вопрос про крокрутку
    }

    private Component createPanelDown() {
        panelDown = new JPanel(new GridLayout(1, 2));
        tfMessage = new JTextField();
        tfMessage.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                if(e.getKeyChar() == '\n') {
                    sendMessage(tfMessage.getText());
                    tfMessage.setText("");
                }
            }
        });
        btnSend = new JButton("Отпрвавить");
        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage(tfMessage.getText());
                tfMessage.setText("");
            }
        });
        panelDown.add(tfMessage);
        panelDown.add(btnSend, BorderLayout.EAST);
        return panelDown;
    }

    @Override
    protected void processWindowEvent(WindowEvent e) {
        super.processWindowEvent(e);
        if(e.getID() == WindowEvent.WINDOW_CLOSING) {
            System.out.println();
        }
    }




    @Override
    public void sendMessage(String message) {
        client.sendMessage(message);
    }
    @Override
    public void acceptMessage(String message) {
        if(message.equals("Вы успешно подключились")){
            chatWindow.setEditable(true);
            chatWindow.setText("");
        }
        postChatWindow(message);
    }

    private void postChatWindow(String text) {
        chatWindow.setEditable(true);
        chatWindow.append(text + "\n");
        chatWindow.setEditable(false);
    }
}
