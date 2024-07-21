package com.mensajeria.escolar.security.mapper;

import com.mensajeria.escolar.dto.CursoResponseDto;
import com.mensajeria.escolar.entity.Curso;
import com.mensajeria.escolar.security.dto.UserResponseDto;
import com.mensajeria.escolar.security.entity.User;
import com.mensajeria.escolar.service.EscuelaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserMapper {

    private final EscuelaService escuelaService;
    public User toUserEntity(UserResponseDto userDto){


        return User.builder()
                .name(userDto.getName())
                .lastName(userDto.getLastName())
                .phone(userDto.getPhone())
                .email(userDto.getEmail())
                .build();
    }

    public UserResponseDto toUserDto(User userEntity){

        List<Long> cursoIds = userEntity.getCursos().stream()
                .map(Curso::getId) // Suponiendo que Course tiene un método getId()
                .toList();

        return UserResponseDto.builder()
                .id(userEntity.getId())
                .name(userEntity.getName())
                .lastName(userEntity.getLastName())
                .phone(userEntity.getPhone())
                .role(userEntity.getRole())
                .email(userEntity.getEmail())
                .school(escuelaService.verEscuela(userEntity.getSchool_id()).getId())
                .courses(userEntity.getCursos().stream().map(CursoResponseDto::new).toList())
                .build();

    }

    public List<UserResponseDto> convertToListDto(List<User> users){

        if ( users == null ) {
            return null;
        }

        List<UserResponseDto> list = new ArrayList<>();
        for ( User c : users ) {
            list.add(toUserDto(c));
        }

        return list;
    }
}
