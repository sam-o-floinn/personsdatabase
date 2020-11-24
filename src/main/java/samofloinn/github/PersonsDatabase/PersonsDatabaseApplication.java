package samofloinn.github.PersonsDatabase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import samofloinn.github.PersonsDatabase.services.impl.PersonServiceImpl;

/**
 * Primary application file. This is run at the start of every project run
 *
 * @author Sam O'Floinn (samofloinn@gmail.com)
 * @since 24/11/2020
 * @version 1.0
 */
@SpringBootApplication
public class PersonsDatabaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonsDatabaseApplication.class, args);
	}
}
