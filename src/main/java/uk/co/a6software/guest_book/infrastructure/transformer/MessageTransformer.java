package uk.co.a6software.guest_book.infrastructure.transformer;

import uk.co.a6software.guest_book.core.model.Message;
import uk.co.a6software.guest_book.core.model.MessageImpl;
import uk.co.a6software.guest_book.infrastructure.entity.MessageEntity;

public class MessageTransformer {
    public static Message toMessage(MessageEntity messageEntity) {
        return new MessageImpl(messageEntity.getName(), messageEntity.getMessage(), messageEntity.getTime());
    }

    public static MessageEntity toMessageEntity(Message message) {
        return new MessageEntity(message.getName(), message.getMessage(), message.getTime());
    }
}
