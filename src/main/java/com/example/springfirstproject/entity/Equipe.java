package com.example.springfirstproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor

@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Equipe implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="idEquipe",nullable = false)
    private Integer idEquipe; // Clé primaire
    private String nomEquipe;
    @Enumerated(EnumType.STRING)
    private Niveau niveau;
    @Temporal(TemporalType.DATE)
    private Date dateDebut;
@OneToOne(cascade = CascadeType.ALL)
    private DetailEquipe DetailEquipe ;
@JsonIgnore
@ToString.Exclude
@ManyToMany(mappedBy = "Equipe",cascade = CascadeType.ALL)
    private Set<Etudiant> Etudiant ;


}
