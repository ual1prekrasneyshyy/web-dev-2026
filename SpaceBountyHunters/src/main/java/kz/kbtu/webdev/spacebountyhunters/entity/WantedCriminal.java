package kz.kbtu.webdev.spacebountyhunters.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "wanted_criminals")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class WantedCriminal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false, unique = true)
    private String nickname;
    private int reward;
    ///
    private int difficulty;
    private boolean armed;

    @Column(name = "has_crew")
    private boolean hasCrew;

    @Column(name = "escape_master")
    private boolean escapeMaster;
}
