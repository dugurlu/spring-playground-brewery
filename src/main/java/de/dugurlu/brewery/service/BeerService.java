package de.dugurlu.brewery.service;

import de.dugurlu.brewery.model.Beer;

import java.util.UUID;


public interface BeerService {
	Beer getById(UUID id);

	Beer create(Beer beer);

	void update(UUID id, Beer beer);

	void delete(UUID id);
}
