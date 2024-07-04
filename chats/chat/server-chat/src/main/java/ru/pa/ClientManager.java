package ru.pa;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class ClientManager implements Runnable{

    private Socket socket;

    private BufferedWriter bufferedWriter;
    private BufferedReader bufferedReader;

    private String name;
    public static ArrayList<ClientManager> clients = new ArrayList<>();

    public ClientManager (Socket socket) {

        try {
            this.socket = socket;

            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            name = bufferedReader.readLine();
            clients.add(this);
            System.out.printf("Клиент %s подключился\n", name);
            messageToClients("server: клиент " + name + " зашёл в чат");
            
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        String messageFromClients;

        while (socket.isConnected()) {
            try {
                messageFromClients = bufferedReader.readLine();
                messageToClients(messageFromClients);
            } catch (IOException e) {
                closingAllChannels(socket, bufferedReader, bufferedWriter);
            }
        }
    }
    
    private void messageToClients (String message) {
        try {
            for (ClientManager client : clients) {
                if(!client.name.equals(name)) {
                    client.bufferedWriter.write(message);
                    client.bufferedWriter.newLine();
                    client.bufferedWriter.flush();
                }
            }
        } catch (IOException e) {
            closingAllChannels(socket, bufferedReader, bufferedWriter);
        }
    }

    private void closingAllChannels (Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter){
        removeClient(this);
        try {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void removeClient(ClientManager client) {
        clients.remove(client);
        System.out.println("Клиент " + client.name + " покинул чат... ");
    }
}
