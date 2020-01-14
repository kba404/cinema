package com.kba.cinema.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.kba.cinema.entities.Projection;

@RepositoryRestResource
public interface ProjectionRepository extends JpaRepository<Projection, Long> {

}
