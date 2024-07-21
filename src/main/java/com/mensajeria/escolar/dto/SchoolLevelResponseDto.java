package com.mensajeria.escolar.dto;

import com.mensajeria.escolar.entity.NivelEscolar;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SchoolLevelResponseDto implements Serializable {
    public String schoolLevel;
    public List<YearResponseDto> years;

    public SchoolLevelResponseDto(NivelEscolar schoolLevel) {
        this.schoolLevel = schoolLevel.getNivel().toString();
        this.years = schoolLevel.getAnios().stream().map(YearResponseDto::new).toList();

    }
}
