package com.mensajeria.escolar.security.controller;

import com.mensajeria.escolar.security.dto.*;
import com.mensajeria.escolar.security.service.IUserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    private final IUserService userService;

    @GetMapping("/all")
    public ResponseEntity<?> getAll(){

        try{
            return ResponseEntity.status(HttpStatus.OK).body(userService.getAll());

        }catch (Exception e){
            List<UserResponseDto> list = new ArrayList<>();
            return new ResponseEntity<>(list, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> UserById(@PathVariable Long id){

        try {
            Optional<UserResponseDto> userById = userService.getUser(id);
            return ResponseEntity.of(userById);
        }catch (Exception e){
            return new ResponseEntity<>("Error al encontrar el usuario", HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/update")
    public ResponseEntity<?> update(@RequestBody UserRequestDtoUpdate userDtoUpdate) {

        try {
            return ResponseEntity.ok(userService.update(userDtoUpdate));
        }catch (Exception e){
            return new ResponseEntity<>("Error al actualizar usuario", HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return new ResponseEntity<>(this.userService.delete(id) ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/new/course/{idUser}/{idCourse}")
    public ResponseEntity<?> newCourse(@PathVariable Long idUser, @PathVariable Long idCourse) {

        try {
            return ResponseEntity.ok(userService.newCourse(idUser, idCourse));
        }catch (Exception e){
            return new ResponseEntity<>("Error al añadir curso", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("delete/course/{idUser}/{idCourse}")
    public ResponseEntity<?> deleteCourse(@PathVariable Long idUser, @PathVariable Long idCourse){
        return new ResponseEntity<>(this.userService.deleteCourse(idUser, idCourse) ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/new/collaborator")
    public ResponseEntity<?> newCollaborator(@RequestBody @Valid CollaboratorRequestDto newCollaborator){

        CollaboratorResponseDto response = userService.newCollaborator(newCollaborator);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}


