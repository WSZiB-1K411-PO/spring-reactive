package pl.edu.wszib.springreactive.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import pl.edu.wszib.springreactive.repository.entity.MessageEntity;

public interface MessageRepository extends ReactiveCrudRepository<MessageEntity, Integer> {
}
