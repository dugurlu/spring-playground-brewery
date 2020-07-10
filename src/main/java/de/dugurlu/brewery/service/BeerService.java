package de.dugurlu.brewery.service;

import de.dugurlu.brewery.model.Beer;

import java.util.UUID;


public interface BeerService {
	Beer getBeerById(UUID id);
}
