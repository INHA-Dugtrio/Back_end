package spring.dugtrio.domain.motor.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.dugtrio.domain.factory.Factory;
import spring.dugtrio.domain.factory.repository.FactoryRepository;
import spring.dugtrio.domain.motor.Motor;
import spring.dugtrio.domain.motor.dto.MotorRequestDTO;
import spring.dugtrio.domain.motor.repository.MotorRepository;

@Service
@RequiredArgsConstructor
public class MotorService {
    private final MotorRepository motorRepository;
    private final FactoryRepository factoryRepository;

    public void createMotor(Long id, MotorRequestDTO.CreateMotorDTO motorDTO) {
        Factory factory = factoryRepository.findById(id).get();
        Motor motor = Motor.builder()
            .name(motorDTO.getName())
            .factory(factory)
            .build();
        motorRepository.save(motor);
    }

    public void updateMotor(Long factoryId, Long motorId, MotorRequestDTO.UpdateMotorDTO motorDTO) {
        Motor motor = motorRepository.findByIdAndFactoryId(factoryId,motorId).get();
        motor.updateMotor(motorDTO.getName());
        motorRepository.save(motor);
    }

    public void deleteMotor(Long factoryId, Long motorId) {
        Motor motor = motorRepository.findByIdAndFactoryId(factoryId,motorId).get();
        motorRepository.delete(motor);
    }
}
