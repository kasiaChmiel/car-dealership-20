package pl.zajavka.api.infrastructure.database.repository.jpa;

import lombok.AllArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.TestPropertySource;
import pl.zajavka.infrastructure.database.entity.CarToBuyEntity;
import pl.zajavka.infrastructure.database.repository.jpa.CarToBuyJpaRepository;
import pl.zajavka.integration.configuration.PersistenceContainerTestConfiguration;
import pl.zajavka.util.EntityFixtures;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@TestPropertySource(locations = "classpath:application-test.yaml")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import(PersistenceContainerTestConfiguration.class) //konfiguracja dotycząca testcontainers
@AllArgsConstructor(onConstructor = @__(@Autowired))
class CarToBuyJpaRepositoryTest {

    private CarToBuyJpaRepository carToBuyJpaRepository;

    @Test
    void thatCarCanBeSavedCorrectly() {
        //given
        List<CarToBuyEntity> cars = List.of(
                EntityFixtures.somaCar1(),
                EntityFixtures.somaCar2(),
                EntityFixtures.somaCar3());
        carToBuyJpaRepository.saveAllAndFlush(cars);
        //when
        List<CarToBuyEntity> availableCars = carToBuyJpaRepository.findAvailableCars();
        //then
        Assertions.assertThat(availableCars).hasSize(9);
    }

    @Test
    void findByVin() {
    }
}