package griffin.nathan.AccelaTest.database;

import griffin.nathan.AccelaTest.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface PersonRepository extends CrudRepository<Person, Long> {
}
