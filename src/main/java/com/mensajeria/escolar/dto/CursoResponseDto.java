package com.mensajeria.escolar.dto;

import com.mensajeria.escolar.entity.Curso;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CursoResponseDto implements Serializable {
    public String course;
    public Long courseId;
    public List<MessageResponseDto> messages;
    public CursoResponseDto(Curso course) {
        this.course = course.getCurso();
        this.courseId = course.getId();
        this.messages = course.getMensajes().stream().map(MessageResponseDto::new).toList();
    }
}
