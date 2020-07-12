package de.dugurlu.brewery.bootstrap;

import de.dugurlu.brewery.model.Beer;
import de.dugurlu.brewery.repositories.BeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BeerLoader implements CommandLineRunner {

  private final BeerRepository repository;


  public BeerLoader(BeerRepository repository) {
    this.repository = repository;
  }


  @Override
  public void run(String... args) throws Exception {
    loadBeerObjects();
  }

  private void loadBeerObjects() {
    if (repository.count() == 0) {
      repository.save(Beer.builder()
          .name("Mango Bobs")
          .style("LAGER")
          .toBrew(200)
          .upc(33701000001L)
          .price(1295L)
          .build());
    }
  }
}
