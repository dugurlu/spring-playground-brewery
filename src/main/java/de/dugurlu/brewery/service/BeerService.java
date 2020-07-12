package de.dugurlu.brewery.service;

import de.dugurlu.brewery.model.BeerDto;
import java.util.UUID;


public interface BeerService {

  BeerDto getById(UUID id);

  BeerDto create(BeerDto beer);

  void update(UUID id, BeerDto beer);

  void delete(UUID id);
}
