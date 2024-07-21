package com.mensajeria.escolar.repository;

import com.mensajeria.escolar.entity.Anio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnioRepository extends JpaRepository<Anio, Long> {
}
