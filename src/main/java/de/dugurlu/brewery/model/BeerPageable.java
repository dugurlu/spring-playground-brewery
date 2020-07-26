package de.dugurlu.brewery.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.List;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;


public class BeerPageable extends PageImpl<BeerDto> {

  @JsonCreator(mode = Mode.PROPERTIES)
  public BeerPageable( @JsonProperty("content") List<BeerDto> content,
      @JsonProperty("pageable") Pageable pageable,
      @JsonProperty("totalElements") long totalElements,
      @JsonProperty("number") int number,
      @JsonProperty("size") int size,
      @JsonProperty("first") boolean first,
      @JsonProperty("last") boolean last,
      @JsonProperty("totalPages") int totalPages,
      @JsonProperty("sort")JsonNode sort) {
    super(content, PageRequest.of(number, size), totalElements);
  }

  public BeerPageable(List<BeerDto> content, Pageable pageable, long total) {
    super(content, pageable, total);
  }


  public BeerPageable(List<BeerDto> content) {
    super(content);
  }
}
