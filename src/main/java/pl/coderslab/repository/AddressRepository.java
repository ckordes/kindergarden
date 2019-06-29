package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
    Address findById(long id);
}
