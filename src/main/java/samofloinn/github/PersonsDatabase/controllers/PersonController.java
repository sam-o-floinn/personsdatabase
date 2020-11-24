package samofloinn.github.PersonsDatabase.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import samofloinn.github.PersonsDatabase.services.impl.PersonServiceImpl;

/**
 * PersonController:
 * Provides forwarding off URL mappings for the PersonService's functions, as well as an intermediary
 * @author Sam O'Floinn (samofloinn@gmail.com)
 * @since 24/11/2020
 * @version 1.0
 */

@Controller
@Slf4j
public class PersonController {

    @Autowired
    private PersonServiceImpl personService;

    @GetMapping("/addPerson")
    public String addPerson(String firstName, String lastName, String addressId) {
        log.info("PersonController: addPerson() called");
        return personService.addPerson(firstName, lastName, addressId);
    }

    @GetMapping("/editPerson")
    public String editPerson(String id, String firstName, String lastName, String addressId) {
        log.info("PersonController: editPerson("
                + id + "," + firstName + "," + lastName + "," + addressId
        + ")");
        return personService.editPerson(id, firstName, lastName, addressId);
    }

    @GetMapping("/deletePerson")
    public String deletePerson(String id) {
        log.info("PersonController: deletePerson(" + id + ")");
        return personService.deletePerson(id);
    }

    @GetMapping("/amount")
    public int amountOfPeople() {
        log.info("PersonController: amountOfPeople()");
        return personService.amountOfPeople();
    }


}
