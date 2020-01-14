/**
 * 
 */
package com.kba.cinema.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author user
 *
 */
@Entity
public class Categorie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	@OneToMany(mappedBy = "categorie")
	private Collection<Film> films;

	/**
	 * 
	 */
	public Categorie() {
		super();
	}

	/**
	 * @param id
	 * @param nom
	 * @param films
	 */
	public Categorie(Long id, String nom, Collection<Film> films) {
		super();
		this.id = id;
		this.nom = nom;
		this.films = films;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Collection<Film> getFilms() {
		return films;
	}

	public void setFilms(Collection<Film> films) {
		this.films = films;
	}

}
