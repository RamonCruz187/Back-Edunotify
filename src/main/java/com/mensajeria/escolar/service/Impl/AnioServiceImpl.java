package com.mensajeria.escolar.service.Impl;

import com.mensajeria.escolar.entity.Anio;
import com.mensajeria.escolar.repository.AnioRepository;
import com.mensajeria.escolar.service.AnioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnioServiceImpl implements AnioService {
    private final AnioRepository anioRepository;
    @Override
    public void newAnio(Anio anio) {
        anioRepository.save(anio);
    }

    @Override
    public Anio verAnio(Long id) {
        return anioRepository.findById(id).orElse(null);
    }
}
