package kz.kbtu.webdev.hw3.mapper;

import kz.kbtu.webdev.hw3.dto.SaveStudentDto;
import kz.kbtu.webdev.hw3.dto.ViewStudentDto;
import kz.kbtu.webdev.hw3.entity.Course;
import kz.kbtu.webdev.hw3.entity.Group;
import kz.kbtu.webdev.hw3.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    @Mapping(source = "id", target = "studentId")
    @Mapping(source = "username", target = "nickName")
    @Mapping(target = "groupName", expression = "java(getGroupName(student))")
    @Mapping(target = "takenCourses", expression = "java(coursesNames(student))")
    ViewStudentDto toDto(Student student);

    @Mapping(source = "nickName", target = "username")
    @Mapping(target = "group", ignore = true)
    @Mapping(target = "id", ignore = true)
    Student toEntity(SaveStudentDto dto);

    List<ViewStudentDto> toDtoList(List<Student> students);

    default Set<String> coursesNames(Student student) {
        Group group = student.getGroup();
        if(Objects.isNull(group)){
            return new HashSet<>();
        }
        return group.getCourses().stream().map(Course::getName).collect(Collectors.toSet());
    }

    default String getGroupName(Student student){
        Group group = student.getGroup();
        if(Objects.isNull(group)){
            return "No group";
        }
        return group.getName();
    }
}
