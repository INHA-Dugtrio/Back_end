package spring.dugtrio.domain.alarm.controller;

import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.dugtrio.domain.alarm.dto.AlarmResponseDTO;
import spring.dugtrio.domain.alarm.dto.AlarmResponseDTO.AlarmData;
import spring.dugtrio.domain.alarm.service.AlarmService;
import spring.dugtrio.global.response.ApiResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/alarms")
public class AlarmController {
    private final AlarmService alarmService;

    @GetMapping
    public ApiResponse<List<AlarmResponseDTO.AlarmData>> getAllAlarmData(){
        List<AlarmResponseDTO.AlarmData> data = alarmService.getAllAlarmData();
        return ApiResponse.onSuccess(data);
    }
}
