package samofloinn.github.PersonsDatabase.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class to store helper methods for the services.
 * @author Sam O'Floinn
 * @since 24/11/2020
 * @version 1.0
 */
@Slf4j
@Component
public class ServiceHelper {

    /**
     * isValidString():
     * Verifies that the given string is not empty and has no exploitable special characters
     * @param input The string to be verified
     * @return true means it's valid, false means it's not
     */
    public boolean isValidString(String input) {
        //A string is valid if:
        //1) no special characters beyond numbers or apostrophes
        //2) isn't just whitespace
        log.info("ServiceHelper: isValidString()");
        if (input.isBlank()) {
            return false;
        }
        Pattern pattern = Pattern.compile("[a-zA-Z0-9' ]*");
        Matcher matcher = pattern.matcher(input);
        if (!matcher.matches()) {
            log.info(input + " has unallowed special characters");
            return false;
        }
        return true;
    }

    /**
     * isValidID:
     * Verifies the given string can be converted to a Long
     * @param input the string, which should be a number, to be confirmed
     * @return true if it's a valid Long, false if not
     */
    public boolean isValidID(String input) {
        log.info("ServiceHelper: isValidID()");
        try {
            Long id = Long.parseLong(input);
            return true;
        } catch(Exception e) {
            return false;
        }
    }
}
