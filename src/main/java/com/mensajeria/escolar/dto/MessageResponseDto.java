package com.mensajeria.escolar.dto;

import com.mensajeria.escolar.entity.Mensaje;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class MessageResponseDto implements Serializable {
    private Long message_id;
    private LocalDateTime messageDate;
    private String author;
    private String title;
    public String message;
    public Long expiration;

    public MessageResponseDto(Mensaje message) {
        this.message_id = message.getId();
        this.messageDate=LocalDateTime.now();
        this.author=message.getAuthor();
        this.title=message.getTitle();
        this.message = message.getMessage();
        this.expiration = message.getExpiration();
    }
}
