package kz.kbtu.webdev.hw3.service;

import kz.kbtu.webdev.hw3.dto.SaveCourseDto;
import kz.kbtu.webdev.hw3.dto.ViewCourseDto;
import kz.kbtu.webdev.hw3.entity.Course;
import kz.kbtu.webdev.hw3.mapper.CourseMapper;
import kz.kbtu.webdev.hw3.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseMapper courseMapper;

    public List<ViewCourseDto> getAllCourses(){
        List<Course> courses = courseRepository.findAll();
        List<ViewCourseDto> dto = courseMapper.toDtoList(courses);
        return dto;
    }

    public ViewCourseDto getCourseById(Long id) throws Exception {
        Course course = courseRepository.findById(id).orElse(null);
        if(Objects.isNull(course)){
            throw new Exception("Course not found");
        }
        ViewCourseDto dto = courseMapper.toDto(course);
        return dto;
    }

    public ViewCourseDto addCourse(SaveCourseDto dto){
        Course course = courseMapper.toEntity(dto);
        Course savedCourse = courseRepository.save(course);
        ViewCourseDto savedDto = courseMapper.toDto(savedCourse);
        return savedDto;
    }

    public ViewCourseDto updateCourse(Long id, SaveCourseDto dto) throws Exception {
        Course course = courseRepository.findById(id).orElse(null);

        if(Objects.isNull(course)){
            throw new Exception("Course not found");
        }

        course.setCode(dto.getCourseCode());
        course.setName(dto.getCourseName());
        course.setDescription(dto.getDescription());
        course.setCredits(dto.getCredits());

        Course updatedCourse = courseRepository.save(course);
        ViewCourseDto updatedDto = courseMapper.toDto(updatedCourse);
        return updatedDto;
    }
}
