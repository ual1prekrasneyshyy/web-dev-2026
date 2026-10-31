package kz.kbtu.webdev.spacebountyhunters.service;

import kz.kbtu.webdev.spacebountyhunters.dto.SaveLogDto;
import kz.kbtu.webdev.spacebountyhunters.entity.HuntLog;
import kz.kbtu.webdev.spacebountyhunters.entity.WantedCriminal;
import kz.kbtu.webdev.spacebountyhunters.repository.CriminalRepository;
import kz.kbtu.webdev.spacebountyhunters.repository.HuntLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class HuntLogService {
    @Autowired
    private HuntLogRepository huntLogRepository;
    @Autowired
    private CriminalRepository criminalRepository;

    public List<HuntLog> getAllLogs(Long criminalId) {
        if(Objects.nonNull(criminalId)){
            return huntLogRepository.findAllByCriminalId(criminalId);
        }

        return huntLogRepository.findAll();
    }

    public HuntLog getLog(Long id) {
        return huntLogRepository.findById(id).orElse(null);
    }

    public HuntLog addLog(SaveLogDto dto) {
        HuntLog huntLog = new HuntLog();

        Optional<WantedCriminal> criminal = criminalRepository.findById(dto.getCriminalId());

        if(criminal.isEmpty()){
            return null;
        }

        huntLog.setCriminal(criminal.get());
        huntLog.setSuccess(dto.getSuccess());
        huntLog.setNotes(dto.getNotes());
        huntLog.setCreatedAt(LocalDateTime.now());
        return huntLogRepository.save(huntLog);
    }

    public HuntLog updateLog(Long id, SaveLogDto dto) {
        Optional<HuntLog> o = huntLogRepository.findById(id);

        if(o.isEmpty()){
            return null;
        }

        HuntLog log = o.get();

        if(!log.getCriminal().getId().equals(dto.getCriminalId())){
            return null;
        }

        log.setNotes(dto.getNotes());
        log.setSuccess(dto.getSuccess());
        return huntLogRepository.save(log);
    }

    public boolean deleteLog(Long id) {
        Optional<HuntLog> o = huntLogRepository.findById(id);

        if(o.isEmpty()){
            return false;
        }

        HuntLog log = o.get();
        huntLogRepository.deleteById(log.getId());
        return true;
    }
}
