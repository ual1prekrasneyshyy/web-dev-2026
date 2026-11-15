package kz.kbtu.webdev.hw3.repository;

import kz.kbtu.webdev.hw3.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface GroupRepository extends JpaRepository<Group, Long> {
}
