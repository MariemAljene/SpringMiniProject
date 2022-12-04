package com.example.springfirstproject.AService;

import com.example.springfirstproject.entity.Equipe;

import java.util.List;

public interface IEquipeService {
    List<Equipe> retrieveAllEquipes();

    Equipe addEquipe(Equipe e); // ajouter l’équipe avec son détail

    Equipe updateEquipe (Equipe e);

    Equipe retrieveEquipe (Integer idEquipe);
    void removeDepartement(Integer idDepartement);
    void faireEvoluerEquipes();

}
