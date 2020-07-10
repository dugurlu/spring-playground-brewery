package de.dugurlu.brewery.controller;

import de.dugurlu.brewery.model.Beer;
import de.dugurlu.brewery.service.BeerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
		return new ResponseEntity<Beer>(beerService.getBeerById(id), HttpStatus.OK);
	}

}
