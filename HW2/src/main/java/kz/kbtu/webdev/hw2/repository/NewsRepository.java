package kz.kbtu.webdev.hw2.repository;

import kz.kbtu.webdev.hw2.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface NewsRepository extends JpaRepository<News, Long> {
}
