package com.bar.demo6.service;

import com.bar.demo6.Exception.CatsCustomException;
import com.bar.demo6.bins.Cat;

import java.util.List;

public interface CatService {
    void addCat(Cat cat) throws CatsCustomException;
    void updateCat(int id,Cat cat) throws CatsCustomException;
    void deleteCat(int id) throws CatsCustomException;
    List<Cat> allCats();
    Cat getOneCat(int id) throws CatsCustomException;
    List<Cat> allCatsByNameByWeight(String Name,float weight) throws CatsCustomException;
    List<Cat>allCatsByNameOrByWeight(String Name,float weight) throws CatsCustomException;
    List<Cat>allCatsByWeightByDesc();
    List<Cat>allCatsByWeightByAsc();
    List<Cat>allCatsWith(String chr);
    double allCatsAvgWeight();


}
