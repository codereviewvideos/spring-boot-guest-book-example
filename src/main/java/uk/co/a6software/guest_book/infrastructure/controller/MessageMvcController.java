package uk.co.a6software.guest_book.infrastructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import uk.co.a6software.guest_book.core.model.Message;
import uk.co.a6software.guest_book.core.model.MessageImpl;
import uk.co.a6software.guest_book.core.service.MessageService;
import uk.co.a6software.guest_book.infrastructure.dto.MessageRequest;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Controller
public class MessageMvcController {
    private final MessageService messageService;

    @Autowired
    public MessageMvcController(@Qualifier("springMessageService") MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/add")
    public String postMessage(@RequestParam("user") String user, @RequestParam("message") String message) {
        MessageImpl msg = new MessageImpl(user,message);
        messageService.postMessage( msg);

        return "redirect:/show";
    }

    @GetMapping("/show")
    public String showAllMessages(Model model) {
        model.addAttribute("messages", this.messageService.getMessages());
        return "messages";
    }
}
