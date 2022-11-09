package com.example.springfirstproject.AService;

import com.example.springfirstproject.entity.Contrat;
import com.example.springfirstproject.entity.Departement;

import java.util.List;

public interface IDepartementService {
    List<Departement> retrieveAllDepartements();

    Departement addDepartement (Departement d);

    Departement updateDepartement (Departement d);

    Departement retrieveDepartement (int intDepartement);
    void removeDepartement(Integer idDepartement);
}
