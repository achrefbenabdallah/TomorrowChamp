package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Scout;


public interface ScoutRepository extends JpaRepository<Scout, Long>{

}
