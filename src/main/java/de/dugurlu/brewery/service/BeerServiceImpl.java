package de.dugurlu.brewery.service;

import de.dugurlu.brewery.model.Beer;
import de.dugurlu.brewery.model.BeerStyle;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class BeerServiceImpl implements BeerService {
	@Override public Beer getById(UUID id) {
		return Beer.builder()
				.id(UUID.randomUUID())
				.name("Augustiner Hell")
				.style(BeerStyle.LAGER)
				.build();
	}


	@Override public Beer create(Beer beer) {
		return Beer.builder()
				.id(UUID.randomUUID())
				.build();
	}


	@Override public void update(UUID id, Beer beer) {

	}


	@Override public void delete(UUID id) {

	}
}
