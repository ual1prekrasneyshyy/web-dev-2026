package kz.kbtu.webdev.hw3.dto;

import lombok.Setter;
import lombok.Getter;

@Getter
@Setter
public class SaveStudentDto {
    private String nickName;
    private String fullName;
    private double gpa;
}
