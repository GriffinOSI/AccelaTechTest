package griffin.nathan.AccelaTest;

import griffin.nathan.AccelaTest.database.AddressRepository;
import griffin.nathan.AccelaTest.model.Address;
import griffin.nathan.AccelaTest.model.Person;
import griffin.nathan.AccelaTest.database.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

@SpringBootApplication
public class AccelaTestApplication {


	private static final Logger log = LoggerFactory.getLogger(AccelaTestApplication.class);



	public static void main(String[] args) {
		SpringApplication.run(AccelaTestApplication.class, args);
	}
}
