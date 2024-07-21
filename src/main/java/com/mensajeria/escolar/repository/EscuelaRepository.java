package com.mensajeria.escolar.repository;

import com.mensajeria.escolar.entity.Escuela;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EscuelaRepository extends JpaRepository<Escuela, Long> {
}
