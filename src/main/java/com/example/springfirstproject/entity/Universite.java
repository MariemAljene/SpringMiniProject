package com.example.springfirstproject.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor

@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Universite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idU",nullable = false)
    private Integer idUniv; // Clé primaire
    private String nomUniv ;
    @OneToMany(cascade = CascadeType.ALL )
    private Set<Departement> Departement ;
}
