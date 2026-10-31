package kz.kbtu.webdev.spacebountyhunters.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "hunt_logs")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HuntLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "criminal_id")
    private WantedCriminal criminal;

    private boolean success;
    private String notes;

    @Column(name = "created_at", columnDefinition = "timestamp")
    private LocalDateTime createdAt;
}
