package de.dugurlu.brewery.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

@JsonTest
class BeerDtoTest extends BaseTest {

  @Test
  void testSerialization() throws JsonProcessingException {
    BeerDto beerDto = getBeerDto();
    String jsonString = mapper.writeValueAsString(beerDto);
    System.out.println(jsonString);
  }

  @SneakyThrows
  @Test
  void testDeserialization()  {
    String json = "{\"id\":\"1f14874e-20d3-4144-b68c-8e333745aeff\",\"created\":\"2020-07-26T15:02:45.0291635+02:00\",\"modified\":\"2020-07-26T15:02:45.0291635+02:00\",\"name\":\"BeerName\",\"style\":\"LAGER\",\"upc\":123123123123,\"price\":1299,\"quantity\":null}";
    BeerDto beer = mapper.readValue(json, BeerDto.class);
    System.out.println(beer);
  }

}
