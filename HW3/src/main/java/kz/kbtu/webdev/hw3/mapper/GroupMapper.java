package kz.kbtu.webdev.hw3.mapper;

import kz.kbtu.webdev.hw3.dto.SaveGroupDto;
import kz.kbtu.webdev.hw3.dto.ViewGroupDto;
import kz.kbtu.webdev.hw3.entity.Course;
import kz.kbtu.webdev.hw3.entity.Group;
import kz.kbtu.webdev.hw3.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface GroupMapper {
    @Mapping(source = "id", target = "groupId")
    @Mapping(source = "name", target = "groupName")
    @Mapping(target = "courses", expression = "java(coursesNames(group.getCourses()))")
    @Mapping(target = "students", expression = "java(studentsNames(group.getStudents()))")
    @Mapping(target = "averageGpa", expression = "java(getAverageGpa(group.getStudents()))")
    ViewGroupDto toDto(Group group);

    @Mapping(source = "groupName", target = "name")
    @Mapping(target = "courses", ignore = true)
    @Mapping(target = "students", ignore = true)
    @Mapping(target = "id", ignore = true)
    Group toEntity(SaveGroupDto dto);

    List<ViewGroupDto> toDtoList(List<Group> groups);

    default Set<String> coursesNames(Set<Course> courses) {
        return courses.stream().map(Course::getName).collect(Collectors.toSet());
    }

    default Set<String> studentsNames(Set<Student> students) {
        return students.stream().map(Student::getFullName).collect(Collectors.toSet());
    }

    default double getAverageGpa(Set<Student> students) {
        return students.stream().mapToDouble(Student::getGpa).average().orElse(0.0);
    }
}
