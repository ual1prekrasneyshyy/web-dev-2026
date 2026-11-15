package kz.kbtu.webdev.hw3.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "groups")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen-gr-id")
    @SequenceGenerator(name = "gen-gr-id", sequenceName = "groups_id_seq", allocationSize = 1)
    private Long id;
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "groups_courses",
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private Set<Course> courses = new HashSet<>();

    @OneToMany(mappedBy = "group", fetch = FetchType.EAGER)
    private Set<Student> students = new HashSet<>();
}
