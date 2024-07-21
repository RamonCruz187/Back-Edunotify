package com.mensajeria.escolar.dto;

import com.mensajeria.escolar.entity.Escuela;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SchoolResponseDto implements Serializable {

    public String name;
    public List<NivelEscolarResponseDto> levels;

    public SchoolResponseDto(Escuela escuela) {
        this.name = escuela.getNombre();
        this.levels = escuela.getNiveles().stream().map(NivelEscolarResponseDto::new).toList();
    }
}
