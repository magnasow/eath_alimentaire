package com.eath.entite;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "role")
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @ManyToMany(mappedBy = "roles")
    @JsonIgnore
    private Set<Administrateur> administrateurs = new HashSet<>();

    @ManyToMany(mappedBy = "roles")
    @JsonIgnore
    private Set<Utilisateurs> utilisateurs = new HashSet<>();

    @Override
    public String getAuthority() {
        return "ROLE_" + name;
    }
}
