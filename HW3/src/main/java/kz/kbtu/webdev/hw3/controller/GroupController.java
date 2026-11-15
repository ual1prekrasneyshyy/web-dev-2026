package kz.kbtu.webdev.hw3.controller;

import kz.kbtu.webdev.hw3.dto.SaveGroupDto;
import kz.kbtu.webdev.hw3.dto.TakeCourseDto;
import kz.kbtu.webdev.hw3.dto.ViewGroupDto;
import kz.kbtu.webdev.hw3.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groups")
public class GroupController {
    @Autowired
    private GroupService groupService;

    @GetMapping
    public ResponseEntity<?> getAllGroups(){
        try{
            List<ViewGroupDto> groups = groupService.getAllGroups();
            return ResponseEntity.ok(groups);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getGroupById(@PathVariable Long id){
        try{
            ViewGroupDto group = groupService.getGroupById(id);
            return ResponseEntity.ok(group);
        }catch (Exception e){
            if(e.getMessage().equals("Group not found")){
                return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<?> addGroup(@RequestBody SaveGroupDto dto){
        try{
            ViewGroupDto addedGroup = groupService.addGroup(dto);
            return ResponseEntity.ok(addedGroup);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateGroup(@PathVariable Long id, @RequestBody SaveGroupDto dto){
        try{
            ViewGroupDto updatedGroup = groupService.updateGroup(id, dto);
            return ResponseEntity.ok(updatedGroup);
        }catch (Exception e){
            if(e.getMessage().equals("Group not found")){
                return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/take-course")
    public ResponseEntity<?> takeCourse(@RequestBody TakeCourseDto dto){
        try{
            ViewGroupDto groupWithNewCourse = groupService.takeCourse(dto);
            return ResponseEntity.ok(groupWithNewCourse);
        }catch (Exception e){
            if(e.getMessage().equals("Group not found") || e.getMessage().equals("Course not found")){
                return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
