package de.dugurlu.brewery.controller;

import de.dugurlu.brewery.model.Customer;
import de.dugurlu.brewery.service.CustomerService;
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
