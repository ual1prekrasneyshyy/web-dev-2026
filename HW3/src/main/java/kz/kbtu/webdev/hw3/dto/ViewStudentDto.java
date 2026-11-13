package kz.kbtu.webdev.hw3.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class ViewStudentDto {
    private Long studentId;
    private String nickName;
    private String fullName;
    private double gpa;
    private String groupName;
    private List<String> takenCourses;
}
