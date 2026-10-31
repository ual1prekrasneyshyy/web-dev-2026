package kz.kbtu.webdev.spacebountyhunters.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CriminalDto {
    private String name;
    private String nickname;
    private int reward;
    private String lastKnownCoordinate;
    private int difficulty;
    private boolean armed;
    private boolean hasCrew;
    private boolean escapeMaster;
}
