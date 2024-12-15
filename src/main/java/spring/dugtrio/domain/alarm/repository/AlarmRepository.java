package spring.dugtrio.domain.alarm.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.dugtrio.domain.alarm.Alarm;

@Repository
public interface AlarmRepository extends JpaRepository<Alarm, Long> {
    List<Alarm> findAllByOrderByCreateAtDesc();
}
