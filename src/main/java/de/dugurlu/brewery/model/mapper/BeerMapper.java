package de.dugurlu.brewery.model.mapper;

import de.dugurlu.brewery.model.Beer;
import de.dugurlu.brewery.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

  BeerDto toBeerDto(Beer beer);

  BeerDto toBeerDtoWithInventory(Beer beer);

  Beer toBeer(BeerDto dto);
}
