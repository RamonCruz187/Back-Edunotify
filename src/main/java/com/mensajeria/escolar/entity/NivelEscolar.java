package com.mensajeria.escolar.entity;

import com.mensajeria.escolar.enums.Nivel;
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
public class NivelEscolar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    Nivel nivel;

    @ManyToOne(targetEntity = Escuela.class)
    private Escuela escuela;

    @OneToMany (targetEntity = Anio.class, mappedBy = "nivelEscolar", fetch = FetchType.LAZY)
    private List<Anio> anios;
}
