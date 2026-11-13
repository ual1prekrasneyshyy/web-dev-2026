package kz.kbtu.webdev.hw3.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "groups")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Group extends BaseEntity {
    private String name;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Course> courses;

    @OneToMany(mappedBy = "group", fetch = FetchType.EAGER)
    private Set<Student> students;
}
