package com.ijse.pos_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ijse.pos_system.dto.ItemReqDTO;
import com.ijse.pos_system.entity.Item;
import com.ijse.pos_system.entity.ItemCategory;
import com.ijse.pos_system.service.ItemCategoryService;
import com.ijse.pos_system.service.ItemService;

@RestController
@CrossOrigin(origins = "*")
public class ItemController {
    
    @Autowired
    private ItemService itemService;

    @Autowired
    private ItemCategoryService itemCategoryService;

    @GetMapping("/items")
    public ResponseEntity<List<Item>> getAllItems() {
        List<Item> items = itemService.getAllItems();

        return ResponseEntity.status(200).body(items);
    }

    @PostMapping("/items")
    public ResponseEntity<Item> createItem(@RequestBody ItemReqDTO itemReqDTO) {
        Item item = new Item();
        item.setName(itemReqDTO.getName());
        item.setPrice(itemReqDTO.getPrice());

        ItemCategory itemCategory = itemCategoryService.getItemCategoryById(itemReqDTO.getCategory_id());

        item.setItemCategory(itemCategory);

        Item createdItem = itemService.createItem(item);

        return ResponseEntity.status(201).body(createdItem);
    }

     @GetMapping("/items/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable Long id) {
        Item item = itemService.getItemById(id);

        if(item == null) {
            return ResponseEntity.status(404).body(null);
        } else {
            return ResponseEntity.status(200).body(item);
        }
    } 

    @PutMapping("/items/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable Long id, @RequestBody Item item) {
        Item updatedItem = itemService.updateItem(id, item);

        if(updatedItem == null) {
            return ResponseEntity.status(404).body(null);
        } else {
            return ResponseEntity.status(200).body(updatedItem);
        }
        
    }

    @DeleteMapping("/items/{id}")
    public void deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
    }
}
