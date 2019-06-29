package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Group;
import pl.coderslab.entity.GroupInfo;

import java.util.List;

public interface GroupInfoRepository extends JpaRepository<GroupInfo, Long> {
}
