package griffin.nathan.AccelaTest.database;

import griffin.nathan.AccelaTest.model.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
}
