package com.mensajeria.escolar.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class MensajeRequestDto implements Serializable {
    public String author;
    public String title;
    public String message;
    public Long expiration;

}
