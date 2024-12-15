package spring.dugtrio.domain.motor.dto;

import lombok.Getter;

public class MotorRequestDTO {
    @Getter
    public static class CreateMotorDTO{
        private String name;
    }

    @Getter
    public static class UpdateMotorDTO{
        private String name;
    }

}
