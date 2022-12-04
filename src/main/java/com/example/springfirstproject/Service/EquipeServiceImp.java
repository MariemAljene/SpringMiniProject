package com.example.springfirstproject.Service;

import com.example.springfirstproject.AService.IEquipeService;
import com.example.springfirstproject.AService.IEtudiantService;
import com.example.springfirstproject.entity.*;
import com.example.springfirstproject.repository.ContratRepository;
import com.example.springfirstproject.repository.EquipeRepository;
import com.example.springfirstproject.repository.EtudiantRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class EquipeServiceImp implements IEquipeService {
    @Autowired
    EquipeRepository equipeRepository;
    ContratRepository contratRepository;
    EtudiantRepository etudiantRepository;
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

    @Override
    @Scheduled(cron = "0 0 0 1 1 ?")
    public void faireEvoluerEquipes() {
        List<Equipe> E = retrieveAllEquipes();
        LocalDate localDate = LocalDate.now();
        for (int d = 0; d < E.size(); d++) {
            int c = 0;
            Equipe S = E.get(d);
            List<Etudiant> et = etudiantRepository.findAll();
            for (int j = 0; d < E.size(); j++) {
                Etudiant t = et.get(j);
                List<Contrat> ct =  contratRepository.findAll();
                for (int k = 0; d < ct.size(); k++) {
                    Contrat cc = ct.get(k);

                    long diff = localDate.getDayOfMonth() - cc.getDateFinContrat().getTime();
                    long diffs = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
                    if (diffs >= 0) {
                        c++;
                    }
                }
                if (c > 3) {

                    if (S.getNiveau() == Niveau.Senior) {
                        S.setNiveau(Niveau.Expert);
                    }
                    if (S.getNiveau() == Niveau.Junior) {
                        S.setNiveau(Niveau.Senior);
                    }
                }
            }
        }
    }


}
