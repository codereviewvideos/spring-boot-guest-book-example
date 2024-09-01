package uk.co.a6software.guest_book.core.service;

import uk.co.a6software.guest_book.core.model.Message;

import java.util.List;

public interface MessageService {
    void postMessage(String user, Message message);

    List<Message> getMessages();

}
