package de.dugurlu.brewery.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Beer {
	private UUID id;
	private OffsetDateTime created;
	private OffsetDateTime modified;

	private String name;
	private BeerStyle style;
	private Long upc;
	private Long price;
	private Integer quantity;

}
