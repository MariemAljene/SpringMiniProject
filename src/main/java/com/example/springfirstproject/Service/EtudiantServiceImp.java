package com.example.springfirstproject.Service;

import com.example.springfirstproject.AService.IEtudiantService;
import com.example.springfirstproject.entity.*;
import com.example.springfirstproject.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EtudiantServiceImp implements IEtudiantService {
    @Autowired
    EtudiantRepository etudiantRepository;
    DepartementRepository departementRepository ;
    ContratRepository contratRepository ;
   EquipeRepository equipeRepository ;


    @Override
    public List<Etudiant> retrieveAllEtudiants() {
        List<Etudiant> etudiants =etudiantRepository.findAll();
       for(Etudiant e: etudiants)
       {
           log.info("Etudiant"+e.toString());
       }
       return etudiants;
    }

    @Override
    public Etudiant addEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }

    @Override
    public Etudiant retrieveEtudiant(Integer idEtudiant) {
       return  etudiantRepository.findById(idEtudiant).get();
    }

    @Override
    public void removeEtudiant(Integer idEtudiant) {
        etudiantRepository.deleteById(idEtudiant);

    }

    @Override
    public List<Etudiant> findBydepartementIdDepart(Integer idDepart) {
     return  etudiantRepository.findBydepartementIdDepart(idDepart) ;
    }

    @Override
    public void assignEtudiantToDepartement(Integer etudiantId, Integer departementId) {
      Etudiant etudiant =etudiantRepository.findById(etudiantId).orElse(null)  ;
        Departement departement = departementRepository.findById(departementId).orElse(null);
        etudiant.setDepartement(departement);
        etudiantRepository.save(etudiant);
    }

    @Override
    public Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat, Integer idEquipe) {
        Contrat c =contratRepository.findById(idContrat).orElse(null)  ;
        Equipe equipe = equipeRepository.findById(idEquipe).orElse(null);
        c.setEtudiant(e);
        equipe.getEtudiant().add(e);
        etudiantRepository.save(e);
        return e ;


    }


}
