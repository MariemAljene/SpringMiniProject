package com.example.springfirstproject.repository;

import com.example.springfirstproject.entity.Contrat;
import com.example.springfirstproject.entity.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContratRepository  extends JpaRepository<Contrat,Integer> {
}
