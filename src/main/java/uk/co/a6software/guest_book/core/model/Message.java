package uk.co.a6software.guest_book.core.model;

import java.time.LocalDateTime;

public interface Message {
    String getName();
    String getMessage();
    LocalDateTime getTime();
}
