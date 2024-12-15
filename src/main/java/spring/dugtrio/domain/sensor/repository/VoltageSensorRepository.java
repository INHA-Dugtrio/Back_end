package spring.dugtrio.domain.sensor.repository;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import spring.dugtrio.domain.sensor.RPMSensor;
import spring.dugtrio.domain.sensor.VoltageSensor;

@Repository
public interface VoltageSensorRepository extends JpaRepository<VoltageSensor, Long> {
    @Query("SELECT s FROM VoltageSensor s WHERE s.motor.id = :motorId AND s.motor.factory.id = :factoryId AND s.createAt >= :startTime")
    List<VoltageSensor> findRecentData(
        @Param("factoryId") Long factoryId,
        @Param("motorId") Long motorId,
        @Param("startTime") LocalDateTime startTime);

    @Query ("SELECT " +
        "FUNCTION('DATE_FORMAT', s.createAt, '%Y-%m-%d %H:00:00') AS timeBucket, " +
        "MIN(s.voltage) AS minRpm, " +
        "MAX(s.voltage) AS maxRpm, " +
        "ROUND(AVG(s.voltage), 2) AS avgRpm " +
        "FROM VoltageSensor s " +
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
