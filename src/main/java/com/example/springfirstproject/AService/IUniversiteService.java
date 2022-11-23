package com.example.springfirstproject.AService;

import com.example.springfirstproject.entity.Departement;
import com.example.springfirstproject.entity.Universite;

import java.util.List;

public interface IUniversiteService {
    List<Universite> retrieveAllUniversites();
    Universite addUniversite (Universite u);
    Universite updateUniversite (Universite u);
    Universite retrieveUniversite (Integer idUniversite);
    void removeUniversite(Integer idUniversite);
    void assignUniversiteToDepartement(Integer idUniversite, Integer
            idDepartement);
    List<Departement> retrieveDepartementsByUniversite(Integer idUniversite);
}
