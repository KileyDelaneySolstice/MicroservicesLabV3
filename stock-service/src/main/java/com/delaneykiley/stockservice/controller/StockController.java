package com.delaneykiley.stockservice.controller;

import com.delaneykiley.stockservice.model.Stock;
import com.delaneykiley.stockservice.repository.StockRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    // finds a stock by id
    @GetMapping("/{id}")
    public Optional<Stock> findById(@PathVariable Integer id) {
        return stockRepository.findById(id);
    }

    // finds a stock by name
    @GetMapping("name/{name}")
    public Optional<Stock> findByName(@PathVariable String name) {
        return stockRepository.findByName(name);
    }

    // adds a stock
    @RequestMapping(method = RequestMethod.POST)
    public Stock add(@RequestBody Stock stock) {
        return stockRepository.save(stock);
    }

////     removes a stock by id
//    @RequestMapping(method = RequestMethod.DELETE)
//    public String deleteById(@RequestBody Integer id) {
//        stockRepository.deleteById(id);
//        return "Stock with id " + id + " deleted successfully";
//    }
//
//    // removes a stock by name
//    @RequestMapping(method = RequestMethod.DELETE)
//    public String deleteByName(@RequestBody String name) {
//        stockRepository.deleteByName(name);
//        return "Stock with name " + name + " deleted successfully";
//    }

    // clears all stocks
    @GetMapping("/none")
    public String clear() {
        stockRepository.deleteAll();
        return "All stocks deleted successfully";
    }

}
