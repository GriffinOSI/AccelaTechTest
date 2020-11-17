package griffin.nathan.AccelaTest.service;

import griffin.nathan.AccelaTest.database.AddressRepository;
import griffin.nathan.AccelaTest.database.PersonRepository;
import griffin.nathan.AccelaTest.model.Address;
import griffin.nathan.AccelaTest.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class PersonService {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private AddressRepository addressRepository;

    public void addPerson(Long id, String firstName, String lastName) {
        if(personExists(id)) {
            System.out.println("User already exists with id " + id);
            return;
        }
        personRepository.save(new Person(id, firstName, lastName));
    }

    public Person getPerson(Long id) {
        return personRepository.findById(id).get();
    }

    public void editPerson(Long id, String firstName, String lastName) {
        if(personExists(id)) {
            Person personToEdit = personRepository.findById(id).get();
            if(!firstName.isEmpty()) {
                personToEdit.setFirstName(firstName);
            }
            if(!lastName.isEmpty()) {
                personToEdit.setLastName(lastName);
            }
            personRepository.save(personToEdit);
        }
    }

    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }

    public void addAddressToPerson(Long personId,
                                   Long addressId,
                                   String street,
                                   String city,
                                   String state,
                                   String postalCode){
        if(!personExists(personId)) {
            System.out.println("Person does not exist");
            return;
        }
        Person personToEdit = personRepository.findById(personId).get();
        personToEdit.addAddress(new Address(addressId, street, city, state, postalCode));
        personRepository.save(personToEdit);
    }

    public void editAddress(Long addressId, String street, String city, String state, String postalCode) {
        if(addressRepository.findById(addressId).isPresent()) {
            Address addressToEdit = addressRepository.findById(addressId).get();
            if(!street.isEmpty()) { addressToEdit.setStreet(street); }
            if(!city.isEmpty()) { addressToEdit.setCity(city);}
            if(!state.isEmpty()) { addressToEdit.setState(state);}
            if(!postalCode.isEmpty()) { addressToEdit.setPostalCode(postalCode);}
            addressRepository.save(addressToEdit);
        } else {
            System.out.println("Address not found with id " + addressId);
        }
    }

    public void deleteAddress(Long addressId) {
        addressRepository.deleteById(addressId);
    }

    public long countTotalPeople() {
        return personRepository.count();
    }

    public void listAllPeople() {
        personRepository.findAll().forEach(person -> {
            System.out.println((person.toString()));
        });
    }

    private boolean personExists(Long id) {
        return personRepository.findById(id).isPresent();
    }
}
