package com.example.springfirstproject.repository;

import com.example.springfirstproject.entity.Equipe;
import com.example.springfirstproject.entity.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipeRepository   extends JpaRepository<Equipe,Integer> {
}
