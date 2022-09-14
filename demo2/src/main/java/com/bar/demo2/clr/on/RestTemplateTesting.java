package com.bar.demo2.clr.on;

import com.bar.demo2.bins.Author;
import com.bar.demo2.bins.Books;
import com.bar.demo2.models.DatesBetweenReq;
import lombok.RequiredArgsConstructor;
import org.hibernate.boot.archive.internal.UrlInputStreamAccess;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Order(4)
@RequiredArgsConstructor
public class RestTemplateTesting implements CommandLineRunner {

    private final String webApi = "http://localhost:8080/api/library/";

    private final RestTemplate restTemplate;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n");
        try {
            Author res1 =
                    restTemplate.getForObject(webApi + "/author/3", Author.class);
            System.out.println(res1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            ResponseEntity<String> res2 =
                    restTemplate.getForEntity(webApi + "/author/2", String.class);
            System.out.println(res2.getStatusCodeValue() == HttpStatus.OK.value() ? "sababa" : "not sababa");
            System.out.println(res2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        Author toAdd = Author.builder()
                .name("Lofi")
                .booksList(Arrays.asList(
                        Books.builder()
                                .name("DeathNote1")
                                .year(2012)
                                .build(),
                        Books.builder()
                                .name("DeathNote2")
                                .year(2009)
                                .build()))
                .build();
        try {

            ResponseEntity<String> res3 = restTemplate.postForEntity(webApi + "/author", toAdd, String.class);
            System.out.println(res3.getStatusCodeValue() == HttpStatus.CREATED.value() ? "sababa" : "not sababa");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try{

            Books [] books =
                    restTemplate.getForObject(webApi + "/books/all", Books[].class);
            List<Books> booksList =
                    Arrays.stream(books).collect(Collectors.toList());
            System.out.println(booksList);

        } catch (RestClientException e) {
            e.printStackTrace();
        }
        try {
            restTemplate.delete(webApi+"/author/delete/2");
            System.out.println("Deleted");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Books [] books =
                    restTemplate.getForObject(webApi + "books/btw/dates",Books[].class,new DatesBetweenReq(2005,2017));
//            List<Books> booksList =
//                    Arrays.stream(books).collect(Collectors.toList());
            System.out.println(books);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            double res1 =
                    restTemplate.getForObject(webApi + "/books/avg", Double.class);
            System.out.println(res1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            double res2 =
                    restTemplate.getForObject(webApi + "/author/4/books/avg", Double.class);
            System.out.println(res2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            ResponseEntity<Double> res2 =
                    restTemplate.getForEntity(webApi + "/author/4/books/avg", Double.class);
            System.out.println(res2.getStatusCodeValue() == HttpStatus.OK.value() ? "sababa" : "not sababa");
            System.out.println(res2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}