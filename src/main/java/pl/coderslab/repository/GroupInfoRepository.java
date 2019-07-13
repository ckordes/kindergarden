package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.entity.GroupInfo;

@Repository
public interface GroupInfoRepository extends JpaRepository<GroupInfo, Long> {
    GroupInfo findFirstByOrderByIdDesc();
}
