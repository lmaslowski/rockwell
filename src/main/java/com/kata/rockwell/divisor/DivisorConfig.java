package com.kata.rockwell.divisor;

import com.kata.rockwell.divisor.adapter.mappers.db.Animal;
import com.kata.rockwell.divisor.adapter.mappers.db.Car;
import com.kata.rockwell.divisor.adapter.mappers.db.SpringJpaAnimalRepository;
import com.kata.rockwell.divisor.adapter.mappers.db.SpringJpaCarRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.stream.Stream;

@Configuration
@ComponentScan
@Slf4j
@EnableAutoConfiguration
@EnableJpaRepositories
public class DivisorConfig {

    @Bean
    public CommandLineRunner commandLineRunnerCar(SpringJpaCarRepository springJpaCarRepository) {
        return args -> {
            log.info("Importing cars...");
            Stream.of(new Car(1, "Audi"),
                    new Car(2, "Bmw"),
                    new Car(3, "Citroen"),
                    new Car(4, "Dacia"),
                    new Car(5, "Elephant 5"),
                    new Car(6, "Elephant 6 "),
                    new Car(7, "Elephant 7"),
                    new Car(8, "Elephant 8"),
                    new Car(9, "Elephant 9"),
                    new Car(10, "Elephant 10"),
                    new Car(11, "Elephant 11"),
                    new Car(12, "Elephant 12"),
                    new Car(13, "Elephant 13"),
                    new Car(14, "Elephant 14"),
                    new Car(15, "Elephant 15"),
                    new Car(16, "Elephant 16"),
                    new Car(17, "Elephant 17"),
                    new Car(18, "Elephant 18"),
                    new Car(19, "Elephant 19"),
                    new Car(20, "Elephant 20"))
                    .peek(a -> log.info("{}", a))
                    .forEach(springJpaCarRepository::save);
        };
    }

    @Bean
    public CommandLineRunner commandLineRunnerAnimals(SpringJpaAnimalRepository springJpaAnimalRepository) {
        return args -> {
            log.info("Importing animals...");
            Stream.of(new Animal(1, "Mouse"),
                    new Animal(2, "Cat"),
                    new Animal(3, "Dog"),
                    new Animal(4, "Elephant"),
                    new Animal(5, "Elephant 5"),
                    new Animal(6, "Elephant 6 "),
                    new Animal(7, "Elephant 7"),
                    new Animal(8, "Elephant 8"),
                    new Animal(9, "Elephant 9"),
                    new Animal(10, "Elephant 10"),
                    new Animal(11, "Elephant 11"),
                    new Animal(12, "Elephant 12"),
                    new Animal(13, "Elephant 13"),
                    new Animal(14, "Elephant 14"),
                    new Animal(15, "Elephant 15"),
                    new Animal(16, "Elephant 16"),
                    new Animal(17, "Elephant 17"),
                    new Animal(18, "Elephant 18"),
                    new Animal(19, "Elephant 19"),
                    new Animal(20, "Elephant 20"))
                    .peek(a -> log.info("{}", a))
                    .forEach(springJpaAnimalRepository::save);
        };
    }
}
