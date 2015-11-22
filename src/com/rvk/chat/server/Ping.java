package com.rvk.chat.server;

/**
 * Класс-наследний Message для отправки и получения системных сообщений и проверки сооединения
 */
public class Ping extends Message {
    private String systemMessege;

    Ping() {
        super("ping", "ping");
    }

    public String getSystemMessege() {
        return systemMessege;
    }

    public void setSystemMessege(String systemMessege) {
        this.systemMessege = systemMessege;
    }
}
