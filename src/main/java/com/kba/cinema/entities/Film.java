/**
 * 
 */
package com.kba.cinema.entities;

import java.util.Collection;
import java.util.Date;

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
public class Film {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titre;
	private String description;
	private String realisateur;
	private Date dateSortie;
	private Double duree;
	private String afiche;
	@OneToMany(mappedBy = "film")
	private Collection<Projection> projections;
	@ManyToOne
	private Categorie categorie;

	/**
	 * 
	 */
	public Film() {
		super();
	}

	public Film(Long id, String titre, String description, String realisateur, Date dateSortie, Double duree,
			String afiche, Collection<Projection> projections, Categorie categorie) {
		super();
		this.id = id;
		this.titre = titre;
		this.description = description;
		this.realisateur = realisateur;
		this.dateSortie = dateSortie;
		this.duree = duree;
		this.afiche = afiche;
		this.projections = projections;
		this.categorie = categorie;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRealisateur() {
		return realisateur;
	}

	public void setRealisateur(String realisateur) {
		this.realisateur = realisateur;
	}

	public Date getDateSortie() {
		return dateSortie;
	}

	public void setDateSortie(Date dateSortie) {
		this.dateSortie = dateSortie;
	}

	public Double getDuree() {
		return duree;
	}

	public void setDuree(Double duree) {
		this.duree = duree;
	}

	public String getAfiche() {
		return afiche;
	}

	public void setAfiche(String afiche) {
		this.afiche = afiche;
	}

	public Collection<Projection> getProjections() {
		return projections;
	}

	public void setProjections(Collection<Projection> projections) {
		this.projections = projections;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

}
