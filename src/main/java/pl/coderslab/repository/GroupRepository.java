package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Group;

import java.util.List;

public interface GroupRepository extends JpaRepository<Group,Long> {

    Group findById(long id);
}
