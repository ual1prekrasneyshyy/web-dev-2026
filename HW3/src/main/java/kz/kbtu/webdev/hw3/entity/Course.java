package kz.kbtu.webdev.hw3.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "courses")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen-course-id")
    @SequenceGenerator(name = "gen-course-id", sequenceName = "courses_id_seq", allocationSize = 1)
    private Long id;
    private String code;
    private String name;
    private String description;
    private int credits;
}
