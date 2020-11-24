package samofloinn.github.PersonsDatabase.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import samofloinn.github.PersonsDatabase.entities.Address;

import java.util.List;

/**
 * JPA repository for the Address table.
 * Holds all the address information. Autowired across the app.
 * Can find a single address if given the ID, or return all Address items
 *
 * @author Sam O'Floinn (samofloinn@gmail.com)
 * @since 24/11/2020
 * @version 1.0
 */

@RepositoryRestResource(collectionResourceRel = "address", path = "address")
public interface AddressRepository extends JpaRepository<Address, Long> {

    Address findOneById(@Param("id") Long id);
    Address findOneByStreet(@Param("street") String street);
    List<Address> findAll();

}