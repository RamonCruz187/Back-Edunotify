package com.mensajeria.escolar.service;

import com.mensajeria.escolar.entity.Curso;

public interface CursoService {
    void newCurso(Curso curso);
    Curso verCurso(Long id);
}
