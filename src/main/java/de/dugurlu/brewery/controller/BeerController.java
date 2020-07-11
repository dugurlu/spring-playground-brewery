package de.dugurlu.brewery.controller;

import de.dugurlu.brewery.model.Beer;
import de.dugurlu.brewery.service.BeerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

import java.util.UUID;



@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {

	private final BeerService beerService;


	public BeerController(BeerService beerService) {
		this.beerService = beerService;
	}


	@GetMapping("/{id}")
	public ResponseEntity<Beer> getBeer(@PathVariable UUID id) {
		return new ResponseEntity<>(beerService.getById(id), HttpStatus.OK);
	}


	@PostMapping
	public ResponseEntity<?> create(@RequestBody Beer beer) {
		Beer createdBeer = beerService.create(beer);
		UriComponents uriComponents = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(createdBeer.getId());
		return ResponseEntity.created(uriComponents.toUri()).build();
	}

	@PutMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void update(@PathVariable UUID id, @RequestBody Beer beer) {
		beerService.update(id, beer);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable UUID id) {
		beerService.delete(id);
	}
}
