package pl.edu.wszib.springreactive.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.ZonedDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("messages")
public class MessageEntity {
    @Id
    private Integer id;
    private String message;
    private ZonedDateTime timestamp;
}
