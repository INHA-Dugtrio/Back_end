package spring.dugtrio.domain.alarm.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

public class AlarmResponseDTO {

    @Setter
    @Getter
    public static class AlarmData{
        private String sensorType;
        private BigDecimal value;
        private LocalDateTime createAt;
    }
}
