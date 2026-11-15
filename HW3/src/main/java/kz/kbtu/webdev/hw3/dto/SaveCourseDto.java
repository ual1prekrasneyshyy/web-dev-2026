package kz.kbtu.webdev.hw3.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaveCourseDto {
    private String courseCode;
    private String courseName;
    private String description;
    private int credits;
}
