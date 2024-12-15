package spring.dugtrio.domain.sensor.dto;

import jakarta.persistence.Column;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;


public class TemperatureSensorResponseDTO {
    @Getter
    public static class RecentTemperatureData {
        private String sensorType;
        private BigDecimal temperature;
        private LocalDateTime createAt;

        public RecentTemperatureData(LocalDateTime createAt, BigDecimal temperature) {
            this.sensorType = "TEMPERATURE";
            this.createAt = createAt;
            this.temperature = temperature;
        }
    }

    @Getter
    @AllArgsConstructor
    public static class HourlyTemperatureData {
        private String timeBucket;
        private BigDecimal minTemperature;
        private BigDecimal maxTemperature;
        private BigDecimal avgTemperature;
    }
}
