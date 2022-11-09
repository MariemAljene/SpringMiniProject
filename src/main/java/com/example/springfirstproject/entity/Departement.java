package com.example.springfirstproject.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class Departement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idD",nullable = false)
    private Integer idDepart; // Clé primaire
    private String nomDepart;
    @OneToMany (cascade = CascadeType.ALL ,mappedBy ="departement")
    private Set<Etudiant> Etudiants;

}
