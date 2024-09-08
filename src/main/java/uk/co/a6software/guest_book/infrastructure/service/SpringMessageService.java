package uk.co.a6software.guest_book.infrastructure.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import uk.co.a6software.guest_book.core.model.Message;
import uk.co.a6software.guest_book.core.service.MessageService;

import java.util.List;

@Service
@Qualifier("springMessageService")
public class SpringMessageService implements MessageService {
    private static final Logger logger = LoggerFactory.getLogger(SpringMessageService.class);

    private final MessageService messageService;

    public SpringMessageService(@Qualifier("coreMessageService") MessageService messageService) {
        this.messageService = messageService;
    }

    @Override
    public List<Message> getMessages() {
        logger.info("Fetching all messages");
        List<Message> messages = this.messageService.getMessages();
        logger.info("Fetched {} messages", messages.size());
        return messages;
    }

    @Override
    public void postMessage(Message message) {
        logger.info("Posting message for user: {}", message.getName());
        this.messageService.postMessage( message);
        logger.info("Message posted for user: {}", message.getName());
    }
}
