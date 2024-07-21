package com.mensajeria.escolar.service;

import com.mensajeria.escolar.entity.Anio;

public interface AnioService {
    void newAnio(Anio anio);

    Anio verAnio(Long id);
}
