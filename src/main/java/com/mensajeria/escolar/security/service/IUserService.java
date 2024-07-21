package com.mensajeria.escolar.security.service;

import com.mensajeria.escolar.security.dto.CollaboratorRequestDto;
import com.mensajeria.escolar.security.dto.CollaboratorResponseDto;
import com.mensajeria.escolar.security.dto.UserRequestDtoUpdate;
import com.mensajeria.escolar.security.dto.UserResponseDto;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<UserResponseDto> getAll();
    Optional<UserResponseDto> getUser(Long idUser);
    UserResponseDto update(UserRequestDtoUpdate userDtoUpdate);
    boolean delete(Long idUser);
    Optional<UserResponseDto> newCourse(Long idUser, Long idCourse);
    boolean deleteCourse(Long idUser, Long idCourse);
    CollaboratorResponseDto newCollaborator(CollaboratorRequestDto collaboratorRequestDto);
}
