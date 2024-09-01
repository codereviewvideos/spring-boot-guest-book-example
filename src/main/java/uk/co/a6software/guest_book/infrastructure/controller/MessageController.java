package uk.co.a6software.guest_book.infrastructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import uk.co.a6software.guest_book.core.model.Message;
import uk.co.a6software.guest_book.core.model.MessageImpl;
import uk.co.a6software.guest_book.core.service.MessageService;
import uk.co.a6software.guest_book.infrastructure.dto.MessageRequest;

import java.util.List;

@Controller
public class MessageController {
    private final MessageService messageService;

    @Autowired
    public MessageController(@Qualifier("springMessageService") MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/post")
    public ResponseEntity<String> postMessage(@RequestBody MessageRequest messageRequest) {
        MessageImpl message = new MessageImpl(messageRequest.message());
        messageService.postMessage(messageRequest.user(), message);

        return ResponseEntity.ok(message.getMessage());
    }

    @GetMapping("/all")
    public ResponseEntity<List<Message>> getAllMessages() {
        return ResponseEntity.ok(this.messageService.getMessages());
    }
}
