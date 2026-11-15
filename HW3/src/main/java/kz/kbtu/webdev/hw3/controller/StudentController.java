package kz.kbtu.webdev.hw3.controller;

import kz.kbtu.webdev.hw3.dto.JoinGroupDto;
import kz.kbtu.webdev.hw3.dto.SaveStudentDto;
import kz.kbtu.webdev.hw3.dto.ViewGroupDto;
import kz.kbtu.webdev.hw3.dto.ViewStudentDto;
import kz.kbtu.webdev.hw3.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public ResponseEntity<?> getStudents(){
        try{
            List<ViewStudentDto> students = studentService.getAllStudents();
            return ResponseEntity.ok(students);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable Long id){
        try{
            ViewStudentDto student = studentService.getStudentById(id);
            return ResponseEntity.ok(student);
        }catch (Exception e){
            if(e.getMessage().equals("Student not found")){
                return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<?> addStudent(@RequestBody SaveStudentDto dto){
        try{
            ViewStudentDto newStudent = studentService.addStudent(dto);
            return ResponseEntity.ok(newStudent);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable Long id, @RequestBody SaveStudentDto dto){
        try{
            ViewStudentDto updatedStudent = studentService.updateStudent(id, dto);
            return ResponseEntity.ok(updatedStudent);
        }catch (Exception e){
            if(e.getMessage().equals("Student not found")){
                return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long id){
        try{
            studentService.deleteStudent(id);
            return ResponseEntity.ok("Student has been successfully deleted");
        }catch (Exception e){
            if(e.getMessage().equals("Student not found")){
                return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/join-group")
    public ResponseEntity<?> joinGroup(@RequestBody JoinGroupDto dto){
        try{
            ViewStudentDto studentWithGroup = studentService.joinGroup(dto);
            return ResponseEntity.ok(studentWithGroup);
        }catch (Exception e){
            if(e.getMessage().equals("Student not found") || e.getMessage().equals("Group not found")) {
                return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
            }
            if(e.getMessage().startsWith("Student already join to the group:")) {
                return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
