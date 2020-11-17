package griffin.nathan.AccelaTest;

import griffin.nathan.AccelaTest.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class ApplicationShell {

    @Autowired
    private PersonService personService;

    @ShellMethod(value = "Add a new person. ", key = "add person")
    public void addPerson(Long id, String firstName, String lastName) {
        personService.addPerson(id, firstName, lastName);
        System.out.println("Added person. " + firstName + " " + lastName);
    }

    @ShellMethod(value = "Edit person by their id", key = "edit person")
    public void editPerson(Long id,
                           @ShellOption(defaultValue = "") String firstName,
                           @ShellOption(defaultValue = "") String lastName) {
        personService.editPerson(id, firstName, lastName);
    }

    @ShellMethod(value = "Delete a person by their ID", key = "delete person")
    public void deletePerson(Long id) {
        personService.deletePerson(id);
    }

    @ShellMethod(value = "Add a new address.", key = "add address")
    public void addAddress(Long personId, Long addressId,
                           @ShellOption(defaultValue = "") String street,
                           @ShellOption(defaultValue = "") String city,
                           @ShellOption(defaultValue = "") String state,
                           @ShellOption(defaultValue = "") String postcode) {
        personService.addAddressToPerson(personId, addressId, street, city, state, postcode);
        System.out.println("Added address");
    }

    @ShellMethod(value = "Edit an existing address. ", key = "edit address")
    public void editAddress(Long addressId,
                           @ShellOption(defaultValue = "") String street,
                           @ShellOption(defaultValue = "") String city,
                           @ShellOption(defaultValue = "") String state,
                           @ShellOption(defaultValue = "") String postcode) {
        personService.editAddress(addressId, street, city, state, postcode);
        System.out.println("Edited address");
    }

    @ShellMethod(value = "Delete an address by its ID", key = "delete address")
    public void deleteAddress(Long id) {
        personService.deleteAddress(id);
    }

    @ShellMethod(value = "Print the total number of people in the database", key = "count people")
    public void countPeople() {
        System.out.println("There are " + personService.countTotalPeople() + " people in the database");
    }

    @ShellMethod(value = "List all people in the database", key = "list people")
    public void listPersons() {
        personService.listAllPeople();
    }

    @ShellMethod(value = "Add example values to database", key = "demo")
    public void demo() {
        personService.addPerson(1L, "Jim", "Jam");
        personService.addAddressToPerson(1L, 1L, "17 Harland Street", "Belfast", "Ireland", "BT43 4SD");
        personService.addAddressToPerson(1L, 2L, "Dooley Avenue", "Cork", "Ireland", "12332");
        personService.addPerson(2L, "Jane", "Doe");
        personService.addPerson(3L, "Craig", "David");
        personService.addAddressToPerson(3L, 3L, "Electric Avenue", "Timbuktu", "Swaziland", "23123");
    }
}
