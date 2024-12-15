package spring.dugtrio.domain.sensor.controller;

import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.dugtrio.domain.sensor.dto.RPMSensorResponseDTO;
import spring.dugtrio.domain.sensor.dto.TemperatureSensorResponseDTO;
import spring.dugtrio.domain.sensor.service.SensorService;
import spring.dugtrio.global.response.ApiResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/factories/{factoryId}/motors/{motorId}/sensors")
public class SensorController {

    private final SensorService sensorService;

    @GetMapping("/{sensorType}/recent")
    public ApiResponse<List<?>> getRecentSensorData(
        @PathVariable("factoryId") Long factoryId,
        @PathVariable("motorId") Long motorId,
        @PathVariable("sensorType") String sensorType) {

        List<?> data = sensorService.getRecentSensorData(sensorType, factoryId, motorId);
        return ApiResponse.onSuccess(data);

    }

    @GetMapping("/{sensorType}/hourly")
    public ApiResponse<List<?>> getHourlyRPMData(
        @PathVariable("factoryId") Long factoryId,
        @PathVariable("motorId") Long motorId,
        @PathVariable("sensorType") String sensorType) {

        List<?> data = sensorService.getHourlySensorData(sensorType,factoryId, motorId);

        return ApiResponse.onSuccess(data);
    }
}
