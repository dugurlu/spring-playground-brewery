package de.dugurlu.brewery.controller;

import de.dugurlu.brewery.model.BeerDto;
import de.dugurlu.brewery.service.BeerService;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;


@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {

  private final BeerService beerService;


  public BeerController(BeerService beerService) {
    this.beerService = beerService;
  }


  @GetMapping("/{id}")
  public ResponseEntity<BeerDto> get(@PathVariable UUID id) {
    return new ResponseEntity<>(beerService.getById(id), HttpStatus.OK);
  }


  @PostMapping
  public ResponseEntity<?> create(@RequestBody BeerDto beer) {
    BeerDto createdBeer = beerService.create(beer);
    UriComponents uriComponents = ServletUriComponentsBuilder.fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(createdBeer.getId());
    return ResponseEntity.created(uriComponents.toUri()).build();
  }

  @PutMapping("/{id}")
  @ResponseStatus(code = HttpStatus.NO_CONTENT)
  public void update(@PathVariable UUID id, @RequestBody BeerDto beer) {
    beerService.update(id, beer);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(code = HttpStatus.NO_CONTENT)
  public void delete(@PathVariable UUID id) {
    beerService.delete(id);
  }
}
