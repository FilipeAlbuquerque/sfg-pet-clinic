package guru.springframework.sfgpetclinic.repositories;

import guru.springframework.sfgpetclinic.model.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {
}
