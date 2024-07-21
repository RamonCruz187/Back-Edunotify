package com.mensajeria.escolar.security.dto;

import com.mensajeria.escolar.entity.Curso;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterRequestDto implements Serializable {
    private String name;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private Long school;
}
