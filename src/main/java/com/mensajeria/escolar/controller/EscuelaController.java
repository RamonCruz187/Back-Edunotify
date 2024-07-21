package com.mensajeria.escolar.controller;

import com.mensajeria.escolar.dto.EscuelaRequestDto;
import com.mensajeria.escolar.dto.SchoolResponseDto;
import com.mensajeria.escolar.dto.SchoolsResponseDto;
import com.mensajeria.escolar.security.dto.CollaboratorResponseDto;
import com.mensajeria.escolar.service.EscuelaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/school")
@CrossOrigin
public class EscuelaController {

    private final EscuelaService escuelaService;


    @PostMapping("/newSchool")
    public ResponseEntity<?> newSchool(@RequestBody EscuelaRequestDto schoolDto){
        escuelaService.newEscuela(schoolDto);

try {
    return ResponseEntity.status(HttpStatus.CREATED).body("Escuela creada correctamente");
} catch (Exception e) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al crear la escuela");
}
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
