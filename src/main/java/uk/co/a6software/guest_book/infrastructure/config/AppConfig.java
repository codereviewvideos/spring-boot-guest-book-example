package uk.co.a6software.guest_book.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import uk.co.a6software.guest_book.core.service.MessageService;
import uk.co.a6software.guest_book.core.service.MessageServiceImpl;

@Configuration
public class AppConfig {
    @Bean
    public MessageService coreMessageService() {
        return new MessageServiceImpl();
    }
}
