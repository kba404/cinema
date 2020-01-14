/**
 * 
 */
package com.kba.cinema.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @author user
 *
 */
@Entity
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomClient;
	private double prix;
	@Column(unique = true, nullable = true)
	private Integer codePayement;
	private boolean reserve;
	@ManyToOne
	private Place place;
	@ManyToOne
	private Projection projection;

	/**
	 * 
	 */
	public Ticket() {
		super();
	}

	/**
	 * @param id
	 * @param nomClient
	 * @param prix
	 * @param codePayement
	 * @param reserve
	 * @param place
	 * @param projection
	 */
	public Ticket(Long id, String nomClient, double prix, int codePayement, boolean reserve, Place place,
			Projection projection) {
		super();
		this.id = id;
		this.nomClient = nomClient;
		this.prix = prix;
		this.codePayement = codePayement;
		this.reserve = reserve;
		this.place = place;
		this.projection = projection;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomClient() {
		return nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getCodePayement() {
		return codePayement;
	}

	public void setCodePayement(int codePayement) {
		this.codePayement = codePayement;
	}

	public boolean isReserve() {
		return reserve;
	}

	public void setReserve(boolean reserve) {
		this.reserve = reserve;
	}

	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

	public Projection getProjection() {
		return projection;
	}

	public void setProjection(Projection projection) {
		this.projection = projection;
	}

}
