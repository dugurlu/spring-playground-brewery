package de.dugurlu.brewery.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.OffsetDateTime;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

@JsonTest
public class BaseTest {
  @Autowired
  ObjectMapper mapper;

  BeerDto getBeerDto() {
    OffsetDateTime dateTime = OffsetDateTime.now();
    return BeerDto.builder()
        .name("BeerName")
        .style(BeerStyle.LAGER)
        .id(UUID.randomUUID())
        .created(dateTime)
        .modified(dateTime)
        .price(1299L)
        .upc(123123123123L)
        .build();
  }

}
