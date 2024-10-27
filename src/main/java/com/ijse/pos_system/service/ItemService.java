package com.ijse.pos_system.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ijse.pos_system.entity.Item;

@Service
public interface ItemService {
    List<Item> getAllItems();
    Item createItem(Item item);
    Item getItemById(Long id);
    Item updateItem(Long id, Item item);
    void deleteItem(Long id);
}
