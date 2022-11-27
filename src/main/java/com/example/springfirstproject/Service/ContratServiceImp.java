package com.example.springfirstproject.Service;

import com.example.springfirstproject.AService.IContratService;
import com.example.springfirstproject.entity.Contrat;
import com.example.springfirstproject.entity.Departement;
import com.example.springfirstproject.entity.Etudiant;
import com.example.springfirstproject.entity.Universite;
import com.example.springfirstproject.repository.ContratRepository;
import com.example.springfirstproject.repository.EtudiantRepository;
import com.example.springfirstproject.repository.UniversiteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Repository
@Slf4j
public class  ContratServiceImp  implements IContratService {
    @Autowired
    ContratRepository contrattRepository;
    EtudiantRepository etudiantRepository;
    UniversiteRepository universiteRepository;
    @Override
    public List<Contrat> retrieveAllContrats() {
        List<Contrat> c= contrattRepository.findAll();
        for(Contrat C: c)
        {
            log.info("Departement"+C.toString());
        }
        return c;
    }

    @Override
    public Contrat updateContrat(Contrat ce) {
        return contrattRepository.save(ce);
    }

    @Override
    public Contrat addContrat(Contrat ce) {
        return contrattRepository.save(ce);
    }

    @Override
    public Contrat retrieveContrat(Integer idContrat) {
        return contrattRepository.findById(idContrat).get();
    }

    @Override
    public void removeContrat(Integer idContrat) {
        contrattRepository.deleteById(idContrat);

    }

    @Override
    public Contrat affectContratToEtudiant(Integer idContrat, String nomE, String prenomE) {
        Contrat ce= contrattRepository.findById(idContrat).orElse(null);
        List <Etudiant> etudiants = etudiantRepository.findAll();
        Etudiant etudiant=null;
        for (Etudiant etudiant1:etudiants)
            if(etudiant1.getNomE().equals(nomE)&&etudiant1.getPrenomE().equals(prenomE)){
                etudiant=etudiant1;
            }
        int nbrContratActifs=0;
        if(etudiant!=null){
            for (Contrat c : etudiant.getContrats()){
                if (c.isArchive()==false) {
                    nbrContratActifs++;
                }
            }
            if(nbrContratActifs<5){
                ce.setEtudiant(etudiant);
            }
        }
        return contrattRepository.save(ce);
    }

    @Override
    public Integer nbContratsValides(Date startDate, Date endDate) {
        List<Contrat> contrats=contrattRepository.findAll();
        int i=0;
        for (Contrat ct:contrats) {
            if (ct.getDateDebutContrat().toString().equals(startDate.toString())
                    &&
                    ct.getDateFinContrat().toString().equals(endDate.toString()))
            {
                i++;
            }
        }
        return i;
    }

    @Override
    public float getMontantContartEntreDeuxDate(int idUniv, Date startDate, Date enddate) {

        List<Contrat> contrats = contrattRepository.findAll();
        long diff = enddate.getTime() - startDate.getTime();
        double chiffreAffaire = 0;
        //double resultat =0 ;
        for (Contrat ct : contrats) {
            if (ct.isArchive() == false) {
                if ((ct.getDateDebutContrat().before(startDate)) && (ct.getDateFinContrat().after(enddate))) {

                    double diffMois = diff / (1000 * 60 * 60 * 24 * 30);
                    double resultat =0 ;
                    switch (ct.getSpecialite()) {
                        case IA:
                            chiffreAffaire =+ diffMois * 300;
                            break;
                        case Reseaux:
                            chiffreAffaire =+ diffMois * 350;
                            break;
                        case Cloud:
                            chiffreAffaire =+ diffMois * 400;
                            break;
                        case Securite:
                            chiffreAffaire =+ diffMois * 450;
                            break;
                    }
                    return (float) chiffreAffaire;
                }
            }
        }
        return (float) chiffreAffaire;
    }


}
