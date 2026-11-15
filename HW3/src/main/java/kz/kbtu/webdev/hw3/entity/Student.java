package kz.kbtu.webdev.hw3.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "students")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen-st-id")
    @SequenceGenerator(name = "gen-st-id", sequenceName = "students_id_seq", allocationSize = 1)
    private Long id;
    private String username;
    @Column(name = "full_name")
    private String fullName;
    private double gpa;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "group_id")
    private Group group;
}
