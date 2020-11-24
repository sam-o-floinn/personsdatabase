package samofloinn.github.PersonsDatabase.services;

/**
 * Interface that outlines how the AddressService class should be structured
 * See implementation in the services/impl package
 * @author Sam O'Floinn
 * @since 24/11/2020
 * @version 1.0
 *
 */

public interface AddressService {

    String addAddress(String street, String city, String state,
                             String postalCode, String personId);
    String editAddress(String id, String street, String city,
                              String state, String postalCode, String personId);
    String deleteAddress(String id);
}
