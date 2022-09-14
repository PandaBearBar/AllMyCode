package com.bar.demo6.clr.on;

import com.bar.demo6.bins.Cat;
import com.bar.demo6.bins.Toy;
import com.bar.demo6.repos.CatRepository;
import com.bar.demo6.repos.ToyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Order(1)
@RequiredArgsConstructor
public class RepositoryTesting implements CommandLineRunner {

    private final CatRepository catRepository;
    private final ToyRepository toyRepository;

    @Override
    public void run(String... args) throws Exception {

        Toy toy3 = Toy.builder()
                .name("Dot")
                .build();
        Toy toy4 = Toy.builder()
                .name("Whisky")
                .build();

        Cat cat1 = Cat.builder()
                .name("Lezli")
                .weight(4f)
                .toys(Arrays.asList(
                        Toy.builder()
                        .name("Ball")
                        .build(),
                        Toy.builder()
                        .name("Father")
                        .build()))
                .build();
        Cat cat2 = Cat.builder()
                .name("Buzit")
                .weight(3.4f)
                .toys(Arrays.asList(toy3,toy4))
                .build();
        catRepository.saveAll(Arrays.asList(cat1,cat2));

    }
}
