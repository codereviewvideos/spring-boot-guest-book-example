package uk.co.a6software.guest_book.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uk.co.a6software.guest_book.infrastructure.entity.MessageEntity;

public interface MessageRepository extends JpaRepository<MessageEntity,Long> {
}
