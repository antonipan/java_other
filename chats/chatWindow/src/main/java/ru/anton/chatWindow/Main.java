package ru.anton.homework01;

import ru.anton.homework01.client.ClientView;
import ru.anton.homework01.server.ServerView;

public class Main {
    public static void main(String[] args) {
        ServerView serverView = new ServerView();
        new ClientView(serverView);
        new ClientView(serverView);
    }
}
