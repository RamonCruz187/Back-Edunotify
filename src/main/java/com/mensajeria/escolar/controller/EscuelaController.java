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

        try {
            escuelaService.newEscuela(schoolDto);
            return ResponseEntity.status(HttpStatus.CREATED).body("Escuela creada correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al crear la escuela");
        }
    }



    @GetMapping("/{id}")
    public ResponseEntity<?>  verEscuela(@PathVariable Long id){

        try {
            return ResponseEntity.status(HttpStatus.OK).body(new SchoolResponseDto(escuelaService.verEscuela(id)));
        }catch (Exception e){
            return new ResponseEntity<>("Error al encontrar la escuela", HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/all")
    public ResponseEntity<?> schools(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(escuelaService.schools());
        }catch (Exception e){
            return new ResponseEntity<>("Error al encontrar las escuelas", HttpStatus.NOT_FOUND);
        }
    }
}
