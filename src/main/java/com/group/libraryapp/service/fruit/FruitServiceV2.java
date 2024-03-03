package com.group.libraryapp.service.fruit;

import com.group.libraryapp.domain.fruit.Fruit;
import com.group.libraryapp.domain.fruit.FruitRepository;
import com.group.libraryapp.dto.fruit.request.*;
import com.group.libraryapp.dto.fruit.response.FruitSaleAmountsResponse;
import com.group.libraryapp.dto.fruit.response.FruitSearchResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

@Service
public class FruitServiceV2 {

    private final FruitRepository fruitRepository;

    public FruitServiceV2(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    public void saveFruit(FruitCreateRequest request){
        Fruit f = fruitRepository.save(new Fruit(request.getName(), request.getWarehousingDate(), request.getPrice()));
    }

    public void updateFruit(FruitUpdateRequest request) {
        Fruit fruit = fruitRepository.findById(request.getId()).orElseThrow(IllegalAccessError::new);
        fruit.updateState(TRUE);
        fruitRepository.save(fruit);
    }
    public Long countFruit(FruitCountRequest request) {
        return fruitRepository.countByName(request.getName());
    }

    public List<FruitSearchResponse> searchFruit(FruitSearchRequest request){

        ArrayList<FruitSearchResponse> list = new ArrayList<>();

        if(Objects.equals(request.getOption(), "GTE")) {
            List<Fruit> tmp = fruitRepository.findBySalesStateAndPriceGreaterThanEqual(FALSE, request.getPrice());
            for (Fruit fruit : tmp) {
                FruitSearchResponse tmp_FSR = new FruitSearchResponse(fruit.getName(), fruit.getPrice(), fruit.getWarehousingDate());
                list.add(tmp_FSR);
            }
        } else if(Objects.equals(request.getOption(), "LTE")){
            fruitRepository.findBySalesStateAndPriceLessThanEqual(FALSE, request.getPrice());
            List<Fruit> tmp = fruitRepository.findBySalesStateAndPriceLessThanEqual(FALSE, request.getPrice());
            for (Fruit fruit : tmp) {
                FruitSearchResponse tmp_FSR = new FruitSearchResponse(fruit.getName(), fruit.getPrice(), fruit.getWarehousingDate());
                list.add(tmp_FSR);
            }
        }

        return list;
    }


    public FruitSaleAmountsResponse getFruitSalesAmount(FruitSalesAmountRequest request){
        List<Fruit> state0 = fruitRepository.findByNameAndSalesState(request.getName(), FALSE);
        List<Fruit> state1 = fruitRepository.findByNameAndSalesState(request.getName(), TRUE);

        Long sumOfState0 = 0L;
        Long sumOfState1 = 0L;

        for (Fruit fruit : state0) {
            sumOfState0 += fruit.getPrice();
        }
        for (Fruit fruit : state1) {
            sumOfState1 += fruit.getPrice();
        }


        return new FruitSaleAmountsResponse(sumOfState1,sumOfState0);
    }








}
