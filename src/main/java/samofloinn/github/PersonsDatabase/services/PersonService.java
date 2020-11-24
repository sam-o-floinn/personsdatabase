package samofloinn.github.PersonsDatabase.services;

import samofloinn.github.PersonsDatabase.entities.Person;

import java.util.List;

/**
 * Interface that outlines how the PersonService class should be structured
 * See implementation in the services/impl package
 * @author Sam O'Floinn (samofloinn@gmail.com)
 * @since 24/11/2020
 * @version 1.0
 *
 */

public interface PersonService {

    String addPerson(String firstName, String lastName, String addressId);
    String editPerson(String id, String firstName, String lastName, String addressId);
    String deletePerson(String id);
    int amountOfPeople();
    void listAllPeople();
}
