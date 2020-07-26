package de.dugurlu.brewery.controller;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.restdocs.request.RequestDocumentation.requestParameters;
import static org.springframework.restdocs.snippet.Attributes.key;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.dugurlu.brewery.model.Beer;
import de.dugurlu.brewery.model.BeerDto;
import de.dugurlu.brewery.model.BeerStyle;
import de.dugurlu.brewery.service.BeerService;
import java.time.OffsetDateTime;
import java.util.UUID;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.restdocs.constraints.ConstraintDescriptions;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.restdocs.payload.FieldDescriptor;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.StringUtils;


@WebMvcTest(BeerController.class)
@AutoConfigureRestDocs
@ExtendWith(RestDocumentationExtension.class)
class BeerControllerTest {

  @MockBean
  BeerService beerService;

  @Autowired
  MockMvc mockMvc;

  @Autowired
  ObjectMapper mapper;

  @Test
  void get() throws Exception {
    when(beerService.getById(isA(UUID.class)))
        .thenReturn(BeerDto.builder().id(UUID.randomUUID()).build());

    mockMvc.perform(RestDocumentationRequestBuilders.get("/api/v1/beer/{beerId}", UUID.randomUUID().toString())
        .param("cold", "true")
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andDo(document("/v1/beer.get",
            pathParameters(
                parameterWithName("beerId").description("UUID of desired beer")
            ),
            requestParameters(
                parameterWithName("cold").description("Whether the beer should be cold")
            ),
            responseFields(
                fieldWithPath("id").description("ID of Beer"),
                fieldWithPath("created").description("When the beer was created").type(OffsetDateTime.class.getName()),
                fieldWithPath("modified").description("When the beer was modified last"),
                fieldWithPath("name").description("Name of the beer"),
                fieldWithPath("style").description("Beer style, e.g. LAGER"),
                fieldWithPath("upc").description("UPC of the beer"),
                fieldWithPath("price").description("Price per beer"),
                fieldWithPath("quantity").description("How many of this beer are available")
            )
        ));
  }


  @Test
  void create() throws Exception {
    when(beerService.create(isA(BeerDto.class)))
        .thenReturn(BeerDto.builder().name("Foo").style(BeerStyle.LAGER).upc("12123123").build());
    BeerDto beer = BeerDto.builder()
        .name("BeerName")
        .style(BeerStyle.LAGER)
        .upc("123123123")
        .price(123L)
        .build();

    ConstrainedFields fields = new ConstrainedFields(BeerDto.class);

    mockMvc.perform(RestDocumentationRequestBuilders.post("/api/v1/beer/")
        .contentType(MediaType.APPLICATION_JSON)
        .content(mapper.writeValueAsString(beer)))
        .andExpect(status().isCreated())
        .andDo(document("v1/beer.post",
            requestFields(
                fields.withPath("id").ignored(),
                fields.withPath("created").ignored(),
                fields.withPath("modified").ignored(),
                fields.withPath("name").description("Name of the beer"),
                fields.withPath("style").description("Beer style"),
                fields.withPath("upc").description("Beer UPC"),
                fields.withPath("price").description("Beer Price"),
                fields.withPath("quantity").ignored()
            )));
  }


  @Test
  void update() throws Exception {
    BeerDto beer = BeerDto.builder().id(UUID.randomUUID()).build();
    mockMvc.perform(RestDocumentationRequestBuilders.put("/api/v1/beer/" + beer.getId().toString())
        .contentType(MediaType.APPLICATION_JSON)
        .content(mapper.writeValueAsString(beer)))
        .andExpect(status().isNoContent());
  }


  @Test
  void delete() throws Exception {
    mockMvc.perform(RestDocumentationRequestBuilders.delete("/api/v1/beer/" + UUID.randomUUID().toString()))
        .andExpect(status().isNoContent());
  }

  private static class ConstrainedFields {
    private final ConstraintDescriptions constraintDescriptions;

    ConstrainedFields(Class<?> input) {
      this.constraintDescriptions = new ConstraintDescriptions(input);
    }

    private FieldDescriptor withPath(String path) {
      return fieldWithPath(path)
          .attributes(key("constraints").value(StringUtils.collectionToDelimitedString(
              this.constraintDescriptions.descriptionsForProperty(path), ". ")));
    }
  }
}
