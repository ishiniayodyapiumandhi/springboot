package com.ijse.pos_system.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ijse.pos_system.entity.Stock;

@Service
public interface StockService {
    List<Stock> getAllStocks();
    Stock createStock(Stock stock);
    Stock getStockById(Long id);
}
