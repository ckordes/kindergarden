package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Child;

public interface ChildRepository extends JpaRepository<Child, Long> {
    Child findById(long id);
}
