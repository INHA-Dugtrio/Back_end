package spring.dugtrio.domain.sensor.dto;

import jakarta.persistence.Column;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

public class RPMSensorResponseDTO {

    @Getter
    public static class RecentRPMData {
        private String sensorType;
        private BigDecimal rpm;
        private LocalDateTime createAt;

        public RecentRPMData(LocalDateTime createAt, BigDecimal rpm) {
            this.sensorType = "RPM";
            this.createAt = createAt;
            this.rpm = rpm;
        }
    }

    @Getter
    @AllArgsConstructor
    public static class HourlyRPMData {
        private String timeBucket;
        private BigDecimal minRpm;
        private BigDecimal maxRpm;
        private BigDecimal avgRpm;


    }

}
