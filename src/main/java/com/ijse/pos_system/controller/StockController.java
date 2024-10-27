package com.ijse.pos_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ijse.pos_system.dto.StockDTO;
import com.ijse.pos_system.entity.Item;
import com.ijse.pos_system.entity.Stock;
import com.ijse.pos_system.service.ItemService;
import com.ijse.pos_system.service.StockService;

@RestController
@CrossOrigin(origins = "*")
public class StockController {
    
    @Autowired
    private StockService stockService;

    @Autowired
    private ItemService itemService;

    @GetMapping("/stocks")
    public ResponseEntity<List<Stock>> getAllStocks() {
        List<Stock> stocks = stockService.getAllStocks();

        return ResponseEntity.status(200).body(stocks);
    }

    @PostMapping("/stocks")
    public ResponseEntity<Stock> createStock(@RequestBody StockDTO stockDTO) {
        Stock stock = new Stock();
        stock.setQuantity(stockDTO.getQuantity());

        Item item = itemService.getItemById(stockDTO.getItem_id());

        stock.setItem(item);

        Stock createdStock = stockService.createStock(stock);

        return ResponseEntity.status(201).body(createdStock);
    }

    @GetMapping("/stocks/{id}")
    public ResponseEntity<Stock> getStockById(@PathVariable Long id) {
        Stock stock = stockService.getStockById(id);

        if(stock == null) {
            return ResponseEntity.status(404).body(null);
        } else {
            return ResponseEntity.status(200).body(stock);
        }
    }
}
