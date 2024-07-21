package com.mensajeria.escolar.dto;

import com.mensajeria.escolar.entity.Anio;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnioResponseDto implements Serializable {

    public String year;
    public List<CourseResponseDto> courses;

    public AnioResponseDto(Anio year) {
        this.year = year.getAnio();
        this.courses = year.getCurso().stream().map(CourseResponseDto::new).toList();
    }
}
