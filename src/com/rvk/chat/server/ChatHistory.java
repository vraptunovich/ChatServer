package com.rvk.chat.server;

import com.rvk.chat.config.Config;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс-коллекция для хранения истории чата
 */
public class ChatHistory {
    private List<Message> history;

    public List<Message> getHistory() {
        return history;
    }

    public ChatHistory() {
        this.history = new ArrayList<Message>(Config.HISTORY_LENGTH);
    }

    public void addHistory(Message message) {
        if (this.history.size() > Config.HISTORY_LENGTH) this.history.remove(0);
        this.history.add(message);
    }
}
