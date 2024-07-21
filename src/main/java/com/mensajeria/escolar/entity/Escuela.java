package com.mensajeria.escolar.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@ToString
public class Escuela {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @OneToMany(targetEntity = NivelEscolar.class, fetch = FetchType.LAZY, mappedBy = "escuela")
    private List<NivelEscolar> niveles;
}
