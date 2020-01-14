package com.kba.cinema.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kba.cinema.dao.CategorieRepository;
import com.kba.cinema.dao.CinemaRepository;
import com.kba.cinema.dao.FilmRepository;
import com.kba.cinema.dao.PlaceRepository;
import com.kba.cinema.dao.ProjectionRepository;
import com.kba.cinema.dao.SalleRepository;
import com.kba.cinema.dao.SeanceRepository;
import com.kba.cinema.dao.TicketRepository;
import com.kba.cinema.dao.VilleRepository;
import com.kba.cinema.entities.Categorie;
import com.kba.cinema.entities.Cinema;
import com.kba.cinema.entities.Film;
import com.kba.cinema.entities.Place;
import com.kba.cinema.entities.Projection;
import com.kba.cinema.entities.Salle;
import com.kba.cinema.entities.Seance;
import com.kba.cinema.entities.Ticket;
import com.kba.cinema.entities.Ville;

@Service
@Transactional
public class CinemaInitServiceImpl implements ICinemaInitService {
	@Autowired
	private VilleRepository villeRepository;
	@Autowired
	private CinemaRepository cinemaRepository;
	@Autowired
	private SalleRepository salleRepository;
	@Autowired
	private PlaceRepository placeRepository;
	@Autowired
	private SeanceRepository seanceRepository;
	@Autowired
	private CategorieRepository categorieRepository;
	@Autowired
	private FilmRepository filmRepository;
	@Autowired
	private ProjectionRepository projectionRepository;
	@Autowired
	private TicketRepository ticketRepository;

	@Override
	public void initVilles() {
		Stream.of("Nouakchott", "Nouadhibou", "Keidi", "kifa").forEach(nomVille -> {
			Ville ville = new Ville();
			ville.setName(nomVille);
			villeRepository.save(ville);
		});

	}

	@Override
	public void initCinemas() {
		villeRepository.findAll().forEach(v -> {
			Stream.of("MAURICINE", "CINEMAX", "CINEHAPPY", "VISION").forEach(nomCinema -> {
				Cinema cinema = new Cinema();
				cinema.setName(nomCinema);
				cinema.setNombreSalles(3 + (int) (Math.random() * 7));
				cinema.setVille(v);
				cinemaRepository.save(cinema);
			});
		});

	}

	@Override
	public void initSalles() {
		cinemaRepository.findAll().forEach(cinema -> {
			for (int i = 0; i < cinema.getNombreSalles(); i++) {
				Salle salle = new Salle();
				salle.setName("Salle" + (i + 1));
				salle.setCinema(cinema);
				salle.setNombrePlace(10 + (int) (Math.random() * 20));
				salleRepository.save(salle);
			}
		});
	}

	@Override
	public void initPlaces() {
		salleRepository.findAll().forEach(salle -> {
			for (int i = 0; i < salle.getNombrePlace(); i++) {
				Place place = new Place();
				place.setNumero(i + 1);
				place.setSalle(salle);
				placeRepository.save(place);
			}
		});
	}

	@Override
	public void initSeances() {
		DateFormat dateFormat = new SimpleDateFormat("HH:mm");
		Stream.of("11:00", "15:15", "17:30", "20:00").forEach(s -> {
			Seance seance = new Seance();
			try {
				seance.setHeureDebut(dateFormat.parse(s));
				seanceRepository.save(seance);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		});
	}

	@Override
	public void initCategories() {
		Stream.of("Actions", "Aventures", "Comédies", "Policiers").forEach(cat -> {
			Categorie categorie = new Categorie();
			categorie.setNom(cat);
			categorieRepository.save(categorie);
		});
	}

	@Override
	public void initFilms() {
		double[] durees = new double[] { 1, 1.5, 2, 2.5, 3 };
		List<Categorie> categories = categorieRepository.findAll();
		Stream.of("Equalizer", "Jumanji", "Inséparables").forEach(titreFilm -> {
			Film film = new Film();
			film.setTitre(titreFilm);
			film.setDuree(durees[new Random().nextInt(durees.length)]);
			film.setAfiche(titreFilm.replace(" ", ""));
			film.setCategorie(categories.get(new Random().nextInt(categories.size())));
			filmRepository.save(film);

		});
	}

	@Override
	public void initProjections() {
		double[] listPrix = new double[] { 10, 12, 15, 18, 20 };
		villeRepository.findAll().forEach(ville -> {
			ville.getCinema().forEach(cinema -> {
				cinema.getSalles().forEach(salle -> {
					filmRepository.findAll().forEach(film -> {
						seanceRepository.findAll().forEach(seance -> {
							Projection projection = new Projection();
							projection.setDateProjection(new Date());
							projection.setFilm(film);
							projection.setPrix(listPrix[new Random().nextInt(listPrix.length)]);
							projection.setSalle(salle);
							projection.setSeance(seance);
							projectionRepository.save(projection);
						});
					});
				});

			});
		});
	}

	@Override
	public void initTickets() {
		projectionRepository.findAll().forEach(p -> {
			p.getSalle().getPlaces().forEach(place -> {
				Ticket ticket = new Ticket();
				ticket.setPlace(place);
				ticket.setPrix(p.getPrix());
				ticket.setProjection(p);
				ticket.setReserve(false);
				ticketRepository.save(ticket);
			});
		});

	}

}
