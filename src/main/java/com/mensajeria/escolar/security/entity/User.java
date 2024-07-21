package com.mensajeria.escolar.security.entity;

import com.mensajeria.escolar.entity.Curso;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = "email")})
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "last_name")
    private String lastName;
    private String email;
    private String phone;
    private String password;
    private Long school_id;
    private String charge;

    @Enumerated(EnumType.STRING)
    private RoleName role;

    @ManyToMany(cascade= CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_course", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id")
    )
    private List<Curso> cursos;

    /**
     * Obtiene la colección de autoridades (roles) del usuario.
     *
     * @return Colección de autoridades del usuario.
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority((role.name())));
    }

    /**
     * Obtiene el nombre de usuario del usuario.
     *
     * @return Nombre de usuario (correo electrónico) del usuario.
     */
    @Override
    public String getUsername() {
        return email;
    }

    //Se podria omitir ya que el atributo se llama password y por lombbok tenemos el getPassword()
    /**
     * Obtiene la contraseña del usuario.
     *
     * @return Contraseña del usuario.
     */
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
