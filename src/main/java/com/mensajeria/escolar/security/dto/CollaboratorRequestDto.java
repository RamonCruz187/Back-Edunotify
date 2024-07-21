package com.mensajeria.escolar.security.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CollaboratorRequestDto implements Serializable {
    private String name;
    private String lastName;
    private String email;
    private String phone;
    private Long school;
    private String charge;
    private String password;

}
