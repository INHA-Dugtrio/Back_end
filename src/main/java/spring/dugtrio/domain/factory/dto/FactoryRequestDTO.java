package spring.dugtrio.domain.factory.dto;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;


public class FactoryRequestDTO {

    @Getter
    public static class CreateFactoryDTO {
        private String name;
    }

    @Getter
    public static class UpdateFactoryDTO {
        private String name;
    }

}
