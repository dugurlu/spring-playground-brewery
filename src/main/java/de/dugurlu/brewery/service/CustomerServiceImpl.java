package de.dugurlu.brewery.service;

import de.dugurlu.brewery.model.Customer;
import org.springframework.stereotype.Service;

import java.util.UUID;



@Service
public class CustomerServiceImpl implements CustomerService {
	@Override public Customer getById(UUID id) {
		return Customer.builder()
				.id(UUID.randomUUID())
				.name("The King")
				.build();
	}


	@Override public Customer create(Customer customer) {
		return Customer.builder()
				.id(UUID.randomUUID())
				.name("Jon Doe")
				.build();
	}


	@Override public void update(UUID id, Customer customer) {

	}


	@Override public void delete(UUID id) {

	}
}
