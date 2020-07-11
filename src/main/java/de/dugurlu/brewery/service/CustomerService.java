package de.dugurlu.brewery.service;

import de.dugurlu.brewery.model.Customer;

import java.util.UUID;



public interface CustomerService {
	Customer getById(UUID id);

	Customer create(Customer customer);

	void update(UUID id, Customer customer);

	void delete(UUID id);
}
