package com.bar.demo6.controller;

import com.bar.demo6.Exception.CatsCustomException;
import com.bar.demo6.bins.Cat;
import com.bar.demo6.service.CatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cats")
@RequiredArgsConstructor
public class CatController {
    private final CatService catService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addCat(@RequestBody Cat cat) throws CatsCustomException {
        catService.addCat(cat);
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void UpdateCat(@PathVariable int id,@RequestBody Cat cat) throws CatsCustomException {
        catService.updateCat(id,cat);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCat(@PathVariable int id) throws CatsCustomException {
        catService.deleteCat(id);
    }
    @GetMapping
    public List<Cat> getAllCats(){
        return catService.allCats();
    }
    @GetMapping("/{id}")
    public Cat getOneById(@PathVariable int id) throws CatsCustomException {
        return catService.getOneCat(id);
    }
    @GetMapping(value = "/and/",params = {"name", "weight"})
    public List<Cat> allCatsByNameByWeight( @RequestParam("name") String name,@RequestParam("weight") float weight) throws CatsCustomException {

        return catService.allCatsByNameByWeight(name, weight);
    }
    @GetMapping(value = "/or/",params = {"name", "weight"})
    public List<Cat> allCatsByNameOrByWeight( @RequestParam("name") String name,@RequestParam("weight") float weight) throws CatsCustomException {
        return catService.allCatsByNameOrByWeight(name, weight);
    }
    @GetMapping("/desc")
    public List<Cat> allCatsByWeightByDesc( ) {
        return catService.allCatsByWeightByDesc();
    }
    @GetMapping("/asc")
    public List<Cat> allCatsByWeightByAsc( ) {
        return catService.allCatsByWeightByAsc();
    }


    @GetMapping(value = "/{string}")
    public List<Cat> allCatsWith( @PathVariable String string)  {
        return catService.allCatsWith(string);
    }

    @GetMapping("/avg")
    public double allCatsAvgWeight(){
        return catService.allCatsAvgWeight();
    }
}
