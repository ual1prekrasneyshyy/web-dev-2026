package kz.kbtu.webdev.midterm.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
public class ViewArticleDto {
    private Long identifier;
    private String title;
    private String content;
    private int numberOfViews;
    private LocalDateTime postDate;
}
