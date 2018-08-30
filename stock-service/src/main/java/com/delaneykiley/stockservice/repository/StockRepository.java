package com.delaneykiley.stockservice.repository;


import com.delaneykiley.stockservice.model.Stock;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StockRepository extends CrudRepository<Stock, Integer> {

    public Optional<Stock> findByName(String name);

    public void deleteByName(String name);

}
