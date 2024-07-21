package com.mensajeria.escolar.service.Impl;

import com.mensajeria.escolar.entity.Curso;
import com.mensajeria.escolar.repository.CursoRepository;
import com.mensajeria.escolar.service.CursoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CursoServiceImpl implements CursoService {
    private final CursoRepository cursoRepository;
    @Override
    public void newCurso(Curso curso) {
        cursoRepository.save(curso);
    }

    @Override
    public Curso verCurso(Long id) {
        return cursoRepository.findById(id).orElse(null);
    }
}
