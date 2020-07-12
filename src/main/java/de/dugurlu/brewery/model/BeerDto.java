package de.dugurlu.brewery.model;

import java.time.OffsetDateTime;
import java.util.UUID;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDto {

  @Null
  private UUID id;
  private OffsetDateTime created;
  private OffsetDateTime modified;

  @NotBlank
  private String name;
  @NotNull
  private BeerStyle style;
  @Positive
  private Long upc;
  private Long price;
  private Integer quantity;

}
