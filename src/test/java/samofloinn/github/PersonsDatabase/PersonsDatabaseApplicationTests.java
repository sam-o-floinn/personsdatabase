package samofloinn.github.PersonsDatabase;


import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import samofloinn.github.PersonsDatabase.controllers.AddressController;
import samofloinn.github.PersonsDatabase.controllers.PersonController;
import samofloinn.github.PersonsDatabase.entities.Address;
import samofloinn.github.PersonsDatabase.entities.Person;
import samofloinn.github.PersonsDatabase.repositories.AddressRepository;
import samofloinn.github.PersonsDatabase.repositories.PersonRepository;


@Slf4j
@SpringBootTest
class PersonsDatabaseApplicationTests {

    @Autowired
    private PersonController personController;
    @Autowired
    private AddressController addressController;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private AddressRepository addressRepository;

	@Test
	void contextLoads() { assertThat("This", notNullValue());
	}

    /** ====== PERSON TESTS HERE ======
     */

    /**
     * getPerson_Exists_ReturnsTrue
     * Should assert that this entry is not null
     */
	@Test
    public void getPerson_Exists() {
	    personController.addPerson("test", "person", "1");
        Person firstEntry = personRepository.findOneByFirstName("test"); //gets person with ID of 1
        assertThat(firstEntry, notNullValue());
        //assertThat(firstEntry.getFirstName(), notNullValue());

    }

    /**
     * Searches for a user ID that doesn't exist. Should return null
     */
    @Test
    public void getPerson_DoesNotExist()  {
	    Long notInRepo = 42069L;
	    assertThat(personRepository.findOneById(notInRepo), null);
    }

    /**
     * Affirms that an edit on the Persons works
     */
    @Test
    public void editPerson_ValuesMatch() {
        //Person test = new Person("ChangeMe", "IgnoreMe", 1);
        personController.addPerson("ChangeMe", "IgnoreMe", 1+"");
        Person test = personRepository.findOneByFirstName("ChangeMe");
        personController.editPerson(test.getId()+"", "NewName", "IgnoreMe", 1+"");
        assertThat(test.getFirstName(), equals("NewName"));

    }

    /**
     * Deletes an IP and confirms it isn't retrieved from the databaase
     */
    @Test
    public void deletePerson_Works() {
        personController.addPerson("DeleteMe", "Now", 1+"");
        Person deleteThis = personRepository.findOneByFirstName("DeleteMe");
        Long deletedId = deleteThis.getId();
        personController.deletePerson(deletedId+"");
        Person shouldGiveNothing = personRepository.findOneByFirstName("DeleteMe");
        assertThat(shouldGiveNothing, null);
    }

    /** ====== ADDRESS TESTS HERE ======
     */

    /**
     * Gives good params and adds an address
     */
    @Test
    public void addAddress_GoodParams_Works() {
        addressController.addAddress("Do", "Ray", "Me", "Fa", "1");
        Address addedAddress = addressRepository.findOneByStreet("Do");
        assertThat(addedAddress, notNullValue());
    }

    /**
     * This addres should be rejected because of the irregular characters in 'street' and 'personId'
     */
    @Test
    public void addAddress_BadParams_DoesNotWork() {
        addressController.addAddress("&*^", "street", "name","bad", "AlsoThis");
        Address rejectedAddress = addressRepository.findOneByStreet("&*^");
        assertThat(rejectedAddress, null);
    }

    /**
     * Adds a user, then edits it, confirms the edit worked
     */
    @Test
    public void editAddress_GoodParams_Works() {
        addressController.addAddress("Do", "Ray", "Me", "Fa", "1");
        Address editThis = addressRepository.findOneByStreet("Do");
        addressController.editAddress(editThis.getId()+"", "Edited Do", "Ray",
                "Me", "Fa", 1+"");
        Address edited = addressRepository.findOneByStreet("Edited Do");
        String editedStreet = edited.getStreet();
        assertThat(editedStreet, equals("Edited Do"));
    }

    /**
     * Tries to edit a user with bad inputs
     */
    @Test
    public void editAddress_BadParams_DoesNotWork() {
        addressController.addAddress("Do", "Ray", "Me", "Fa", "1");
        Address editThis = addressRepository.findOneByStreet("Do");
        addressController.editAddress(editThis.getId()+"", "%&$(", "No",
                "Changes", "Here", 1+"");
        Address theSame = addressRepository.findOneByStreet("Do");
        String theSameStreet = theSame.getStreet();
        assertThat(theSameStreet, equals("Do"));
    }

    /**
     * Adds, deletes an address then confirms it works
     */
    @Test
    public void deleteAddress_Works() {
        addressController.addAddress("Delete Me", "Ray", "Me", "Fa", "1");
        Address deleteThis = addressRepository.findOneByStreet("Delete Me");
        addressController.deleteAddress(deleteThis.getId()+"");
        Address shouldGiveNothing = addressRepository.findOneByStreet("Delete Me");
        assertThat(shouldGiveNothing, null);
    }



}
