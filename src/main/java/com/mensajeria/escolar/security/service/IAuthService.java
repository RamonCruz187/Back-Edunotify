package com.mensajeria.escolar.security.service;

import com.mensajeria.escolar.security.dto.AuthResponseDto;
import com.mensajeria.escolar.security.dto.LoginRequestDto;
import com.mensajeria.escolar.security.dto.RegisterRequestDto;

public interface IAuthService {
    AuthResponseDto login(LoginRequestDto authRequest);

    AuthResponseDto register(RegisterRequestDto newUserDto);
}
