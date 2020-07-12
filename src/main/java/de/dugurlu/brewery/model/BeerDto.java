package de.dugurlu.brewery.model;

import java.time.OffsetDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDto {

  private UUID id;
  private OffsetDateTime created;
  private OffsetDateTime modified;

  private String name;
  private BeerStyle style;
  private Long upc;
  private Long price;
  private Integer quantity;

}
