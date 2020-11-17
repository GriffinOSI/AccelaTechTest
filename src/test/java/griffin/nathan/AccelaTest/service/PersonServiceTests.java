package griffin.nathan.AccelaTest.service;

import griffin.nathan.AccelaTest.database.PersonRepository;
import griffin.nathan.AccelaTest.model.Person;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTests {

    @InjectMocks
    PersonService personService;

    @Mock
    PersonRepository personRepository;

    @Test
    public void shouldAddPerson_WhenPersonWithSameIdDoesNotExist() {
        when(personRepository.findById(54l)).thenReturn(Optional.empty());

        personService.addPerson(54L , "NotJim", "Slim");

        verify(personRepository, times(1)).save(any());
    }

    @Test
    public void shouldNotAddPerson_WhenPersonWithSameIdExists() {
        Person person = new Person(54L, "Jim", "Slim");
        when(personRepository.findById(54l)).thenReturn(java.util.Optional.of(person));

        personService.addPerson(54L , "NotJim", "Slim");
        verify(personRepository, times(0)).save(any());
    }

    @Test
    public void shouldEditPerson_WhenPersonWithIdExists() {
        Person person = new Person(54L, "Jim", "Slim");
        when(personRepository.findById(54l)).thenReturn(java.util.Optional.of(person));

        personService.editPerson(54L, "Scooby", "Doo");

        verify(personRepository, times(1)).save(any());
    }

    @Test
    public void shouldNotEditPerson_WhenPersonWithIdDoesNotExist() {
        when(personRepository.findById(54l)).thenReturn(Optional.empty());

        personService.editPerson(54L, "Scooby", "Doo");

        verify(personRepository, times(0)).save(any());
    }

    @Test
    public void shouldOnlyUpdateFirstName_WhenEditingUser_IfOnlyThatValueIsProvided(){
        Person person = new Person("Jim", "Slim");
        when(personRepository.findById(1l)).thenReturn(java.util.Optional.of(person));
        personService.editPerson(1L, "NotJim", "");


        Person editedPerson = personService.getPerson(1L);
        assertEquals(editedPerson.getFirstName(), "NotJim");
        assertEquals(editedPerson.getLastName(), "Slim");

        verify(personRepository, times(1)).save(any());
    }

    @Test
    public void shouldPersonIsDeletedFromDatabase() {
        personService.deletePerson(1L);

        verify(personRepository, times(1)).deleteById(any());
    }

    @Test
    public void shouldFindAllWhenListingAllPersons() {
        personService.listAllPeople();

        verify(personRepository, times(1)).findAll();
    }

    @Test
    public void shouldReturnAccurateCountOfPeople() {
        when(personRepository.count()).thenReturn(1L);

        assertEquals(personService.countTotalPeople(), 1);

        verify(personRepository, times(1)).count();
    }
}
