package com.example.springfirstproject.repository;

import com.example.springfirstproject.entity.Departement;
import com.example.springfirstproject.entity.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartementRepository  extends JpaRepository<Departement,Integer> {
}
