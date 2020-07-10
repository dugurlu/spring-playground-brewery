package de.dugurlu.brewery.controller;

import de.dugurlu.brewery.model.Customer;
import de.dugurlu.brewery.service.CustomerService;
import de.dugurlu.brewery.service.CustomerServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;



@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

	private final CustomerService customerService;


	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}


	@GetMapping("/{id}")
	public ResponseEntity<Customer> getById(@PathVariable UUID id) {
		return new ResponseEntity<Customer>(customerService.getById(id), HttpStatus.OK);
	}
}
