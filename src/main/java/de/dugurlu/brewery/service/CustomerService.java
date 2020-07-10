package de.dugurlu.brewery.service;

import de.dugurlu.brewery.model.Customer;

import java.util.UUID;



public interface CustomerService {
	Customer getById(UUID id);
}
