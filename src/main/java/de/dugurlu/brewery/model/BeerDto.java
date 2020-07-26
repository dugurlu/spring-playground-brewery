package de.dugurlu.brewery.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import java.time.OffsetDateTime;
import java.util.UUID;
import javax.validation.constraints.NotBlank;
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
  @Null
  private OffsetDateTime created;
  @Null
  private OffsetDateTime modified;

  @NotBlank
  private String name;
  @NotNull
  private BeerStyle style;
  @NotNull
  private String upc;
  @NotNull
  @Positive
  @JsonFormat(shape = Shape.STRING)
  private Long price;
  private Integer quantity;

}
