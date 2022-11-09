package com.example.springfirstproject.repository;

import com.example.springfirstproject.entity.Etudiant;
import com.example.springfirstproject.entity.Universite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversiteRepository   extends JpaRepository<Universite,Integer> {
}
