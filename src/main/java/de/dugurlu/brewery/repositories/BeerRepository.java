package de.dugurlu.brewery.repositories;

import de.dugurlu.brewery.model.Beer;
import java.util.UUID;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BeerRepository extends PagingAndSortingRepository<Beer, UUID> {

}
