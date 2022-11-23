package com.example.springfirstproject.AService;

import com.example.springfirstproject.entity.Etudiant;

import java.util.List;

public interface IEtudiantService {
    List<Etudiant> retrieveAllEtudiants();

    Etudiant addEtudiant (Etudiant e);

    Etudiant updateEtudiant (Etudiant e);

    Etudiant retrieveEtudiant(Integer idEtudiant);

    void removeEtudiant(Integer idEtudiant);
    List<Etudiant> findBydepartementIdDepart(Integer idDepart) ;
void assignEtudiantToDepartement (Integer etudiantId, Integer
            departementId);
    Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat,
                                                     Integer idEquipe);




}
