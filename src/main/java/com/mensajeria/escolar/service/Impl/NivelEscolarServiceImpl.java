package com.mensajeria.escolar.service.Impl;

import com.mensajeria.escolar.dto.EscuelaRequestDto;
import com.mensajeria.escolar.entity.NivelEscolar;
import com.mensajeria.escolar.repository.NivelEscolarRepository;
import com.mensajeria.escolar.service.NivelEscolarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NivelEscolarServiceImpl implements NivelEscolarService {
    private final NivelEscolarRepository nivelEscolarRepository;


    @Override
    public void newNivelEscolar(NivelEscolar nivelEscolar) {
        nivelEscolarRepository.save(nivelEscolar);
    }

    @Override
    public void newNivelEscolarList(List<NivelEscolar> nivelEscolarList) {
        nivelEscolarRepository.saveAll(nivelEscolarList);
    }

    @Override
    public NivelEscolar verNivelEscolar(Long id) {
        return nivelEscolarRepository.findById(id).orElse(null);
    }
}
