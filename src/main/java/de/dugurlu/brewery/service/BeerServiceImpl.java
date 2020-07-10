package de.dugurlu.brewery.service;

import de.dugurlu.brewery.model.Beer;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class BeerServiceImpl implements BeerService {
	@Override public Beer getById(UUID id) {
		return Beer.builder()
				.id(UUID.randomUUID())
				.name("Augustiner Hell")
				.style("Lager Hell")
				.build();
	}
}
