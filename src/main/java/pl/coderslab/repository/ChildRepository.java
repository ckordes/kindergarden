package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Child;

@Repository
public interface ChildRepository extends JpaRepository<Child, Long> {
    Child findById(long id);
}
