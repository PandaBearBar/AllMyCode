package com.bar.demo6.clr.on;

import com.bar.demo6.Exception.CatsCustomException;
import com.bar.demo6.bins.Cat;
import com.bar.demo6.bins.Toy;
import com.bar.demo6.service.CatService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.Arrays;

@Component
@Order(2)
@RequiredArgsConstructor
public class ServiceTesting implements CommandLineRunner {
    private final CatService catService;
    @Override
    public void run(String... args) throws Exception {
        Toy toy1 = Toy.builder()
                .name("Mojo")
                .build();
        Toy toy2 = Toy.builder()
                .name("Jojo")
                .build();
        Cat cat = Cat.builder()
                .name("Loli")
                .weight(10f)
                .toys(Arrays.asList(toy1,toy2))
                .build();
        catService.addCat(cat);
        System.out.println("CatAdded !");
        System.out.println("#############################################");

        cat.setName("Loti");
        catService.updateCat(3,cat);
        System.out.println("CatUpdated !");
        System.out.println("#############################################");

        catService.allCats().forEach(System.out::println);
        System.out.println("AllCats !");
        System.out.println("#############################################");

        catService.deleteCat(2);
        System.out.println("CatDeleted !");
        System.out.println("#############################################");

        try{
            catService.getOneCat(2);
        }catch (CatsCustomException e){
            System.out.println(e);
        }
        System.out.println(catService.getOneCat(3));
        System.out.println("Two options of one cat");
        System.out.println("#############################################");

        catService.allCatsByNameByWeight("Loti", 10f).forEach(System.out::println);
        System.out.println("all cats by weight and name");
        System.out.println("#############################################");

        catService.allCatsByNameOrByWeight("Loti", 4).forEach(System.out::println);
        System.out.println("all cats with weight or name");
        System.out.println("#############################################");

        catService.allCatsByWeightByAsc().forEach(System.out::println);
        System.out.println("all Cats Asc");
        System.out.println("#############################################");

        catService.allCatsByWeightByDesc().forEach(System.out::println);
        System.out.println("all Cats Desc");
        System.out.println("#############################################");

        catService.allCatsWith("e").forEach(System.out::println);
        System.out.println("Cats containing");
        System.out.println("#############################################");

        System.out.println("Avg weight : " + catService.allCatsAvgWeight());
        System.out.println("#############################################");


    }
}
