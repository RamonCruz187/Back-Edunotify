package com.mensajeria.escolar.service;

import com.mensajeria.escolar.dto.EscuelaRequestDto;
import com.mensajeria.escolar.entity.NivelEscolar;

import java.util.List;

public interface NivelEscolarService {
    void newNivelEscolar(NivelEscolar nivelEscolar);

    void newNivelEscolarList (List<NivelEscolar> nivelEscolarList);

    NivelEscolar verNivelEscolar(Long id);
}
