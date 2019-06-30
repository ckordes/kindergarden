package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Parent;
import pl.coderslab.entity.Person;

public interface ParentRepository extends JpaRepository<Parent, Long> {
    Parent findByPerson(Person person);
    Parent findById(long id);
}
