package kz.kbtu.webdev.spacebountyhunters.repository;

import kz.kbtu.webdev.spacebountyhunters.entity.WantedCriminal;

import java.util.List;

public interface CustomCriminalRepository {
    List<WantedCriminal> findByCriteria(Integer minReward, Integer maxReward, Boolean armed, Boolean hasCrew, Boolean master, String sortOrder);
}
