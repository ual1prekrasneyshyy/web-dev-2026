package kz.kbtu.webdev.spacebountyhunters.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import kz.kbtu.webdev.spacebountyhunters.entity.WantedCriminal;
import kz.kbtu.webdev.spacebountyhunters.repository.CustomCriminalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class CustomCriminalRepositoryImpl implements CustomCriminalRepository {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<WantedCriminal> findByCriteria(Integer minReward, Integer maxReward, Boolean armed, Boolean hasCrew, Boolean master, String sortOrder) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<WantedCriminal> criteriaQuery = criteriaBuilder.createQuery(WantedCriminal.class);
        Root<WantedCriminal> root = criteriaQuery.from(WantedCriminal.class);
        List<Predicate> predicates = new ArrayList<>();

        if(Objects.nonNull(minReward) && Objects.nonNull(maxReward)){
            predicates.add(criteriaBuilder.between(root.get("reward"), minReward, maxReward));
        }

        if(Objects.nonNull(minReward) && Objects.isNull(maxReward)){
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("reward"), minReward));
        }

        if(Objects.isNull(minReward) && Objects.nonNull(maxReward)){
            predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("reward"), maxReward));
        }

        if (Objects.nonNull(armed)) {
            predicates.add(criteriaBuilder.equal(root.get("armed"), armed));
        }

        if (Objects.nonNull(hasCrew)) {
            predicates.add(criteriaBuilder.equal(root.get("hasCrew"), hasCrew));
        }

        if (Objects.nonNull(master)) {
            predicates.add(criteriaBuilder.equal(root.get("master"), master));
        }

        if (!predicates.isEmpty()) {
            criteriaQuery.where(predicates.toArray(new Predicate[0]));
        }

        if(Objects.nonNull(sortOrder)) {
            if(sortOrder.equals("reward")) {
                criteriaQuery.orderBy(criteriaBuilder.asc(root.get("reward")));
            }
            if(sortOrder.equals("-reward")) {
                criteriaQuery.orderBy(criteriaBuilder.desc(root.get("reward")));
            }
        }

        TypedQuery<WantedCriminal> typedQuery = entityManager.createQuery(criteriaQuery);
        List<WantedCriminal> criminals = typedQuery.getResultList();
        return criminals;
    }
}
