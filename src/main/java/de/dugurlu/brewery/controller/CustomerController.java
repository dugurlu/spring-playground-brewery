package de.dugurlu.brewery.controller;

import de.dugurlu.brewery.model.Beer;
import de.dugurlu.brewery.model.Customer;
import de.dugurlu.brewery.service.CustomerService;
import de.dugurlu.brewery.service.CustomerServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

import java.util.UUID;



@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

	private final CustomerService customerService;


	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}


	@GetMapping("/{id}")
	public ResponseEntity<Customer> get(@PathVariable UUID id) {
		return new ResponseEntity<>(customerService.getById(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<?> create(@RequestBody Customer customer) {
		Customer createdCustomer = customerService.create(customer);
		UriComponents uriComponents = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(createdCustomer.getId());
		return ResponseEntity.created(uriComponents.toUri()).build();
	}

	@PutMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void update(@PathVariable UUID id, @RequestBody Customer customer) {
		customerService.update(id, customer);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable UUID id) {
		customerService.delete(id);
	}
}
