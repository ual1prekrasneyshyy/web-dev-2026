package kz.kbtu.webdev.midterm.repository;

import kz.kbtu.webdev.midterm.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface NewsRepository extends JpaRepository<News, Long> {
    List<News> findAllByTitleContainingIgnoreCase(String title);
}
