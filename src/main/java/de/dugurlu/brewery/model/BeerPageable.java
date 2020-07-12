package de.dugurlu.brewery.model;

import java.util.List;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;


public class BeerPageable extends PageImpl<Beer> {

  public BeerPageable(List<Beer> content, Pageable pageable, long total) {
    super(content, pageable, total);
  }


  public BeerPageable(List<Beer> content) {
    super(content);
  }
}
