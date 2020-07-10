package de.dugurlu.brewery.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

import java.util.UUID;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Log4j
public class Customer {
	private UUID id;
	private String name;
}
