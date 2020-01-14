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
import javax.persistence.OneToMany;

/**
 * @author user
 *
 */
@Entity
public class Ville implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private double longitude, latitude, altitude;
	@OneToMany(mappedBy = "ville")
	private Collection<Cinema> cinema;

	public Ville() {
		super();
	}

	/**
	 * @param id
	 * @param name
	 * @param longitude
	 * @param latitude
	 * @param altitude
	 * @param cinema
	 */
	public Ville(Long id, String name, double longitude, double latitude, double altitude, Collection<Cinema> cinema) {
		super();
		this.id = id;
		this.name = name;
		this.longitude = longitude;
		this.latitude = latitude;
		this.altitude = altitude;
		this.cinema = cinema;
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

	public Collection<Cinema> getCinema() {
		return cinema;
	}

	public void setCinema(Collection<Cinema> cinema) {
		this.cinema = cinema;
	}

}
