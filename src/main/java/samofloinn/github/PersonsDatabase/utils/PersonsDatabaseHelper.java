package samofloinn.github.PersonsDatabase.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import samofloinn.github.PersonsDatabase.services.impl.AddressServiceImpl;
import samofloinn.github.PersonsDatabase.services.impl.PersonServiceImpl;

import java.util.Scanner;

/**
 * A helper class to contain methods that the command-line aspect of PersonsDatabaseRunner makes.
 * The methods are put here as a design decision so they're easier to maintain and expand
 */
@Component
public class PersonsDatabaseHelper {

    @Autowired
    PersonServiceImpl personService;
    @Autowired
    AddressServiceImpl addressService;

    Scanner scanner = new Scanner(System.in);

    /**
     * addPerson():
     * asks for a series of inputs and creates a new Person entry with those
     */
    public void addPerson() {
        System.out.println("Adding person! Enter first name");
        String addFirstName = scanner.nextLine();
        System.out.println("Edit last name?");
        String addLastName = scanner.nextLine();
        System.out.println("Edit address ID?");
        String addAddressId = scanner.nextLine();

        personService.addPerson(addFirstName, addLastName, addAddressId);
    }

    /**
     * editPerson():
     * Asks for a series of inputs and changes an existing person's values with that
     */
    public void editPerson() {
        System.out.println("Edit person. Name the ID to edit.");
        String editId = scanner.nextLine();
        System.out.println("Edit first name?");
        String editFirstName = scanner.nextLine();
        System.out.println("Edit last name?");
        String editLastName = scanner.nextLine();
        System.out.println("Edit address ID?");
        String editAddressId = scanner.nextLine();

        personService.editPerson(editId, editFirstName, editLastName, editAddressId);
    }

    /**
     * deleteAddress():
     * asks for an ID and then deletes that
     */
    public void deletePerson() {
        System.out.println("Deleting person. Name the ID of the person to delete");
        String deleteId = scanner.nextLine();
        personService.deletePerson(deleteId);
    }

    /**
     * addAddress():
     * asks for a series of console inputs, then forwards them to add a new Address entry
     */
    public void addAddress() {
        System.out.println("Add address. Enter a street name.");
        String addStreet = scanner.nextLine();
        System.out.println("Add city");
        String addCity = scanner.nextLine();
        System.out.println("Add state");
        String addState = scanner.nextLine();
        System.out.println("Add postalCode");
        String addPostalCode = scanner.nextLine();
        System.out.println("Add person ID");
        String addPersonId = scanner.nextLine();

        addressService.addAddress(addStreet, addCity, addState, addPostalCode, addPersonId);
    }

    /**
     * editAddress():
     * asks for a series of inputs that is used to find an existing address and change its values
     */
    public void editAddress() {
        System.out.println("Edit address. Enter an ID");
        String editAdId = scanner.nextLine();
        System.out.println("Enter a street name.");
        String editStreet = scanner.nextLine();
        System.out.println("Edit city");
        String editCity = scanner.nextLine();
        System.out.println("Edit state");
        String editState = scanner.nextLine();
        System.out.println("Edit postalCode");
        String editPostalCode = scanner.nextLine();
        System.out.println("Edit person ID");
        String editPersonId = scanner.nextLine();

        addressService.editAddress(editAdId, editStreet, editCity,
                editState, editPostalCode, editPersonId);
    }

    /**
     * deleteAddress():
     * given a valid number, deletes a person who matches that
     */
    public void deleteAddress() {
        System.out.println("Delete address. Enter an ID to delete");
        String deleteAdId = scanner.nextLine();
        addressService.deleteAddress(deleteAdId);
    }

    /**
     * Switch case that matches the user input to the appropriate action
     * @param input the string the user has typed, represents a command
     */
    public void runInput(String input) {

        switch (input.toLowerCase()) {
            case "add person":
                this.addPerson();
                break;
            case "edit person":
                this.editPerson();
                break;
            case "delete person":
                this.deletePerson();
                break;
            case "add address":
                this.addAddress();
                break;
            case "edit address":
                this.editAddress();
                break;
            case "delete address":
                this.deleteAddress();
                break;
            case "count persons":
                System.out.println("There are " + personService.amountOfPeople() + " in the database");
                break;
            case "list persons":
                personService.listAllPeople();
                break;
            case "exit":
                break;
            default:
                System.out.println("Command unrecognised");
                break;
        }
    }
}
