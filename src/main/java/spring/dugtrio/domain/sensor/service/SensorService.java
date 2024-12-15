package spring.dugtrio.domain.sensor.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.cglib.core.Local;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import spring.dugtrio.domain.sensor.RPMSensor;
import spring.dugtrio.domain.sensor.TemperatureSensor;
import spring.dugtrio.domain.sensor.VoltageSensor;
import spring.dugtrio.domain.sensor.dto.RPMSensorResponseDTO;
import spring.dugtrio.domain.sensor.dto.TemperatureSensorResponseDTO;
import spring.dugtrio.domain.sensor.dto.VibrationSensorResponseDTO;
import spring.dugtrio.domain.sensor.dto.VoltageSensorResponseDTO;
import spring.dugtrio.domain.sensor.repository.RPMSensorRepository;
import spring.dugtrio.domain.sensor.repository.TemperatureSensorRepository;
import spring.dugtrio.domain.sensor.repository.VibrationSensorRepository;
import spring.dugtrio.domain.sensor.repository.VoltageSensorRepository;

@Service
@RequiredArgsConstructor
public class SensorService {
    private final TemperatureSensorRepository temperatureSensorRepository;
    private final RPMSensorRepository rpmSensorRepository;
    private final VibrationSensorRepository vibrationSensorRepository;
    private final VoltageSensorRepository voltageSensorRepository;

    public List<?> getHourlySensorData(String sensorType, Long factoryId, Long motorId) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime startDate = now.withHour(0).withMinute(0).withSecond(0); // 오늘 00:00
        LocalDateTime endDate = now.minusHours(1).withMinute(59).withSecond(59);          // 현재 시간 직전 1시간

        switch (sensorType.toLowerCase()) {
            case "rpm":
                return rpmSensorRepository.findHourlyData(factoryId, motorId, startDate, endDate)
                    .stream()
                    .map(row -> new RPMSensorResponseDTO.HourlyRPMData(
                        (String) row[0],
                        (BigDecimal) row[1],
                        (BigDecimal) row[2],
                        BigDecimal.valueOf((Double) row[3])
                    ))
                    .collect(Collectors.toList());
            case "temperature":
                return temperatureSensorRepository.findHourlyData(factoryId, motorId, startDate, endDate)
                    .stream()
                    .map(row -> new TemperatureSensorResponseDTO.HourlyTemperatureData(
                        (String) row[0],
                        (BigDecimal) row[1],
                        (BigDecimal) row[2],
                        BigDecimal.valueOf((Double) row[3])
                    ))
                    .collect(Collectors.toList());
            case "vibration":
                return vibrationSensorRepository.findHourlyData(factoryId, motorId, startDate, endDate)
                    .stream()
                    .map(row -> new VibrationSensorResponseDTO.HourlyVibrationData(
                        (String) row[0],
                        (BigDecimal) row[1],
                        (BigDecimal) row[2],
                        BigDecimal.valueOf((Double) row[3]),
                        (BigDecimal) row[4],
                        (BigDecimal) row[5],
                        BigDecimal.valueOf((Double) row[6]),
                        (BigDecimal) row[7],
                        (BigDecimal) row[8],
                        BigDecimal.valueOf((Double) row[9])
                    ))
                    .collect(Collectors.toList());
            case "voltage":
                return voltageSensorRepository.findHourlyData(factoryId, motorId, startDate, endDate)
                    .stream()
                    .map(row -> new VoltageSensorResponseDTO.HourlyVoltageData(
                        (String) row[0],
                        (BigDecimal) row[1],
                        (BigDecimal) row[2],
                        BigDecimal.valueOf((Double) row[3])
                    ))
                    .collect(Collectors.toList());
            default:
                throw new IllegalArgumentException("Invalid sensor type: " + sensorType);
        }
    }



    public List<?> getRecentSensorData(String sensorType, Long factoryId, Long motorId) {
        LocalDateTime startTime = LocalDateTime.now().minusSeconds(30);
        switch (sensorType.toLowerCase()) {
            case "rpm":
                return rpmSensorRepository.findRecentData(factoryId, motorId, startTime)
                    .stream()
                    .map(sensor -> new RPMSensorResponseDTO.RecentRPMData(sensor.getCreateAt(),
                        sensor.getRpm()))
                    .collect(Collectors.toList());
            case "temperature":
                return temperatureSensorRepository.findRecentData(factoryId, motorId, startTime)
                    .stream()
                    .map(sensor -> new TemperatureSensorResponseDTO.RecentTemperatureData(
                        sensor.getCreateAt(), sensor.getTemperature()))
                    .collect(Collectors.toList());
            case "vibrationx":
                return vibrationSensorRepository.findRecentData(factoryId, motorId, startTime)
                    .stream()
                    .map(sensor -> new VibrationSensorResponseDTO.RecentVibrationXData(
                        sensor.getCreateAt(),sensor.getVibration_x()))
                    .collect(Collectors.toList());
            case "vibrationy":
                return vibrationSensorRepository.findRecentData(factoryId, motorId, startTime)
                    .stream()
                    .map(sensor -> new VibrationSensorResponseDTO.RecentVibrationYData(
                        sensor.getCreateAt(),sensor.getVibration_y()))
                    .collect(Collectors.toList());
            case "vibrationz":
                return vibrationSensorRepository.findRecentData(factoryId, motorId, startTime)
                    .stream()
                    .map(sensor -> new VibrationSensorResponseDTO.RecentVibrationZData(
                        sensor.getCreateAt(),sensor.getVibration_z()))
                    .collect(Collectors.toList());
            case "voltage":
                return voltageSensorRepository.findRecentData(factoryId, motorId, startTime)
                    .stream()
                    .map(sensor -> new VoltageSensorResponseDTO.RecentVoltageData(
                        sensor.getCreateAt(), sensor.getVoltage()))
                    .collect(Collectors.toList());
            default:
                throw new IllegalArgumentException("Invalid sensor type: " + sensorType);
        }
    }
}
