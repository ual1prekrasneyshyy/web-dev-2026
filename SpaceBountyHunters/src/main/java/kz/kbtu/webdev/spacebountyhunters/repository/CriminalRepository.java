package kz.kbtu.webdev.spacebountyhunters.repository;

import kz.kbtu.webdev.spacebountyhunters.entity.WantedCriminal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface CriminalRepository extends JpaRepository<WantedCriminal, Long>, CustomCriminalRepository {
}
