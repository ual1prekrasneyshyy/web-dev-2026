package kz.narxoz.k8s.hw1.repository;

import kz.narxoz.k8s.hw1.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface NewsRepository extends JpaRepository<News, Long> {
}
