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
public class Anio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String anio;

    @ManyToOne(targetEntity = NivelEscolar.class)
    private NivelEscolar nivelEscolar;

    @OneToMany(targetEntity = Curso.class, mappedBy = "anio", fetch = FetchType.LAZY)
    private List<Curso> curso;
}
