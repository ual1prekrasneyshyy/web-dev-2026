package kz.kbtu.webdev.spacebountyhunters.repository;

import kz.kbtu.webdev.spacebountyhunters.entity.HuntLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface HuntLogRepository extends JpaRepository<HuntLog, Long> {
    List<HuntLog> findAllByCriminalId(Long criminalId);
}
