package samofloinn.github.PersonsDatabase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import samofloinn.github.PersonsDatabase.services.impl.AddressServiceImpl;
import samofloinn.github.PersonsDatabase.services.impl.PersonServiceImpl;
import samofloinn.github.PersonsDatabase.utils.PersonsDatabaseHelper;

import java.util.Scanner;

/**
 * PersonDatabaseRunner:
 * Command-line interface version for the application
 * @author Sam O'Floinn (samofloinn@gmail.com)
 * @since 24/11/2020
 * @version 1.0
 */

@Component
public class PersonsDatabaseRunner implements CommandLineRunner {
    @Autowired
    private PersonServiceImpl personService;
    @Autowired
    private AddressServiceImpl addressService;
    @Autowired
    private PersonsDatabaseHelper helper;


    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        String input = "";
        //runs until the user terminates the program by typing 'exit'
        while( !(input.toLowerCase().equals("exit"))) {
            System.out.println("input = " + input);
            System.out.println("Make a command:");
            input = scanner.nextLine();
            helper.runInput(input);
        }
        System.out.println("Exiting program");
        System.exit(0);

    }
}
