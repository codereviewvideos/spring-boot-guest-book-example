package uk.co.a6software.guest_book.core.service;

import uk.co.a6software.guest_book.core.model.Message;

import java.util.ArrayList;
import java.util.List;

public class MessageServiceImpl implements MessageService {
    private final List<Message> messages = new ArrayList<>();

    @Override
    public void postMessage(String user, Message message) {
        this.messages.add(message);
    }

    @Override
    public List<Message> getMessages() {
        return this.messages;
    }
}
