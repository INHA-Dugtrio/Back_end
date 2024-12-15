package spring.dugtrio.domain.sensor.dto;

import jakarta.persistence.Column;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class VoltageSensorResponseDTO {
    @Getter
    public static class RecentVoltageData {
        private String sensorType;
        private BigDecimal voltage;
        private LocalDateTime createAt;

        public RecentVoltageData(LocalDateTime createAt, BigDecimal voltage) {
            this.sensorType = "VOLTAGE";
            this.createAt = createAt;
            this.voltage = voltage;
        }
    }

    @Getter
    @AllArgsConstructor
    public static class HourlyVoltageData {
        private String timeBucket;
        private BigDecimal minVoltage;
        private BigDecimal maxVoltage;
        private BigDecimal avgVoltage;
    }

}
