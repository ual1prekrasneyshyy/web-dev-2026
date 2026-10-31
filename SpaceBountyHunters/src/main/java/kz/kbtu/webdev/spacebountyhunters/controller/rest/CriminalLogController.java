package kz.kbtu.webdev.spacebountyhunters.controller.rest;

import kz.kbtu.webdev.spacebountyhunters.dto.CriminalDto;
import kz.kbtu.webdev.spacebountyhunters.entity.WantedCriminal;
import kz.kbtu.webdev.spacebountyhunters.service.CriminalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/criminals/")
public class CriminalLogController {
    @Autowired
    private CriminalService criminalService;

    @GetMapping
    public ResponseEntity<?> getCriminals(
            @RequestParam(name = "min_reward", required = false) Integer minReward,
            @RequestParam(name = "max_reward", required = false) Integer maxReward,
            @RequestParam(name = "armed", required = false) Boolean armed,
            @RequestParam(name = "has_crew", required = false) Boolean hasCrew,
            @RequestParam(name = "escape_master", required = false) Boolean master,
            @RequestParam(name = "sort", required = false) String sortOrder
    ) {
        List<WantedCriminal> criminals = criminalService.getAllCriminals(minReward, maxReward, armed, hasCrew, master, sortOrder);

        if(criminals.isEmpty()){
            return new ResponseEntity<>("List is empty", HttpStatus.OK);
        }

        return new ResponseEntity<>(criminals, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCriminalById(@PathVariable Long id) {
        WantedCriminal criminal = criminalService.getCriminalById(id);

        if(Objects.isNull(criminal)){
            return new ResponseEntity<>("Criminal not found", HttpStatus.OK);
        }

        return new ResponseEntity<>(criminal, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addCriminal(@RequestBody CriminalDto dto) {
        WantedCriminal criminal = criminalService.addCriminal(dto);

        if(Objects.isNull(criminal)){
            return new ResponseEntity<>("Criminal not found", HttpStatus.OK);
        }

        return new ResponseEntity<>(criminal, HttpStatus.OK);
    }
}
