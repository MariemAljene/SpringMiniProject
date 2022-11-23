package com.example.springfirstproject.repository;

import com.example.springfirstproject.entity.Etudiant;
import com.example.springfirstproject.entity.Niveau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant,Integer> {
    List<Etudiant> findBydepartementIdDepart(Integer idDepart);
 //List<Etudiant> findByEquipeNiveau(Niveau niveau);

    //public  Etudiant findByNomEAndPrenomE(String nom)



}
