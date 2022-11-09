package com.example.springfirstproject.repository;

import com.example.springfirstproject.entity.DetailEquipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailEquipeRepository  extends JpaRepository<DetailEquipe,Integer> {
}
