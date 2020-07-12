package de.dugurlu.brewery.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.dugurlu.brewery.model.Customer;
import de.dugurlu.brewery.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@WebMvcTest(CustomerController.class)
class CustomerControllerTest {

	@Autowired MockMvc mockMvc;

	@Autowired ObjectMapper mapper;

	@MockBean CustomerService customerService;

	@Test
	void get() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/customer/" + UUID.randomUUID().toString()).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}


	@Test
	void create() throws Exception {
		when(customerService.create(isA(Customer.class))).thenReturn(Customer.builder().id(UUID.randomUUID()).build());
		Customer customer = Customer.builder().id(UUID.randomUUID()).build();
		mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/customer/")
				.contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(customer)))
				.andExpect(status().isCreated());
	}


	@Test
	void update() throws Exception {
		Customer customer = Customer.builder().id(UUID.randomUUID()).build();
		mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/customer/" + customer.getId().toString())
				.contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(customer)))
				.andExpect(status().isNoContent());
	}


	@Test
	void delete() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/customer/" + UUID.randomUUID().toString()))
				.andExpect(status().isNoContent());
	}

}
