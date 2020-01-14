/**
 * 
 */
package com.kba.cinema.entities;

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
public class Place {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int numero;
	private double longitude, latitude, altitude;
	@ManyToOne
	private Salle salle;

	/**
	 * 
	 */
	public Place() {
		super();
	}

	/**
	 * @param id
	 * @param numero
	 * @param longitude
	 * @param latitude
	 * @param altitude
	 * @param salle
	 */
	public Place(Long id, int numero, double longitude, double latitude, double altitude, Salle salle) {
		super();
		this.id = id;
		this.numero = numero;
		this.longitude = longitude;
		this.latitude = latitude;
		this.altitude = altitude;
		this.salle = salle;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getAltitude() {
		return altitude;
	}

	public void setAltitude(double altitude) {
		this.altitude = altitude;
	}

	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}

}
