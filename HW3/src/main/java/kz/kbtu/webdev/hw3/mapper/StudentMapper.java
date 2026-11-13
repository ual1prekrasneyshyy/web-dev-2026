package kz.kbtu.webdev.hw3.mapper;

import kz.kbtu.webdev.hw3.dto.ViewStudentDto;
import kz.kbtu.webdev.hw3.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    @Mapping(source = "username", target = "nickName")
    @Mapping(target = "groupName", expression = "java(student.getGroup().getName())")
//    @Mapping(target = "takenCourses", expression = "java(student.getGroup().getCourses().stream().map(c -> c.getName()))")
    ViewStudentDto toDto(Student student);
}
