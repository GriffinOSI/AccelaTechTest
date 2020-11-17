package griffin.nathan.AccelaTest.model;

import lombok.Data;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "person")
public class Person {
    @Id
    private long id;
    private String firstName;
    private String lastName;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "person_id")
    private Set<Address> addresses;

    public Person() {

    }

    public Person(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.addresses = new HashSet<>();
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.addresses = new HashSet<>();
    }

    public Person(String firstName, String lastName, Set<Address> addresses) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.addresses = addresses;
    }

    public void addAddress(Address newAddress) {
        this.addresses.add(newAddress);
    }
}