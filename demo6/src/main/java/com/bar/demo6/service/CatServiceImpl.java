package com.bar.demo6.service;

import com.bar.demo6.Exception.CatExceptionMsg;
import com.bar.demo6.Exception.CatsCustomException;
import com.bar.demo6.bins.Cat;
import com.bar.demo6.repos.CatRepository;
import com.bar.demo6.repos.ToyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CatServiceImpl implements CatService{
    private final CatRepository catRepository;

    @Override
    public void addCat(Cat cat) throws CatsCustomException {
        int catId = cat.getId();
        if (catRepository.existsById(catId))
            throw new CatsCustomException(CatExceptionMsg.CatExist);
        catRepository.save(cat);

    }

    @Override
    public void updateCat(int id,Cat cat) throws CatsCustomException {
        if (!catRepository.existsById(id))
            throw new CatsCustomException(CatExceptionMsg.CatUpdate);
        catRepository.saveAndFlush(cat);
    }

    @Override
    public void deleteCat(int id) throws CatsCustomException {
        if (!catRepository.existsById(id))
            throw new CatsCustomException(CatExceptionMsg.CatDelete);
        Cat deletedOne =  catRepository.getById(id);
        catRepository.delete(deletedOne);

    }

    @Override
    public List<Cat> allCats() {
        return catRepository.findAll();
    }

    @Override
    public Cat getOneCat(int id) throws CatsCustomException {
        if (!catRepository.existsById(id))
            throw new CatsCustomException(CatExceptionMsg.CatDoNotExist);
        return catRepository.getById(id);
    }

    @Override
    public List<Cat> allCatsByNameByWeight(String Name, float weight) throws CatsCustomException {
        if (weight<=0)
            throw new CatsCustomException(CatExceptionMsg.CatNegativeWeight);
        return catRepository.findByNameAndWeight(Name, weight);
    }

    @Override
    public List<Cat> allCatsByNameOrByWeight(String Name, float weight) throws CatsCustomException {
        if (weight<=0)
            throw new CatsCustomException(CatExceptionMsg.CatNegativeWeight);
        return catRepository.findByNameOrWeight(Name, weight);
    }

    @Override
    public List<Cat> allCatsByWeightByDesc() {
        return catRepository.findByOrderByWeightDesc();
    }

    @Override
    public List<Cat> allCatsByWeightByAsc() {
        return catRepository.findByOrderByWeightAsc();
    }

    @Override
    public List<Cat> allCatsWith(String chr) {
        return catRepository.findByNameContaining(chr);
    }

    @Override
    public double allCatsAvgWeight() {
        return catRepository.AvgCatWeight();
    }
}
