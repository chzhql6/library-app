package com.group.libraryapp.service.fruit;

import com.group.libraryapp.dto.fruit.request.FruitCreateRequest;
import com.group.libraryapp.dto.fruit.request.FruitSalesAmountRequest;
import com.group.libraryapp.dto.fruit.request.FruitUpdateRequest;
import com.group.libraryapp.dto.fruit.response.FruitSaleAmountsResponse;
import com.group.libraryapp.repository.fruit.FruitJdbcRepository;
import org.springframework.stereotype.Service;

@Service
public class FruitServiceV1 {

    private final FruitJdbcRepository fruitJdbcRepository;

    public FruitServiceV1(FruitJdbcRepository fruitJdbcRepository) {
        this.fruitJdbcRepository = fruitJdbcRepository;
    }

    public void saveFruit(FruitCreateRequest request) {
        fruitJdbcRepository.saveFruit(request.getName(), request.getWarehousingDate(), request.getPrice());
    }

    public void updateFruit(FruitUpdateRequest request) {
        if (fruitJdbcRepository.isFruitNotExist(request.getId())) {
            throw new IllegalArgumentException();
        }
        fruitJdbcRepository.updateFruitState(request.getId());
    }

    public FruitSaleAmountsResponse getFruitSalesAmount(FruitSalesAmountRequest request) {
        if (fruitJdbcRepository.isFruitNotExist(request.getName())) {
            throw new IllegalArgumentException();
        }
        return fruitJdbcRepository.getFruitSalesAmount(request.getName());
    }
}
