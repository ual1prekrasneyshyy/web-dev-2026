package kz.kbtu.webdev.hw3.mapper;

import kz.kbtu.webdev.hw3.dto.SaveCourseDto;
import kz.kbtu.webdev.hw3.dto.ViewCourseDto;
import kz.kbtu.webdev.hw3.entity.Course;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    @Mapping(source = "id", target = "courseId")
    @Mapping(source = "code", target = "courseCode")
    @Mapping(source = "name", target = "courseName")
    ViewCourseDto toDto(Course course);

    @Mapping(source = "courseCode", target = "code")
    @Mapping(source = "courseName", target = "name")
    @Mapping(target = "id", ignore = true)
    Course toEntity(SaveCourseDto dto);

    List<ViewCourseDto> toDtoList(List<Course> courses);
}
