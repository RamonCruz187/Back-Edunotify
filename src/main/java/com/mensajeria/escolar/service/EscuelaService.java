package com.mensajeria.escolar.service;

import com.mensajeria.escolar.dto.EscuelaRequestDto;
import com.mensajeria.escolar.dto.SchoolsResponseDto;
import com.mensajeria.escolar.entity.Escuela;

import java.util.List;

public interface EscuelaService {
    void newEscuela(EscuelaRequestDto schoolDto);

    Escuela verEscuela(Long id);
    List<SchoolsResponseDto> schools();

}
