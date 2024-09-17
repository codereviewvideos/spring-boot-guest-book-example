package uk.co.a6software.guest_book.infrastructure.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import uk.co.a6software.guest_book.core.model.Message;
import uk.co.a6software.guest_book.core.service.MessageService;
import uk.co.a6software.guest_book.infrastructure.entity.MessageEntity;
import uk.co.a6software.guest_book.infrastructure.repository.MessageRepository;
import uk.co.a6software.guest_book.infrastructure.transformer.MessageTransformer;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Qualifier("springMessageService")
public class SpringMessageService implements MessageService {
    private static final Logger logger = LoggerFactory.getLogger(SpringMessageService.class);

    private final MessageService messageService;
    private final MessageRepository messageRepository;

    public SpringMessageService(@Qualifier("coreMessageService") MessageService messageService,
    MessageRepository messageRepository
    ) {
        this.messageService = messageService;
        this.messageRepository = messageRepository;
    }

    @Override
    public List<Message> getMessages() {
        logger.info("Fetching all messages");
        List<MessageEntity> messageEntities = this.messageRepository.findAll();
        List<Message> messages = messageEntities.stream().map(MessageTransformer::toMessage).toList();
        logger.info("Fetched {} messages", messages.size());
        return messages;
    }

    @Override
    public void postMessage(Message message) {
        logger.info("Posting message for user: {}", message.getName());
        this.messageRepository.saveAndFlush(MessageTransformer.toMessageEntity(message));
        this.messageService.postMessage( message);
        logger.info("Message posted for user: {}", message.getName());
    }
}
