package com.example.springfirstproject.AService;

import com.example.springfirstproject.entity.Contrat;
import com.example.springfirstproject.entity.Etudiant;

import java.util.Date;
import java.util.List;

public interface IContratService {
    List<Contrat> retrieveAllContrats();

    Contrat updateContrat (Contrat ce);

    Contrat addContrat (Contrat ce);

    Contrat retrieveContrat (Integer idContrat);

    void removeContrat(Integer idContrat);
    Contrat affectContratToEtudiant (Integer idContrat,String nomE,String prenomE);
    Integer nbContratsValides(Date startDate, Date endDate);
    float getMontantContartEntreDeuxDate(int idUniv,Date startDate, Date enddate);
    void retrieveAndUpdateStatusContrat();

    }
