package com.mensajeria.escolar.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Mensaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime messageDate;

    private String author;

    private String title;

    private String message;

    private Long expiration;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(
            name = "mensaje_curso", joinColumns = @JoinColumn(name = "mensaje_id", referencedColumnName = "id"),
            inverseJoinColumns =@JoinColumn(name = "curso_id", referencedColumnName = "id")
    )
    private List<Curso> cursos;
}
