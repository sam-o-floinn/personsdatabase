package samofloinn.github.PersonsDatabase.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import samofloinn.github.PersonsDatabase.services.impl.AddressServiceImpl;

@Controller
@Slf4j
public class AddressController {

    @Autowired
    AddressServiceImpl addressService;

    @GetMapping("/addAddress")
    public String addAddress(String street, String city,
                             String state, String postalCode, String personId) {
        log.info("AddressController: addAddress()");
        return addressService.addAddress(street, city, state, postalCode, personId);
    }

    @GetMapping("/editAddress")
    public String editAddress(String id, String street, String city, String state,
                              String postalCode, String personId) {
        log.info("AddressController: editAddress()");
        return addressService.editAddress(id, street, city, state, postalCode, personId);
    }

    @GetMapping("/deleteAddress")
    public String deleteAddress(String id) {
        log.info(("AddressController: deleteAddress()"));

        return addressService.deleteAddress(id);
    }
}
