package pl.edu.wszib.springreactive;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.wszib.springreactive.dto.Message;
import pl.edu.wszib.springreactive.repository.MessageRepository;
import pl.edu.wszib.springreactive.repository.entity.MessageEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
public class MainController {
    private final MessageRepository messageRepository;

    @GetMapping
    public Flux<Message> getMessages() {
        return messageRepository.findAll()
                .map(messageEntity -> new Message(messageEntity.getMessage(), messageEntity.getTimestamp()));
    }

    @PostMapping
    public Mono<Void> saveMessage(@RequestBody final Message message) {
        return messageRepository.save(new MessageEntity(null, message.getMessage(), message.getTimestamp())).then();
    }
}
