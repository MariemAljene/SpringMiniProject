package com.example.springfirstproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor

@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Etudiant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idE",nullable = false)
    private Integer idEtudiant; // Clé primaire
    private String prenomE;
    private String nomE;
    @Enumerated(EnumType.STRING)
    private Option Option;
    @OneToMany (cascade = CascadeType.ALL ,mappedBy = "Etudiant")
    private Set<Contrat> Contrats ;
    @JsonIgnore
    @ManyToOne
   Departement departement;

    @ManyToMany (cascade = CascadeType.ALL)
    private  Set<Equipe> Equipe ;
}
