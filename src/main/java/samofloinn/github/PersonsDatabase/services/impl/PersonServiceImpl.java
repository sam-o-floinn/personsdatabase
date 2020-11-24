package samofloinn.github.PersonsDatabase.services.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import samofloinn.github.PersonsDatabase.entities.Person;
import samofloinn.github.PersonsDatabase.repositories.PersonRepository;
import samofloinn.github.PersonsDatabase.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import samofloinn.github.PersonsDatabase.services.ServiceHelper;

import java.util.List;

/**
 * PersonServiceImpl
 * Implements the person service.
 * Based on given inputs, it alters the Person repository as requested. Can add, edit or delete entries
 * @author Sam O'Floinn
 * @since 24/11/2020
 * @version 1.0
 */
@Service
@Slf4j
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    ServiceHelper helper;

    //note: every method follows the following pattern:
    //1) verifies the inputs are legit (a string is a string, the ID exists in the table, etc)
    //2) does the action

    /**
     * addPerson(): adds a new entry to the Person repository
     * @param firstName string
     * @param lastName string
     * @param addressId string converted to long
     * @return empty path
     */
    @Override
    public String addPerson(String firstName, String lastName, String addressId) {
        log.info("PersonServiceImpl: addPerson(). " +
                "First Name: " + firstName + ", Last Name: " + lastName);
        //Steps:
        //verify the strings are legit names (not numbers or special characters
        if (helper.isValidString(firstName)
                && helper.isValidString(lastName)
                && helper.isValidID(addressId)
        ) {
            log.info("addPerson: inputs are valid!");
            //2: if so, add it to PersonRepository
            Person newPerson = new Person(firstName, lastName, Long.parseLong(addressId));
            personRepository.save(newPerson);
            log.info("New person " + newPerson.getId() + " in the database");
        } else {
            log.info("Invalid inputs given. Try again: " + firstName + ", " + lastName + ", " + addressId);
        }


        log.info("PersonServiceImpl: exiting addPerson()");

        return "";
    }

    /**
     * editPerson: changes an existing Person entity's values
     * @param id string converted to long (does nothing if no matching ID found)
     * @param firstName string
     * @param lastName string
     * @param addressId string converted to long
     * @return empty path
     */
    @Override
    public String editPerson(@RequestParam String id,
                             @RequestParam String firstName,
                             @RequestParam String lastName,
                             @RequestParam String addressId) {

        if(helper.isValidID(id)
        && helper.isValidString(firstName)
        && helper.isValidString(lastName)
        && helper.isValidID(addressId)) {
            Person editThisPerson = personRepository.findOneById(Long.parseLong(id));

            if (editThisPerson != null) {

                log.info("editPerson(): editing person " + editThisPerson.getId()
                        + ", " + editThisPerson.getFirstName());

                editThisPerson.setFirstName(firstName);
                editThisPerson.setLastName(lastName);
                editThisPerson.setAddressId(Long.parseLong(addressId));
                personRepository.save(editThisPerson);
                log.info("editPerson(): values for " + editThisPerson.getId() + " are now "
                        + editThisPerson.getFirstName() + editThisPerson.getLastName()
                        + editThisPerson.getAddressId());
            } else log.info("EditPerson(): Could not find person with ID " + id);
        } else log.info("EditPerson(): invalid inputs, please retry");
        return "";
    }

    /**
     * deletePerson(): removes an existing Person entity from the repository
     * @param id string converted to long (does nothing if no matching ID found)
     * @return empty path
     */
    @Override
    public String deletePerson(String id) {
        log.info("PersonServiceImpl: deleteById(): " + id);
        if (helper.isValidID(id)) {
            Long deleteId = Long.parseLong(id);
            Person deleteThis = personRepository.findOneById(deleteId);
            if (deleteThis != null) {
                log.info("Entry located for " + id + ": " + deleteThis.getFirstName());
                personRepository.deleteById(deleteId);
                log.info("Person ID " + id + " deleted");
            } else {
                log.info("PersonServiceImpl: deletePerson():" +
                        "Could not find a person with id " + id + ". End.");
            }
        }
        return "";
    }

    /**
     * amountOfPeople: returns the size of the current Person repository
     * @return empty path
     */
    public int amountOfPeople() {
        int amount = personRepository.findAll().size();
        log.info("PersonServiceImpl: amountOfPeople():" + amount);
        return amount;
    }

    /**
     * listAllPeople(): prints the first name + last name of every person in the repository
     */
    public void listAllPeople() {
        log.info("listAllPeople()");
        List<Person> people = personRepository.findAll();
        for (Person p : people) {
            System.out.println(p.getFirstName() + " " + p.getLastName());
        }
    }

}
