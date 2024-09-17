package uk.co.a6software.guest_book.infrastructure.entity;

import jakarta.persistence.*;
import uk.co.a6software.guest_book.core.model.Message;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
public class MessageEntity implements Message, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable =false)
    private String name;
    @Column(nullable = false)
    private String message;
    private LocalDateTime time;



    protected MessageEntity() {

    }

    public MessageEntity(String name, String message, LocalDateTime time) {
        this.name = name;
        this.message = message;
        this.time = time;
    }


    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
