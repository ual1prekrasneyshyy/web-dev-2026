package kz.kbtu.webdev.midterm.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class SaveArticleDto {
    private String title;
    private String content;
}
