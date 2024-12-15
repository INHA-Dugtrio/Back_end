package spring.dugtrio.domain.sensor.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class VibrationSensorResponseDTO {
    @Getter
    public static class RecentVibrationXData {
        private String sensorType;
        private BigDecimal vibration_x;
        private LocalDateTime createAt;

        public RecentVibrationXData(LocalDateTime createAt, BigDecimal vibrationX) {
            this.sensorType = "VIBRATION_X";
            this.createAt = createAt;
            this.vibration_x = vibrationX;
        }
    }

    @Getter
    public static class RecentVibrationYData {
        private String sensorType;
        private BigDecimal vibration_y;
        private LocalDateTime createAt;

        public RecentVibrationYData(LocalDateTime createAt, BigDecimal vibrationY) {
            this.sensorType = "VIBRATION_Y";
            this.createAt = createAt;
            this.vibration_y = vibrationY;
        }
    }

    @Getter
    public static class RecentVibrationZData {
        private String sensorType;
        private BigDecimal vibration_z;
        private LocalDateTime createAt;

        public RecentVibrationZData(LocalDateTime createAt, BigDecimal vibrationZ) {
            this.sensorType = "VIBRATION_Z";
            this.createAt = createAt;
            this.vibration_z = vibrationZ;
        }
    }

    @Getter
    @AllArgsConstructor
    public static class HourlyVibrationData {
        private String timeBucket;
        private BigDecimal minVibrationX;
        private BigDecimal maxVibrationX;
        private BigDecimal avgVibrationX;
        private BigDecimal minVibrationY;
        private BigDecimal maxVibrationY;
        private BigDecimal avgVibrationY;
        private BigDecimal minVibrationZ;
        private BigDecimal maxVibrationZ;
        private BigDecimal avgVibrationZ;
    }

}
