package com.mensajeria.escolar.entity;

import com.mensajeria.escolar.security.entity.User;
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
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String curso;

    @ManyToOne(targetEntity = Anio.class)
    private Anio anio;

    @ManyToMany(mappedBy = "cursos")
    private List<Mensaje> mensajes;

    @ManyToMany(mappedBy = "cursos")
    private List<User> users;

}
