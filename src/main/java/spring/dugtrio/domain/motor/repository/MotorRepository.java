package spring.dugtrio.domain.motor.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.dugtrio.domain.motor.Motor;

@Repository
public interface MotorRepository extends JpaRepository<Motor, Long> {
    Optional<Motor> findByIdAndFactoryId(Long id, Long factoryId);
}
