package com.mensajeria.escolar.controller;

import com.mensajeria.escolar.dto.MensajeRequestDto;
import com.mensajeria.escolar.service.MensajeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> nuevoMensajeEscolar(@PathVariable Long schoolId, @RequestBody MensajeRequestDto mensajeRequestDto){
        try {
            mensajeService.newMensajeEscolar(schoolId, mensajeRequestDto);
            return ResponseEntity.ok("Se ha enviado el correo correctamente");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al enviar el correo");
        }
    }

    @PostMapping("/newMessageSchoolLevel/{levelId}")
    public ResponseEntity<?> nuevoMensajeNivelEscolar(@PathVariable Long levelId, @RequestBody MensajeRequestDto mensajeRequestDto){
        try {
            mensajeService.newMensajeNivelEscolar(levelId, mensajeRequestDto);
            return ResponseEntity.ok("Se ha enviado el correo correctamente");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al enviar el correo");
        }
    }

    @PostMapping("/newMessageYear/{anioId}")
    public ResponseEntity<?> nuevoMensajeAnio(@PathVariable Long anioId, @RequestBody MensajeRequestDto mensajeRequestDto){

        try {
            mensajeService.newMensajeAnio(anioId, mensajeRequestDto);
            return ResponseEntity.ok("Se ha enviado el correo correctamente");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al enviar el correo");
        }
    }

    @PostMapping("/newMessageCourse/{cursoId}")
    public ResponseEntity<?> nuevoMensajeCurso(@PathVariable Long cursoId, @RequestBody MensajeRequestDto mensajeRequestDto){

        try {
            mensajeService.newMensajeCurso(cursoId, mensajeRequestDto);
            return ResponseEntity.ok("Se ha enviado el correo correctamente");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al enviar el correo");
        }
    }

    @GetMapping("/test")
    public Map<String, String> test(){
        Map<String, String> response = new HashMap<>();
        response.put("message", "Hello from Spring Boot!");
        return response;
    }


}
