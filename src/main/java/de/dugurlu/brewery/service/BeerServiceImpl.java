package de.dugurlu.brewery.service;

import de.dugurlu.brewery.model.BeerDto;
import de.dugurlu.brewery.model.BeerStyle;
import java.util.UUID;
import org.springframework.stereotype.Service;


@Service
public class BeerServiceImpl implements BeerService {

  @Override
  public BeerDto getById(UUID id) {
    return BeerDto.builder()
        .id(UUID.randomUUID())
        .name("Augustiner Hell")
        .style(BeerStyle.LAGER)
        .build();
  }


  @Override
  public BeerDto create(BeerDto beer) {
    return BeerDto.builder()
        .id(UUID.randomUUID())
        .build();
  }


  @Override
  public void update(UUID id, BeerDto beer) {

  }


  @Override
  public void delete(UUID id) {

  }
}
