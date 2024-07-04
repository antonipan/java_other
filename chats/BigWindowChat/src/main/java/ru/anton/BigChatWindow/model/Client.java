package ru.anton.homework02.model;

import ru.anton.homework02.model.Server;
import ru.anton.homework02.view.ClientUI;


public class Client implements Messages {
    public static int numberClient = 0;
    private String name;
    private String message;
    private boolean connected;

    private Server server;
    private ClientUI clientUI;


    public Client (ClientUI clientUI, Server server) {
        this.clientUI = clientUI;
        this.server = server;
        numberClient++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setConnection() {
        server.setConnection(this);
    }

    @Override
    public void sendMessage(String message) {
        if(connected) {
            server.sendMessage(getName() + ": " + message);
        }
    }

    public boolean getStatusConnected () {
        return this.connected;
    }
    public void setStatusConnected (boolean connected) {
        this.connected = connected;
    }

    @Override
    public void acceptMessage(String message) {
        clientUI.acceptMessage(message);
    }


}
