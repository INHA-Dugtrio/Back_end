package spring.dugtrio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DugtrioApplication {
    public static void main(String[] args) {
        SpringApplication.run(DugtrioApplication.class, args);
    }
}
