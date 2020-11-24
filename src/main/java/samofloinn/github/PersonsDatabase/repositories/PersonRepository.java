package samofloinn.github.PersonsDatabase.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import samofloinn.github.PersonsDatabase.entities.Person;

import java.util.List;

/**
 * JPA repository for the Person table.
 * Can find someone by their ID, and return a full list of all the Person objects
 *
 * @author Sam O'Floinn (samofloinn@gmail.com)
 * @since 24/11/2020
 * @version 1.0
 */

@RepositoryRestResource(collectionResourceRel = "person", path = "person")
public interface PersonRepository extends JpaRepository<Person, Long> {

    Person findOneByFirstName(@Param("firstName") String firstName);
    Person findOneById(@Param("id") Long id);
    List<Person> findAll();

}
