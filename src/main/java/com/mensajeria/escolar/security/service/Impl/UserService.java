package com.mensajeria.escolar.security.service.Impl;

import com.mensajeria.escolar.entity.Curso;
import com.mensajeria.escolar.security.config.JwtService;
import com.mensajeria.escolar.security.dto.*;
import com.mensajeria.escolar.security.entity.RoleName;
import com.mensajeria.escolar.security.entity.User;
import com.mensajeria.escolar.security.exception.ResourceNotFoundException;
import com.mensajeria.escolar.security.mapper.UserMapper;
import com.mensajeria.escolar.security.repository.UserRepository;
import com.mensajeria.escolar.security.service.IUserService;
import com.mensajeria.escolar.service.CursoService;
import com.mensajeria.escolar.service.EscuelaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService implements IUserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final CursoService cursoService;
    private final PasswordEncoder encoder;
    private final JwtService jwtService;
    EscuelaService escuelaService;


    @Override
    public List<UserResponseDto> getAll() {
        return userMapper.convertToListDto(userRepository.findAll());
    }

    @Override
    public Optional<UserResponseDto> getUser(Long idUser) {
        return Optional.of(userMapper.toUserDto(userRepository.getUserById(idUser)));
    }

    @Override
    public UserResponseDto update(UserRequestDtoUpdate userDtoUpdate) {
        if(userRepository.findByEmail(userDtoUpdate.getEmail()).isEmpty()){
            throw new ResourceNotFoundException("El correo electrónico no se encuentra registrado");
        }

        var user = userRepository.getUserById(userDtoUpdate.getId());
        BeanUtils.copyProperties(userDtoUpdate, user);

        return userMapper.toUserDto(userRepository.save(user));
    }

    @Override
    public boolean delete(Long idUser) {
        if(userRepository.getUserById(idUser) != null){
            return false;
        }
        userRepository.deleteById(idUser);
        return true;
    }

    @Override
    public Optional<UserResponseDto> newCourse(Long idUser, Long idCourse) {
        User user = userRepository.getUserById(idUser);
        Curso course= cursoService.verCurso(idCourse);

        if (!user.getCursos().contains(course)) {
            user.getCursos().add(course);
            userRepository.save(user);
        }else {
            // Manejar el caso donde el curso ya está en la lista del usuario
            // Puedes lanzar una excepción, retornar un mensaje de error, o simplemente no hacer nada según tus requerimientos
            // Aquí, por ejemplo, lanzamos una excepción
            throw new IllegalArgumentException("El curso ya está en la lista del usuario");
        }

        return Optional.of(userMapper.toUserDto(user)) ;
    }

    @Override
    public boolean deleteCourse(Long idUser, Long idCourse) {
        User user = userRepository.getUserById(idUser);
        Curso course= cursoService.verCurso(idCourse);
        if (!user.getCursos().contains(course)) {
            return false;
        }else{
            user.getCursos().remove(course);
            userRepository.save(user);
        }
        return true;

        }

    @Override
    public CollaboratorResponseDto newCollaborator(CollaboratorRequestDto collaboratorRequestDto) {

        if (userRepository.findByEmail(collaboratorRequestDto.getEmail()).isPresent()) {
            throw new ResourceNotFoundException("El correo electrónico esta registrado");
        }

        User usuario = User.builder()
                .name(collaboratorRequestDto.getName())
                .lastName(collaboratorRequestDto.getLastName())
                .email(collaboratorRequestDto.getEmail())
                .phone(collaboratorRequestDto.getPhone())
                .password(encoder.encode(collaboratorRequestDto.getPassword()))
                .role(RoleName.COLABORADOR)
                .charge(collaboratorRequestDto.getCharge())
                .school_id(collaboratorRequestDto.getSchool())
                .build();

        userRepository.save(usuario);


        return CollaboratorResponseDto.builder()

                .name(collaboratorRequestDto.getName())
                .lastName(collaboratorRequestDto.getLastName())
                .email(collaboratorRequestDto.getEmail())
                .phone(collaboratorRequestDto.getPhone())
                .school(escuelaService.verEscuela(collaboratorRequestDto.getSchool()).getId())
                .charge(collaboratorRequestDto.getCharge())
                .build();

    }
}

