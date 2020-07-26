package de.dugurlu.brewery.service;

import de.dugurlu.brewery.model.Beer;
import de.dugurlu.brewery.model.BeerDto;
import de.dugurlu.brewery.model.mapper.BeerMapper;
import de.dugurlu.brewery.repositories.BeerRepository;
import java.util.UUID;
import org.springframework.stereotype.Service;


@Service
public class BeerServiceImpl implements BeerService {

  private final BeerRepository repository;
  private final BeerMapper mapper;

  public BeerServiceImpl(BeerRepository repository,
      BeerMapper mapper) {
    this.repository = repository;
    this.mapper = mapper;
  }

  @Override
  public BeerDto getById(UUID id) {
    return mapper.toBeerDto(repository.findById(id).orElseThrow(NotFoundException::new));
  }


  @Override
  public BeerDto create(BeerDto beer) {
    return mapper.toBeerDto(repository.save(mapper.toBeer(beer)));
  }


  @Override
  public BeerDto update(UUID id, BeerDto beerDto) {
    Beer beer = repository.findById(id).orElseThrow(NotFoundException::new);
    beer.setName(beerDto.getName());
    beer.setStyle(beerDto.getStyle());
    beer.setPrice(beerDto.getPrice());
    beer.setUpc(beerDto.getUpc());
    return mapper.toBeerDto(repository.save(beer));

  }


  @Override
  public void delete(UUID id) {
    repository.deleteById(id);
  }
}
