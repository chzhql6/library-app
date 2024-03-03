package com.group.libraryapp.controller.fruitmart;


import com.group.libraryapp.domain.fruit.Fruit;
import com.group.libraryapp.dto.fruit.request.*;
import com.group.libraryapp.dto.fruit.response.FruitCountResponse;
import com.group.libraryapp.dto.fruit.response.FruitSaleAmountsResponse;
import com.group.libraryapp.dto.fruit.response.FruitSearchResponse;
import com.group.libraryapp.service.fruit.FruitServiceV1;
import com.group.libraryapp.service.fruit.FruitServiceV2;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FruitController {

    private final FruitServiceV2 fruitService;

    public FruitController(FruitServiceV2 fruitService) {
        this.fruitService = fruitService;
    }


    @PostMapping("/api/v1/fruit")
    public void saveFruit(@RequestBody FruitCreateRequest request){
        fruitService.saveFruit(request);
    }


    @PutMapping("api/v1/fruit")
    public void updateFruit(@RequestBody FruitUpdateRequest request){
        fruitService.updateFruit(request);
    }


    @GetMapping("api/v1/fruit/count")
    public FruitCountResponse countFruit(FruitCountRequest request){
        FruitCountResponse response = new FruitCountResponse(fruitService.countFruit(request));
        return response;
    }

    @GetMapping("api/v1/fruit/list")
    public List<FruitSearchResponse> searchFruit(FruitSearchRequest request){
        return fruitService.searchFruit(request);
    }



    @GetMapping("/api/v1/fruit/stat")
    public FruitSaleAmountsResponse getFruits(FruitSalesAmountRequest request){
        return fruitService.getFruitSalesAmount(request);
    }

}
