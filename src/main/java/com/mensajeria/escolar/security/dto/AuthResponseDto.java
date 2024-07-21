package com.mensajeria.escolar.security.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthResponseDto {
    private String jwt;
    private UserResponseDto user;
}
