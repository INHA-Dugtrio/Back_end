package spring.dugtrio.domain.sensor.repository;

import java.awt.print.Pageable;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import spring.dugtrio.domain.sensor.RPMSensor;
import spring.dugtrio.domain.sensor.TemperatureSensor;
import spring.dugtrio.domain.sensor.dto.RPMSensorResponseDTO;

@Repository
public interface RPMSensorRepository extends JpaRepository<RPMSensor, Long> {
    @Query("SELECT s FROM RPMSensor s WHERE s.motor.id = :motorId AND s.motor.factory.id = :factoryId AND s.createAt >= :startTime")
    List<RPMSensor> findRecentData(
        @Param("factoryId") Long factoryId,
        @Param("motorId") Long motorId,
        @Param("startTime") LocalDateTime startTime);

    @Query ("SELECT " +
        "FUNCTION('DATE_FORMAT', s.createAt, '%Y-%m-%d %H:00:00') AS timeBucket, " +
        "MIN(s.rpm) AS minRpm, " +
        "MAX(s.rpm) AS maxRpm, " +
        "ROUND(AVG(s.rpm), 2) AS avgRpm " +
        "FROM RPMSensor s " +
        "WHERE s.motor.id = :motorId " +
        "AND s.motor.factory.id = :factoryId " +
        "AND s.createAt >= :startDate AND s.createAt < :endDate " +
        "GROUP BY FUNCTION('DATE_FORMAT', s.createAt, '%Y-%m-%d %H:00:00') " +
        "ORDER BY FUNCTION('DATE_FORMAT', s.createAt, '%Y-%m-%d %H:00:00') ASC")
    List<Object[]> findHourlyData(
        @Param("factoryId") Long factoryId,
        @Param("motorId") Long motorId,
        @Param("startDate") LocalDateTime startDate,
        @Param("endDate") LocalDateTime endDate);
}
