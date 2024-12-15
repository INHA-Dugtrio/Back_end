package spring.dugtrio.domain.motor.controller;


import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.util.PerformanceSensitive;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.dugtrio.domain.motor.dto.MotorRequestDTO;
import spring.dugtrio.domain.motor.service.MotorService;
import spring.dugtrio.global.response.ApiResponse;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/factories/{factoryId}/motors")
public class MotorController {
    private final MotorService motorService;

    @PostMapping
    public ApiResponse<Void> createMotor(@PathVariable("factoryId") Long id, @RequestBody MotorRequestDTO.CreateMotorDTO createMotorDTO) {
        motorService.createMotor(id, createMotorDTO);
        return ApiResponse.OK;
    }

    @PatchMapping("/motorId")
    public ApiResponse<Void> updateMotor(@PathVariable("factoryId") Long factoryId, @PathVariable("motorId") Long motorId, @RequestBody MotorRequestDTO.UpdateMotorDTO updateMotorDTO) {
        motorService.updateMotor(factoryId, motorId, updateMotorDTO);
        return ApiResponse.OK;
    }

    @DeleteMapping("/motorId")
    public ApiResponse<Void> deleteMotor(@PathVariable("factoryId") Long factoryId, @PathVariable("motorid") Long motorId) {
        motorService.deleteMotor(factoryId, motorId);
        return ApiResponse.OK;
    }
}
