package jana60.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import jana60.model.Country;

@Repository
public interface CountryRepository extends CrudRepository<Country, Integer> {

}
