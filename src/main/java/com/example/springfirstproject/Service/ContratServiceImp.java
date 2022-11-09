package com.example.springfirstproject.Service;

import com.example.springfirstproject.AService.IContratService;
import com.example.springfirstproject.entity.Contrat;
import com.example.springfirstproject.entity.Departement;
import com.example.springfirstproject.repository.ContratRepository;
import com.example.springfirstproject.repository.EtudiantRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Slf4j
public class ContratServiceImp  implements IContratService {
    @Autowired
    ContratRepository contrattRepository;
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
}
