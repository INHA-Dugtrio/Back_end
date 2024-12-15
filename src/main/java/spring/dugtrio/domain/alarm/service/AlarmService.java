package spring.dugtrio.domain.alarm.service;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.dugtrio.domain.alarm.dto.AlarmResponseDTO;
import spring.dugtrio.domain.alarm.dto.AlarmResponseDTO.AlarmData;
import spring.dugtrio.domain.alarm.repository.AlarmRepository;

@Service
@RequiredArgsConstructor
public class AlarmService {
    private final AlarmRepository alarmRepository;

    public List<AlarmResponseDTO.AlarmData> getAllAlarmData() {
        return alarmRepository.findAllByOrderByCreateAtDesc().stream().map(alarm -> {
            AlarmResponseDTO.AlarmData alarmData = new AlarmResponseDTO.AlarmData();
            alarmData.setSensorType(alarm.getSensorType());
            alarmData.setValue(alarm.getValue());
            alarmData.setCreateAt(alarm.getCreateAt());
            return alarmData;
        }).collect(Collectors.toList());
    }
}
