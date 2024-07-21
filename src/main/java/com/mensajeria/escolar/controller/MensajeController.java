package com.mensajeria.escolar.controller;

import com.mensajeria.escolar.dto.MensajeRequestDto;
import com.mensajeria.escolar.service.MensajeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/message")
@CrossOrigin
public class MensajeController {

    private final MensajeService mensajeService;

    @PostMapping("/newMessageSchool/{schoolId}")
    public void nuevoMensajeEscolar(@PathVariable Long schoolId, @RequestBody MensajeRequestDto mensajeRequestDto){
        mensajeService.newMensajeEscolar(schoolId, mensajeRequestDto);
    }

    @PostMapping("/newMessageSchoolLevel/{levelId}")
    public void nuevoMensajeNivelEscolar(@PathVariable Long levelId, @RequestBody MensajeRequestDto mensajeRequestDto){
        mensajeService.newMensajeNivelEscolar(levelId, mensajeRequestDto);
    }

    @PostMapping("/newMessageYear/{anioId}")
    public void nuevoMensajeAnio(@PathVariable Long anioId, @RequestBody MensajeRequestDto mensajeRequestDto){
        mensajeService.newMensajeAnio(anioId, mensajeRequestDto);
    }

    @PostMapping("/newMessageCourse/{cursoId}")
    public void nuevoMensajeCurso(@PathVariable Long cursoId, @RequestBody MensajeRequestDto mensajeRequestDto){
        mensajeService.newMensajeCurso(cursoId, mensajeRequestDto);
    }

    @GetMapping("/test")
    public Map<String, String> test(){
        Map<String, String> response = new HashMap<>();
        response.put("message", "Hello Nikoll from Spring Boot!");
        return response;
    }


}
