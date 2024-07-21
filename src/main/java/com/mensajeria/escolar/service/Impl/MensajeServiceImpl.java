package com.mensajeria.escolar.service.Impl;

import com.mensajeria.escolar.dto.MensajeRequestDto;
import com.mensajeria.escolar.entity.*;
import com.mensajeria.escolar.repository.MensajeRepository;
import com.mensajeria.escolar.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MensajeServiceImpl implements MensajeService {

    private final EscuelaService escuelaService;
    private final MensajeRepository mensajeRepository;
    private final NivelEscolarService nivelEscolarService;
    private final AnioService anioService;
    private final CursoService cursoService;

    @Override
    public void newMensajeEscolar(Long id, MensajeRequestDto mensaje) {
        Escuela escuela= escuelaService.verEscuela(id);
        List<Curso> cursos= new ArrayList<>();
        for (NivelEscolar nivelEscolar:escuela.getNiveles()){
            for(Anio anio: nivelEscolar.getAnios()){
                cursos.addAll(anio.getCurso());
            }
        }
        newMessage(cursos, mensaje);
    }

    @Override
    public void newMensajeNivelEscolar(Long id, MensajeRequestDto mensaje) {
        NivelEscolar nivelEscolar = nivelEscolarService.verNivelEscolar(id);
        List<Curso> cursos = new ArrayList<>();
        for(Anio anio: nivelEscolar.getAnios()){
            cursos.addAll(anio.getCurso());
        }
        newMessage(cursos, mensaje);
    }

    @Override
    public void newMensajeAnio(Long id, MensajeRequestDto mensaje) {
        Anio anio= anioService.verAnio(id);
        List<Curso> cursos = new ArrayList<>(anio.getCurso());
        newMessage(cursos, mensaje);
    }

    @Override
    public void newMensajeCurso(Long id, MensajeRequestDto mensaje) {
        List<Curso> cursos = new ArrayList<>();
        cursos.add(cursoService.verCurso(id));
        newMessage(cursos, mensaje);
    }

    public void newMessage(List<Curso> cursos, MensajeRequestDto mensaje){
        Mensaje mensaje1= new Mensaje();
        mensaje1.setAuthor(mensaje.getAuthor());
        mensaje1.setTitle(mensaje.getTitle());
        mensaje1.setMessage(mensaje.getMessage());
        mensaje1.setExpiration(mensaje.getExpiration());
        mensaje1.setCursos(cursos);
        mensajeRepository.save(mensaje1);
    }

}
