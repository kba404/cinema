package com.kba.cinema.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.kba.cinema.entities.Seance;

@RepositoryRestResource
public interface SeanceRepository extends JpaRepository<Seance, Long> {

}
