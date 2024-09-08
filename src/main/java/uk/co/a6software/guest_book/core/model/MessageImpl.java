package uk.co.a6software.guest_book.core.model;

import java.time.LocalDateTime;

public record  MessageImpl(String name, String message, LocalDateTime time) implements Message {

    public MessageImpl(String name, String message) {
        this(name,message,LocalDateTime.now());
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public LocalDateTime getTime() {
        return time;
    }

    @Override
    public String getMessage() {
        return message;
    }

    
}
