package com.mensajeria.escolar.security.dto;

import com.mensajeria.escolar.dto.CursoResponseDto;
import com.mensajeria.escolar.security.entity.RoleName;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CollaboratorResponseDto {
    private String name;
    private String lastName;
    private String email;
    private String phone;
    private Long school;
    private String charge;
}
