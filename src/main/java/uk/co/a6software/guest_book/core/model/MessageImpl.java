package uk.co.a6software.guest_book.core.model;

public record MessageImpl(String message) implements Message {
    @Override
    public String getMessage() {
        return message;
    }

    
}
