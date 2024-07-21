package com.mensajeria.escolar.service;

import com.mensajeria.escolar.dto.EscuelaRequestDto;
import com.mensajeria.escolar.dto.MensajeRequestDto;
import com.mensajeria.escolar.entity.*;

public interface MensajeService {
void newMensajeEscolar(Long id, MensajeRequestDto mensaje);
void newMensajeNivelEscolar(Long id, MensajeRequestDto mensaje);
void newMensajeAnio(Long id, MensajeRequestDto mensaje);
void newMensajeCurso(Long id, MensajeRequestDto mensaje);
}
