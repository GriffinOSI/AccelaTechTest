package griffin.nathan.AccelaTest.model;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonTests {

    private final Address testAddress1 = new Address(1L, "123 Fake Street", "Oslo", "Norway", "1234");

    @Test
    public void shouldAddNewAddressToUser() {
        Person person = new Person(1L, "Jim", "Richards");
        assertEquals(person.getAddresses().size(), 0);

        person.addAddress(testAddress1);

        assertEquals(person.getAddresses().size(), 1);
    }
}
