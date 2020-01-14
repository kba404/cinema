/**
 * 
 */
package com.kba.cinema.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author user
 *
 */
@Entity
public class Salle implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private int nombrePlace;
	@ManyToOne
	private Cinema cinema;
	@OneToMany(mappedBy = "salle")
	private Collection<Place> places;
	@OneToMany(mappedBy = "salle")
	private Collection<Projection> projections;

	public Salle() {
		super();
	}

	/**
	 * @param id
	 * @param name
	 * @param nombrePlace
	 * @param cinema
	 * @param places
	 * @param projections
	 */
	public Salle(Long id, String name, int nombrePlace, Cinema cinema, Collection<Place> places,
			Collection<Projection> projections) {
		super();
		this.id = id;
		this.name = name;
		this.nombrePlace = nombrePlace;
		this.cinema = cinema;
		this.places = places;
		this.projections = projections;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNombrePlace() {
		return nombrePlace;
	}

	public void setNombrePlace(int nombrePlace) {
		this.nombrePlace = nombrePlace;
	}

	public Cinema getCinema() {
		return cinema;
	}

	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}

	public Collection<Place> getPlaces() {
		return places;
	}

	public void setPlaces(Collection<Place> places) {
		this.places = places;
	}

	public Collection<Projection> getProjections() {
		return projections;
	}

	public void setProjections(Collection<Projection> projections) {
		this.projections = projections;
	}

}
