package com.mensajeria.escolar.repository;

import com.mensajeria.escolar.entity.NivelEscolar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NivelEscolarRepository extends JpaRepository<NivelEscolar, Long> {
}
