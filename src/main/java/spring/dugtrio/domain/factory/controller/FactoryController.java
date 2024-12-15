package spring.dugtrio.domain.factory.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.dugtrio.domain.factory.dto.FactoryRequestDTO;
import spring.dugtrio.domain.factory.service.FactoryService;
import spring.dugtrio.domain.motor.dto.MotorRequestDTO;
import spring.dugtrio.global.response.ApiResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/factories")
public class FactoryController {
    private final FactoryService factoryService;

    @PostMapping
    public ApiResponse<Void> createFactory(@RequestBody FactoryRequestDTO.CreateFactoryDTO createFactoryDTO) {
        factoryService.createFactory(createFactoryDTO);
        return ApiResponse.OK;
    }


    @DeleteMapping("/{factoryId}")
    public ApiResponse<Void> deleteFactory(@PathVariable("factoryId") Long id) {
        factoryService.deleteFactory(id);
        return ApiResponse.OK;
    }

    @PatchMapping("/{factoryId}")
    public ApiResponse<Void> updateFactory(@PathVariable("factoryId") Long id, @RequestBody FactoryRequestDTO.UpdateFactoryDTO updateFactoryDTO) {
        factoryService.updateFactory(id, updateFactoryDTO);
        return ApiResponse.OK;
    }

}
