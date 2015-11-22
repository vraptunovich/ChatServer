package com.rvk.chat.server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Класс-коллекция для хранения клиентов
 */
public class UserList {
    private Map<String, ClientConnect> onlineUsers = new HashMap<String, ClientConnect>();

    public void addUser(String login, Socket socket, ObjectOutputStream outputStream, ObjectInputStream inputStream) {
        System.out.println(login + " подсоеденился");

        if (!this.onlineUsers.containsKey(login)) {
            this.onlineUsers.put(login, new ClientConnect(socket, inputStream, outputStream));
        } else {
            int i = 1;
            while (this.onlineUsers.containsKey(login)) {
                login = login + i;
                i++;
            }
            this.onlineUsers.put(login, new ClientConnect(socket, inputStream, outputStream));
        }
    }

    public void deleteUser(String login) {
        this.onlineUsers.remove(login);
    }

    public String[] getUser() {
        return this.onlineUsers.keySet().toArray(new String[0]);

    }

    public ArrayList<ClientConnect> getClientsList() {
        ArrayList<ClientConnect> clientConnectArrayList = new ArrayList<ClientConnect>(this.onlineUsers.size());

        String s = " ";
        for (Map.Entry<String, ClientConnect> m : this.onlineUsers.entrySet()) {
            clientConnectArrayList.add(m.getValue());
            System.out.println(m.getKey());
            s = s + m.getKey();
        }
        return clientConnectArrayList;
    }
}
