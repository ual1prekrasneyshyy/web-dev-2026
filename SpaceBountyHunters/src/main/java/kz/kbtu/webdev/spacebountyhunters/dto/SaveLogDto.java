package kz.kbtu.webdev.spacebountyhunters.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class SaveLogDto {
    private Long criminalId;
    private Boolean success;
    private String notes;
}
