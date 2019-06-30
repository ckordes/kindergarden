package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Allergie;
@Repository
public interface AllergieRepository extends JpaRepository<Allergie,Long> {
    Allergie findById(long id);
}
