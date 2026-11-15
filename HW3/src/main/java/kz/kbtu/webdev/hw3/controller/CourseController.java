package kz.kbtu.webdev.hw3.controller;

import kz.kbtu.webdev.hw3.dto.SaveCourseDto;
import kz.kbtu.webdev.hw3.dto.ViewCourseDto;
import kz.kbtu.webdev.hw3.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping
    public ResponseEntity<?> getAllCourses(){
        try {
            List<ViewCourseDto> courses = courseService.getAllCourses();
            return ResponseEntity.ok(courses);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCourseById(@PathVariable("id") Long id){
        try {
            ViewCourseDto course = courseService.getCourseById(id);
            return ResponseEntity.ok(course);
        }catch (Exception e){
            if (e.getMessage().equals("Course not found")) {
                return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<?> addCourse(@RequestBody SaveCourseDto dto){
        try{
            ViewCourseDto addedCourse = courseService.addCourse(dto);
            return ResponseEntity.ok(addedCourse);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCourse(@PathVariable("id") Long id, @RequestBody SaveCourseDto dto){
        try {
            ViewCourseDto updatedCourse = courseService.updateCourse(id, dto);
            return ResponseEntity.ok(updatedCourse);
        }catch (Exception e){
            if (e.getMessage().equals("Course not found")) {
                return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
