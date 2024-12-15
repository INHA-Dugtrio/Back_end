package spring.dugtrio.domain.factory.service;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.dugtrio.domain.factory.Factory;
import spring.dugtrio.domain.factory.dto.FactoryRequestDTO;
import spring.dugtrio.domain.factory.repository.FactoryRepository;
import spring.dugtrio.domain.motor.dto.MotorRequestDTO;
import spring.dugtrio.domain.motor.service.MotorService;

@Service
@RequiredArgsConstructor
public class FactoryService {
    private final FactoryRepository factoryRepository;

    public void createFactory(FactoryRequestDTO.CreateFactoryDTO createFactoryDTO) {
        Factory factory = Factory.builder()
            .name(createFactoryDTO.getName())
            .build();
        factoryRepository.save(factory);
    }


    public void deleteFactory(Long id) {
        factoryRepository.deleteById(id);
    }

    public void updateFactory(Long id, FactoryRequestDTO.UpdateFactoryDTO updateFactoryDTO) {
        Factory factory = factoryRepository.findById(id).get();

        String name = updateFactoryDTO.getName();
        factory.updateFactory(name);

        factoryRepository.save(factory);
    }
}
