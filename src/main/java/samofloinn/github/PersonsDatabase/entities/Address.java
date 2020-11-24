package samofloinn.github.PersonsDatabase.entities;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Address.
 * An entity that covers data relating to addresses.
 * Its ID matches that of the person who own the address
 * Addresses can be deleted or edited, but not their IDs
 *
 * @author Sam O'Floinn (samofloinn@gmail.com)
 * @version 1.0
 * @since 24/11/20
 */

@Data
@Entity
public class Address {

    // == fields ==
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String street;
    private String city;
    private String state;
    private String postalCode;
    private Long personId;

    // == constructors ==

    public Address(String street, String city, String state, String postalCode, Long personId) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.personId = personId;
    }

    public Address() {
    }
}
