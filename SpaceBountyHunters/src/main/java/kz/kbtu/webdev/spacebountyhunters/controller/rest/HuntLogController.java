package kz.kbtu.webdev.spacebountyhunters.controller.rest;

import kz.kbtu.webdev.spacebountyhunters.dto.SaveLogDto;
import kz.kbtu.webdev.spacebountyhunters.entity.HuntLog;
import kz.kbtu.webdev.spacebountyhunters.service.HuntLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/hunts/")
public class HuntLogController {
    @Autowired
    private HuntLogService huntLogService;

    @GetMapping
    public ResponseEntity<?> getAllLogs(@RequestParam(name = "criminal_id", required = false) Long criminalId){
        List<HuntLog> logs = huntLogService.getAllLogs(criminalId);

        if(logs.isEmpty()) {
            return new ResponseEntity<>("Logs absent", HttpStatus.NO_CONTENT);
        }

        return  new ResponseEntity<>(logs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getLog(@PathVariable Long id) {
        HuntLog log = huntLogService.getLog(id);

        if(Objects.isNull(log)) {
            return new ResponseEntity<>("Log not found", HttpStatus.NOT_FOUND);
        }

        return new  ResponseEntity<>(log, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addLog(@RequestBody SaveLogDto dto) {
        HuntLog log = huntLogService.addLog(dto);

        if(Objects.isNull(log)) {
            return new ResponseEntity<>("Criminal not found", HttpStatus.NOT_FOUND);
        }

        return new  ResponseEntity<>(log, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> addLog(@PathVariable Long id, @RequestBody SaveLogDto dto) {
        HuntLog log = huntLogService.updateLog(id, dto);

        if(Objects.isNull(log)) {
            return new ResponseEntity<>("Log not found", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(log, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteLog(@PathVariable Long id) {
        boolean deleted = huntLogService.deleteLog(id);

        if(deleted) {
            return new  ResponseEntity<>("log has been deleted", HttpStatus.OK);
        }

        return new ResponseEntity<>("Log not found", HttpStatus.NOT_FOUND);
    }
}
