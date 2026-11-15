package kz.kbtu.webdev.hw3.service;

import kz.kbtu.webdev.hw3.dto.JoinGroupDto;
import kz.kbtu.webdev.hw3.dto.SaveStudentDto;
import kz.kbtu.webdev.hw3.dto.ViewStudentDto;
import kz.kbtu.webdev.hw3.entity.Group;
import kz.kbtu.webdev.hw3.entity.Student;
import kz.kbtu.webdev.hw3.mapper.StudentMapper;
import kz.kbtu.webdev.hw3.repository.GroupRepository;
import kz.kbtu.webdev.hw3.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private StudentMapper studentMapper;

    public List<ViewStudentDto> getAllStudents(){
        List<Student> students = studentRepository.findAll();
        List<ViewStudentDto> dto = studentMapper.toDtoList(students);
        return dto;
    }

    public ViewStudentDto getStudentById(Long id) throws Exception {
        Student student = studentRepository.findById(id).orElse(null);
        if(Objects.isNull(student)) {
            throw new Exception("Student not found");
        }
        ViewStudentDto dto = studentMapper.toDto(student);
        return dto;
    }

    public ViewStudentDto addStudent(SaveStudentDto dto){
        Student newStudent = studentMapper.toEntity(dto);
        Student savedStudent = studentRepository.save(newStudent);
        ViewStudentDto savedDto = studentMapper.toDto(savedStudent);
        return savedDto;
    }

    public ViewStudentDto updateStudent(Long id, SaveStudentDto dto) throws Exception {
        Student student = studentRepository.findById(id).orElse(null);
        if(Objects.isNull(student)) {
            throw new Exception("Student not found");
        }
        student.setUsername(dto.getNickName());
        student.setFullName(dto.getFullName());
        student.setGpa(dto.getGpa());
        Student savedStudent = studentRepository.save(student);
        ViewStudentDto savedDto = studentMapper.toDto(savedStudent);
        return savedDto;
    }

    public void deleteStudent(Long id) throws Exception {
        Student student = studentRepository.findById(id).orElse(null);
        if(Objects.isNull(student)) {
            throw new Exception("Student not found");
        }
        studentRepository.deleteById(id);
    }

    public ViewStudentDto joinGroup(JoinGroupDto dto) throws Exception {
        Student student = studentRepository.findById(dto.getStudentId()).orElse(null);
        if(Objects.isNull(student)) {
            throw new Exception("Student not found");
        }
        if(Objects.nonNull(student.getGroup())){
            throw new Exception("Student already join to the group: " + student.getGroup().getName());
        }
        Group group = groupRepository.findById(dto.getGroupId()).orElse(null);
        if(Objects.isNull(group)) {
            throw new Exception("Group not found");
        }
        student.setGroup(group);
        Student studentWithGroup = studentRepository.save(student);
        ViewStudentDto updatedDto = studentMapper.toDto(studentWithGroup);
        return updatedDto;
    }
}
