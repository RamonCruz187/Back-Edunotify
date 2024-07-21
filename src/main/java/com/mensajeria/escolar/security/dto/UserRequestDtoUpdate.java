package com.mensajeria.escolar.security.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDtoUpdate {
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String phone;
    private String address;
}
