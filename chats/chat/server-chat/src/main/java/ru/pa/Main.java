package ru.pa;

import java.io.IOException;
import java.net.ServerSocket;

public class Main {
    public static void main(String[] args) {
        System.out.println("Server work already!");
        try {
            ServerSocket serverSocket = new ServerSocket(4444);
            Server server = new Server(serverSocket);
            server.runServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}