package kz.kbtu.webdev.spacebountyhunters.service;

import kz.kbtu.webdev.spacebountyhunters.dto.CriminalDto;
import kz.kbtu.webdev.spacebountyhunters.entity.WantedCriminal;
import kz.kbtu.webdev.spacebountyhunters.repository.CriminalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CriminalService {
    @Autowired
    private CriminalRepository criminalRepository;

    public List<WantedCriminal> getAllCriminals(Integer minReward, Integer maxReward, Boolean armed, Boolean hasCrew, Boolean master, String sortOrder){
        return criminalRepository.findByCriteria(minReward, maxReward, armed, hasCrew, master, sortOrder);
    }

    public WantedCriminal getCriminalById(Long id) {
        return criminalRepository.findById(id).orElse(null);
    }

    public WantedCriminal addCriminal(CriminalDto dto){
        WantedCriminal criminal = new WantedCriminal();
        criminal.setName(dto.getName());
        criminal.setNickname(dto.getNickname());
        criminal.setReward(dto.getReward());
        criminal.setLastKnownCoordinate(dto.getLastKnownCoordinate());
        criminal.setDifficulty(dto.getDifficulty());
        criminal.setArmed(dto.isArmed());
        criminal.setHasCrew(dto.isHasCrew());
        criminal.setEscapeMaster(dto.isEscapeMaster());
        return criminalRepository.save(criminal);
    }
}
