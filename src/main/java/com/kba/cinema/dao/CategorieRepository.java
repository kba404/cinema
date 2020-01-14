package com.kba.cinema.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.kba.cinema.entities.Categorie;

@RepositoryRestResource
public interface CategorieRepository extends JpaRepository<Categorie, Long> {

}
