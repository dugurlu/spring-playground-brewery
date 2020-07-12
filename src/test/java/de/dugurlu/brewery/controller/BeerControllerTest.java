package de.dugurlu.brewery.controller;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.dugurlu.brewery.model.BeerDto;
import de.dugurlu.brewery.model.BeerStyle;
import de.dugurlu.brewery.service.BeerService;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


@WebMvcTest(BeerController.class)
class BeerControllerTest {

  @MockBean
  BeerService beerService;

  @Autowired
  MockMvc mockMvc;

  @Autowired
  ObjectMapper mapper;

  @Test
  void get() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/beer/" + UUID.randomUUID().toString())
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
  }


  @Test
  void create() throws Exception {
    when(beerService.create(isA(BeerDto.class)))
        .thenReturn(BeerDto.builder().id(UUID.randomUUID()).build());
    BeerDto beer = BeerDto.builder()
        .name("BeerName")
        .style(BeerStyle.LAGER)
        .build();
    mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/beer/")
        .contentType(MediaType.APPLICATION_JSON)
        .content(mapper.writeValueAsString(beer)))
        .andExpect(status().isCreated());
  }


  @Test
  void update() throws Exception {
    BeerDto beer = BeerDto.builder().id(UUID.randomUUID()).build();
    mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/beer/" + beer.getId().toString())
        .contentType(MediaType.APPLICATION_JSON)
        .content(mapper.writeValueAsString(beer)))
        .andExpect(status().isNoContent());
  }


  @Test
  void delete() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/beer/" + UUID.randomUUID().toString()))
        .andExpect(status().isNoContent());
  }
}
