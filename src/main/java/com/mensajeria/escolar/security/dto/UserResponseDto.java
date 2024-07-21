package com.mensajeria.escolar.security.dto;

import com.mensajeria.escolar.dto.CursoResponseDto;
import com.mensajeria.escolar.entity.Escuela;
import com.mensajeria.escolar.security.entity.RoleName;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String phone;
    private RoleName role;
    private Long school;
    private List<CursoResponseDto> courses;

}
