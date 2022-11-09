package com.example.springfirstproject.Service;

import com.example.springfirstproject.AService.IDepartementService;
import com.example.springfirstproject.entity.Departement;
import com.example.springfirstproject.entity.Universite;
import com.example.springfirstproject.repository.DepartementRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
public class DepartementServiceImp implements IDepartementService {
    @Autowired
    DepartementRepository departementRepository;
    @Override
    public List<Departement> retrieveAllDepartements() {
       List<Departement> D= departementRepository.findAll();
        for(Departement d: D)
        {
            log.info("Departement"+D.toString());
        }
        return D;
    }

    @Override
    public Departement addDepartement(Departement d) {
        return departementRepository.save(d);
    }

    @Override
    public Departement updateDepartement(Departement d) {
        return departementRepository.save(d);
    }

    @Override
    public Departement retrieveDepartement(int intDepartement) {
        return departementRepository.findById(intDepartement).get();

    }

    @Override
    public void removeDepartement(Integer idDepartement) {
         departementRepository.deleteById(idDepartement);

    }

}
