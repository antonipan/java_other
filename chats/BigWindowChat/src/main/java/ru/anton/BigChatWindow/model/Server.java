package ru.anton.homework02.model;

import ru.anton.homework02.view.ServerUI;

import java.util.ArrayList;
import java.util.List;

public class Server implements Messages {
    private List<Client> clients;
    private boolean working;
    private Repository repository;

    private ServerUI serverUI;



    public Server (ServerUI serverUI) {
        this.serverUI = serverUI;
        clients = new ArrayList<>();
        repository = new FileRepo();

    }

    public boolean isWorking() {
        return working;
    }

    public void setWorking(boolean working) {
        this.working = working;
    }


    public void setConnection(Client client) {
        if (!isWorking()){
            client.acceptMessage("Сервер не работает");
            return;
        }
        client.setStatusConnected(true);
        if(!client.getStatusConnected()) {
            client.acceptMessage("Соединение не установилось. ");
            return;
        }
        clients.add(client);
        System.out.println(clients.size());
        client.acceptMessage("Вы успешно подключились");
        client.acceptMessage(repository.loading());
        serverUI.acceptMessage(String.format("Клиент %s успешно подключился", client.getName()));
    }

    @Override
    public void acceptMessage(String message) {
        System.out.println("Функционал в разработке");
    }

    @Override
    public void sendMessage(String message) {
        sendAllMessage(message);
    }


    public void breakConnection() {
        clients.forEach(client -> client.setStatusConnected(false));
        clients.removeIf(client -> (!client.getStatusConnected()));
        System.out.println(clients.size());
    }

    private void sendAllMessage (String message) {
        for (Client client: clients) {
            client.acceptMessage(message);
        }
        repository.saving(message);
        String [] name = message.split(":");
        serverUI.acceptMessage(String.format("Пользователь %s отправил сообщение. ", name[0]));
    }
}
