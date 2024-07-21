package com.mensajeria.escolar.service.Impl;

import com.mensajeria.escolar.dto.EscuelaRequestDto;
import com.mensajeria.escolar.dto.SchoolsResponseDto;
import com.mensajeria.escolar.entity.Anio;
import com.mensajeria.escolar.entity.Curso;
import com.mensajeria.escolar.entity.Escuela;
import com.mensajeria.escolar.entity.NivelEscolar;
import com.mensajeria.escolar.repository.EscuelaRepository;
import com.mensajeria.escolar.service.AnioService;
import com.mensajeria.escolar.service.CursoService;
import com.mensajeria.escolar.service.EscuelaService;
import com.mensajeria.escolar.service.NivelEscolarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EscuelaServiceImpl implements EscuelaService {
    final EscuelaRepository escuelaRepository;
    final NivelEscolarService nivelEscolarService;
    final AnioService anioService;
    final CursoService cursoService;
    @Override
    public void newEscuela(EscuelaRequestDto schoolDto) {
        Escuela escuela= new Escuela();
        escuela.setNombre(schoolDto.getName());
        escuelaRepository.save(escuela);

        List<NivelEscolar> nivelEscolarList=schoolDto.getSchoolLevels().stream().map(nivelDto -> {
            NivelEscolar nivelEscolar=new NivelEscolar();
            nivelEscolar.setNivel(nivelDto.getNivel());
            nivelEscolar.setEscuela(escuela);
            nivelEscolarService.newNivelEscolar(nivelEscolar);

            List<Anio> anioList=nivelDto.getAnios().stream().map(anioDto -> {
                Anio anio= new Anio();
                anio.setAnio(anioDto.getAnio());
                anio.setNivelEscolar(nivelEscolar);
                anioService.newAnio(anio);

                List<Curso> cursoList = anioDto.getCurso().stream().map(cursoDto -> {
                    Curso curso= new Curso();
                    curso.setCurso(cursoDto.getCurso());
                    curso.setAnio(anio);
                    cursoService.newCurso(curso);
                    return curso;

                }).collect(Collectors.toList());

                anio.setCurso(cursoList);
                return anio;
            }).collect(Collectors.toList());

            nivelEscolar.setAnios(anioList);
            return nivelEscolar;

        }).collect(Collectors.toList());

    escuela.setNiveles(nivelEscolarList);
    escuelaRepository.save(escuela);

    }

    @Override
    public Escuela verEscuela(Long id) {
        return escuelaRepository.findById(id).orElse(null);
    }

    @Override
    public List<SchoolsResponseDto> schools() {
        return escuelaRepository.findAll().stream().map(SchoolsResponseDto::new).toList();
    }
}
