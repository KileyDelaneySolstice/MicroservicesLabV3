package com.delaneykiley.stockservice.controller;

import com.delaneykiley.stockservice.model.Stock;
import com.delaneykiley.stockservice.repository.StockRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stocks")
public class StockController {

    private StockRepository stockRepository;

    // loads all stocks on startup since there are only 5 in this instance
    public StockController(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
        stockRepository.save(new Stock(1, "AAPL"));
        stockRepository.save(new Stock(2, "GOOG"));
        stockRepository.save(new Stock(3, "MSFT"));
        stockRepository.save(new Stock(4, "PVTL"));
        stockRepository.save(new Stock(5, "AMZN"));
    }

    // lists all stocks
    @GetMapping("")
    public Iterable<Stock> list() { return stockRepository.findAll(); }

    // adds a stock
    @

}
