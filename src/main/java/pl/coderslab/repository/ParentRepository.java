package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Parent;
import pl.coderslab.entity.Person;

@Repository
public interface ParentRepository extends JpaRepository<Parent, Long> {
    Parent findByPerson(Person person);
    Parent findById(long id);
}
