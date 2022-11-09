package com.example.springfirstproject.Service;

import com.example.springfirstproject.AService.IUniversiteService;
import com.example.springfirstproject.entity.Departement;
import com.example.springfirstproject.entity.Etudiant;
import com.example.springfirstproject.entity.Universite;
import com.example.springfirstproject.repository.DepartementRepository;
import com.example.springfirstproject.repository.EtudiantRepository;
import com.example.springfirstproject.repository.UniversiteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
public class UniversiteServiceImp implements IUniversiteService {
    @Autowired
   UniversiteRepository universiteRepository;
    DepartementRepository departementRepository;
    @Override
    public List<Universite> retrieveAllUniversites() {
            List<Universite> U =universiteRepository.findAll();
        for(Universite universite: U)
        {
            log.info("Universite"+universite.toString());
        }
        return U;
    }

    @Override
    public Universite addUniversite(Universite u) {
         return universiteRepository.save(u);
    }

    @Override
    public Universite updateUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public Universite retrieveUniversite(Integer idUniversite) {
        return  universiteRepository.findById(idUniversite).get();
    }

    @Override
    public void removeUniversite(Integer idUniversite) {
        universiteRepository.deleteById(idUniversite);
    }
    @Override
    public void assignUniversiteToDepartement(Integer idUniversite, Integer idDepartement) {
        Universite u =universiteRepository.findById(idUniversite).orElse(null)  ;
        Departement d = departementRepository.findById(idDepartement).orElse(null);
        u.getDepartement().add(d);
        universiteRepository.save(u);
    }

}
