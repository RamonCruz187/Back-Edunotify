package com.mensajeria.escolar.controller;

import com.mensajeria.escolar.dto.EscuelaRequestDto;
import com.mensajeria.escolar.dto.SchoolResponseDto;
import com.mensajeria.escolar.dto.SchoolsResponseDto;
import com.mensajeria.escolar.service.EscuelaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/school")
@CrossOrigin
public class EscuelaController {

    private final EscuelaService escuelaService;


    @PostMapping("/new")
    public void newSchool(@RequestBody EscuelaRequestDto schoolDto){
        escuelaService.newEscuela(schoolDto);
    }

    @GetMapping("/{id}")
    public SchoolResponseDto verEscuela(@PathVariable Long id){
        System.out.println("prueba");
        return new SchoolResponseDto(escuelaService.verEscuela(id));
    }

    @GetMapping("/all")
    public List<SchoolsResponseDto> schoolls(){
        return escuelaService.schools();
    }
}
