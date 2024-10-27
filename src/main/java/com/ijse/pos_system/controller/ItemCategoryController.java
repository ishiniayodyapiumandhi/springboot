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

import com.ijse.pos_system.entity.ItemCategory;
import com.ijse.pos_system.service.ItemCategoryService;

@RestController
@CrossOrigin(origins = "*")
public class ItemCategoryController {
    
    @Autowired
    private ItemCategoryService itemCategoryService;

    @GetMapping("/item-categories")
    public ResponseEntity<List<ItemCategory>> getAllItemCategories() {
        List<ItemCategory> itemCategoryList = itemCategoryService.getItemCategoriesList();

        return ResponseEntity.status(200).body(itemCategoryList);
    }

    @PostMapping("/item-categories")
    public ResponseEntity<String> createItemCategory(@RequestBody ItemCategory itemCategory) {

        if(itemCategory.getName() == null || itemCategory.getName() == "") {
            return ResponseEntity.status(422).body("Please Enter a Valid Category Name");
        }

        itemCategoryService.createItemCategory(itemCategory);

        return ResponseEntity.status(201).body("Item-Category Added Successfully");
    }

    @GetMapping("/item-categories/{id}") //added a path variable to fetch id from client id
    public ResponseEntity<ItemCategory> getItemCategoryById(@PathVariable Long id) {
        ItemCategory itemCategory = itemCategoryService.getItemCategoryById(id);

       if(itemCategory == null) {
        return ResponseEntity.status(404).body(null);
       } else {
        return ResponseEntity.status(200).body(itemCategory);
       }
    }

    @PutMapping("/item-categories/{id}")
    public ResponseEntity<ItemCategory> updateItemCategory(@PathVariable Long id, @RequestBody ItemCategory itemCategory) {
        ItemCategory updatedItemCategory = itemCategoryService.updateItemCategory(id, itemCategory);

        if(updatedItemCategory == null) {
            return ResponseEntity.status(404).body(null);
        } else {
            return ResponseEntity.status(200).body(updatedItemCategory);
        }
    }

    @DeleteMapping("/item-categories/{id}")
    public void deleteItemCategory(@PathVariable Long id) {
        itemCategoryService.deleteItemCategory(id);
    }
}
