package spring.dugtrio.domain.factory.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.dugtrio.domain.factory.Factory;

@Repository
public interface FactoryRepository extends JpaRepository<Factory, Long> {

}






