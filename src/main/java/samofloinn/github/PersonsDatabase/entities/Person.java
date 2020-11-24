package samofloinn.github.PersonsDatabase.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Person. A database entity.
 * Has an immutable ID. Has a first name and last name which can be changed
 *
 * @author Sam O'Floinn
 * @version 1.0
 * @since 24/11/2020
 */

@Data
@Entity
public class Person {

    // == fields ==
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private Long addressId;

    // == constructors ==
    public Person(String firstName, String lastName, Long addressId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.addressId = addressId;
    }

    public Person() {
    }
}
