package com.rvk.chat.server;

import java.io.Serializable;
import java.util.Date;

/**
 * Класс реализующий сообщение для отправки/получения
 * пересылается объект этого класса
 */
public class Message implements Serializable {
    private String login;
    private String messegeText;
    private String[] users;
    private Date time;
    private String ip;
    private String port;

    //Конструктор, которым будет пользоваться клиент
    public Message(String login, String messegeText) {
        this.login = login;
        this.messegeText = messegeText;
        this.time = java.util.Calendar.getInstance().getTime();
    }

    //Конструктор, которым будет пользоваться сервер
    public Message(String login, String messegeText, String[] users) {
        this.login = login;
        this.messegeText = messegeText;
        this.users = users;
        this.time = java.util.Calendar.getInstance().getTime();
    }

    public String getLogin() {
        return this.login;
    }

    public String getMessegeText() {
        return this.messegeText;
    }

    public String[] getUsers() {
        return this.users;
    }


    public String getTime() {
        return this.time.toString();
    }

    public void setUsers(String[] users) {
        this.users = users;
    }

    public String getIp() {
        return ip;
    }

    public String getPort() {
        return port;
    }
}

