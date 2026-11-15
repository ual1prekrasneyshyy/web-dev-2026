package kz.kbtu.webdev.hw3.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.Set;

@Builder
@Getter
public class ViewGroupDto {
    private Long groupId;
    private String groupName;
    private Set<String> students;
    private Set<String> courses;
    private double averageGpa;
}
