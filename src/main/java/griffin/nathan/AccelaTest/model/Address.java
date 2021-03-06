package griffin.nathan.AccelaTest.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "address")
public class Address {
    @Id
    //@GeneratedValue(strategy = GenerationType.TABLE)
    private long id;
    private String street;
    private String city;
    private String state;
    private String postalCode;

    public Address() {

    }

    public Address(String street, String city, String state, String postalCode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
    }

    public Address(Long id, String street, String city, String state, String postalCode) {
        this.id = id;
        this.street = street;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
    }
}
