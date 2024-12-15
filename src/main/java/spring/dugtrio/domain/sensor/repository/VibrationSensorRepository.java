package spring.dugtrio.domain.sensor.repository;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import spring.dugtrio.domain.sensor.RPMSensor;
import spring.dugtrio.domain.sensor.VibrationSensor;
import spring.dugtrio.domain.sensor.VoltageSensor;

@Repository
public interface VibrationSensorRepository extends JpaRepository<VibrationSensor, Long> {
    @Query("SELECT s FROM VibrationSensor s WHERE s.motor.id = :motorId AND s.motor.factory.id = :factoryId AND s.createAt >= :startTime")
    List<VibrationSensor> findRecentData(
        @Param("factoryId") Long factoryId,
        @Param("motorId") Long motorId,
        @Param("startTime") LocalDateTime startTime);

    @Query("SELECT " +
        "FUNCTION('DATE_FORMAT', s.createAt, '%Y-%m-%d %H:00:00') AS timeBucket, " +
        "MIN(s.vibration_x) AS minVibrationX, " +
        "MAX(s.vibration_x) AS maxVibrationX, " +
        "ROUND(AVG(s.vibration_x), 3) AS avgVibrationX, " +
        "MIN(s.vibration_y) AS minVibrationY, " +
        "MAX(s.vibration_y) AS maxVibrationY, " +
        "ROUND(AVG(s.vibration_y), 3) AS avgVibrationY, " +
        "MIN(s.vibration_z) AS minVibrationZ, " +
        "MAX(s.vibration_z) AS maxVibrationZ, " +
        "ROUND(AVG(s.vibration_z), 3) AS avgVibrationZ " +
        "FROM VibrationSensor s " +
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
