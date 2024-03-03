package com.group.libraryapp.domain.fruit;

import com.group.libraryapp.dto.fruit.response.FruitSaleAmountsResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface FruitRepository extends JpaRepository<Fruit, Long> {

    Optional<Fruit> findByName(String name);
    Optional<Fruit> findById(Long id);
    Long countByName(String name);

    List<Fruit> findBySalesStateAndPriceGreaterThanEqual(Boolean salesState, Long price);
    List<Fruit> findBySalesStateAndPriceLessThanEqual(Boolean salesState, Long price);


    List<Fruit> findByNameAndSalesState(String name, Boolean salesState);
}
