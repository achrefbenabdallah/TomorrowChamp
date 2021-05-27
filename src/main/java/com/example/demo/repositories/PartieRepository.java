package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Partie;

public interface PartieRepository extends JpaRepository<Partie, Long>{

}
