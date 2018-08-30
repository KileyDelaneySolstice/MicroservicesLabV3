package com.delaneykiley.stockservice.repository;


import com.delaneykiley.stockservice.model.Stock;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends CrudRepository<Stock, Integer> { }
