package com.mensajeria.escolar.security.service.Impl;

import com.mensajeria.escolar.dto.CursoResponseDto;
import com.mensajeria.escolar.entity.Curso;
import com.mensajeria.escolar.security.config.JwtService;
import com.mensajeria.escolar.security.dto.AuthResponseDto;
import com.mensajeria.escolar.security.dto.LoginRequestDto;
import com.mensajeria.escolar.security.dto.RegisterRequestDto;
import com.mensajeria.escolar.security.dto.UserResponseDto;
import com.mensajeria.escolar.security.entity.RoleName;
import com.mensajeria.escolar.security.entity.User;
import com.mensajeria.escolar.security.exception.ResourceNotFoundException;
import com.mensajeria.escolar.security.exception.ValidationIntegrity;
import com.mensajeria.escolar.security.repository.UserRepository;
import com.mensajeria.escolar.security.service.IAuthService;
import com.mensajeria.escolar.service.EscuelaService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthService implements IAuthService {

    private final UserRepository userRepository;
    private final AuthenticationManager authManager;
    private final JwtService jwtService;
    private final PasswordEncoder encoder;
    private final EscuelaService escuelaService;

    @Override
    public AuthResponseDto login(LoginRequestDto authRequest) {
        var user = userRepository.findByEmail(authRequest.getEmail()).orElseThrow(() -> new ResourceNotFoundException("El correo electrónico no esta registrado"));

        try {
            authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authRequest.getEmail(),
                            authRequest.getPassword()
                    )
            );
        } catch (AuthenticationException e) {
            throw new ValidationIntegrity("El nombre de usuario o la contraseña no son validos");
        }

        String token = jwtService.generateToken(user);

        List<Long> cursoIds = user.getCursos().stream()
                .map(Curso::getId) // Suponiendo que Course tiene un método getId()
                .toList();

        return AuthResponseDto.builder()
                .jwt(token)
                .user(UserResponseDto.builder()
                        .id(user.getId())
                        .name(user.getName())
                        .lastName(user.getLastName())
                        .email(user.getEmail())
                        .phone(user.getPhone())
                        .role(user.getRole())
                        .school(escuelaService.verEscuela(user.getSchool_id()).getId())
                        .courses(user.getCursos().stream().map(CursoResponseDto::new).toList())
                        .build())
                .build();
    }

    @Override
    public AuthResponseDto register(RegisterRequestDto newUserDto){

        if(userRepository.findByEmail(newUserDto.getEmail()).isPresent()){
            throw new ResourceNotFoundException("El correo electrónico esta registrado");
        }

        User usuario = User.builder()
                .name(newUserDto.getName())
                .lastName(newUserDto.getLastName())
                .email(newUserDto.getEmail())
                .phone(newUserDto.getPhone())
                .password(encoder.encode(newUserDto.getPassword()))
                .role(RoleName.USUARIO)
                .school_id(newUserDto.getSchool())
                .build();

        userRepository.save(usuario);

        String token = jwtService.generateToken(usuario);

        return AuthResponseDto.builder()
                .jwt(token)
                .user(UserResponseDto.builder()
                        .id(usuario.getId())
                        .name(newUserDto.getName())
                        .lastName(newUserDto.getLastName())
                        .email(newUserDto.getEmail())
                        .phone(newUserDto.getPhone())
                        .role(RoleName.USUARIO)
                        .school(escuelaService.verEscuela(newUserDto.getSchool()).getId())
                        .build())
                .build();
    }
}
