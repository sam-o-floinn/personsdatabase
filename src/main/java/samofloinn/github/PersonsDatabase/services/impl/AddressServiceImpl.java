package samofloinn.github.PersonsDatabase.services.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import samofloinn.github.PersonsDatabase.entities.Address;
import samofloinn.github.PersonsDatabase.repositories.AddressRepository;
import samofloinn.github.PersonsDatabase.services.AddressService;
import samofloinn.github.PersonsDatabase.services.ServiceHelper;

/**
 * AddressServiceImpl: implements the Address Service
 * Based on user input, alters the Address repositry
 * @author Sam O'Floinn
 * @since 24/11/2020
 * @version 1.0
 */
@Service
@Slf4j
public class AddressServiceImpl implements AddressService {

    // == fields ==
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private ServiceHelper helper;

    /**
     * addAddress(): adds a new entry to the Address repository
     * @param street a string
     * @param city a string
     * @param state a string
     * @param postalCode a string
     * @param personId a string converted to long
     * @return empty path
     */
    @Override
    public String addAddress(String street, String city, String state, String postalCode, String personId) {
        if (helper.isValidString(street)
                && helper.isValidString(city)
                && helper.isValidString(state)
                && helper.isValidString(postalCode)
                && helper.isValidID(personId)
        ) {
            Address address = new Address(street, city, state, postalCode, Long.parseLong(personId));
            addressRepository.save(address);
        } else log.info("addAddress(): inputs invalid, address not added.");
        return "";
    }

    /**
     * editAddress(): changes an existing address entity to the new specified params
     * with more time, I'd have made these parameters optional
     * @param id string converted to long (does nothing if no matching ID found)
     * @param street string
     * @param city string
     * @param state string
     * @param postalCode string
     * @param personId string converted to long
     * @return empty path
     */
    @Override
    public String editAddress(String id, String street, String city, String state, String postalCode, String personId) {

        log.info("EditAddress()");

        if (helper.isValidID(id)) {
            Address editThisAddress = addressRepository.findOneById(Long.parseLong(id));
            if (editThisAddress != null) {
                if(helper.isValidID(id)
                    && helper.isValidString(street)
                    && helper.isValidString(city)
                    && helper.isValidString(state)
                    && helper.isValidString(postalCode)
                    && helper.isValidID(personId)) {
                    editThisAddress.setStreet(street);
                    editThisAddress.setCity(city);
                    editThisAddress.setState(state);
                    editThisAddress.setPostalCode(postalCode);
                    editThisAddress.setPersonId(Long.parseLong(personId));

                    addressRepository.save(editThisAddress);
                    log.info("EditAddress(): Address is now edited");
                } else log.info("EditAddress(): or more parameters were invalid, please retry");
            } else log.info("Could not find a user with ID " + id);
        }

        return "";
    }

    /**
     * deleteAddress:
     * removes an entry from the Address repository
     * @param id the ID to be deleted (does nothing if no matching ID found)
     * @return empty path
     */
    @Override
    public String deleteAddress(String id) {
        log.info("deleteAddress()");
        if (helper.isValidID(id)) {
            Address deleteThisAddress = addressRepository.findOneById(Long.parseLong(id));
            if (deleteThisAddress != null) {
                addressRepository.delete(deleteThisAddress);
                log.info("Address " + id + " is now deleted");
            }
        }
        return "";
    }
}
