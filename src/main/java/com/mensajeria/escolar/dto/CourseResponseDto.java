package com.mensajeria.escolar.dto;

import com.mensajeria.escolar.entity.Curso;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CourseResponseDto implements Serializable {
    public String course;
    public Long courseId;

    public CourseResponseDto(Curso course) {
        this.course = course.getCurso();
        this.courseId = course.getId();
    }
}
