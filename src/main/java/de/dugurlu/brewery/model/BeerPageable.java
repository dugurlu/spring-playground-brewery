package de.dugurlu.brewery.model;

import java.util.List;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;


public class BeerPageable extends PageImpl<BeerDto> {

  public BeerPageable(List<BeerDto> content, Pageable pageable, long total) {
    super(content, pageable, total);
  }


  public BeerPageable(List<BeerDto> content) {
    super(content);
  }
}
