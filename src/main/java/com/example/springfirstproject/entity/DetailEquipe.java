package com.example.springfirstproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class DetailEquipe  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idDE",nullable = false)
    private Integer idDetailEquipe; // Clé primaire
    private Integer Salle ;
    private String thematique;
@JsonIgnore
@ToString.Exclude
   @OneToOne(mappedBy = "DetailEquipe")
    private Equipe Equipe;

}
