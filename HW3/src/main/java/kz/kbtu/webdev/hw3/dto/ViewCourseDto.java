package kz.kbtu.webdev.hw3.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.Set;

@Builder
@Getter
public class ViewCourseDto {
    private Long courseId;
    private String courseCode;
    private String courseName;
    private String description;
    private int credits;
}
