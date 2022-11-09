package com.example.springfirstproject.Service;

import com.example.springfirstproject.AService.IEquipeService;
import com.example.springfirstproject.AService.IEtudiantService;
import com.example.springfirstproject.entity.Equipe;
import com.example.springfirstproject.entity.Universite;
import com.example.springfirstproject.repository.EquipeRepository;
import com.example.springfirstproject.repository.EtudiantRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
public class EquipeServiceImp implements IEquipeService {
    @Autowired
    EquipeRepository equipeRepository;
    @Override
    public List<Equipe> retrieveAllEquipes() {
        List<Equipe> E =equipeRepository.findAll();
        for(Equipe e:E)
        {
            log.info("Equipe"+e.toString());
        }
        return E;
    }

    @Override
    public Equipe addEquipe(Equipe e) {

        return equipeRepository.save(e);
    }

    @Override
    public Equipe updateEquipe(Equipe e) {

        return equipeRepository.save(e);
    }

    @Override
    public Equipe retrieveEquipe(Integer idEquipe) {
        return equipeRepository.findById(idEquipe).get();
    }

    @Override
    public void removeDepartement(Integer idDepartement) {
        equipeRepository.deleteById(idDepartement);
    }

}
