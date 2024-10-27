package com.ijse.pos_system.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ijse.pos_system.entity.ItemCategory;

@Service
public interface ItemCategoryService {
    List<ItemCategory> getItemCategoriesList(); //reading
    ItemCategory createItemCategory(ItemCategory itemCategory); //creating
    ItemCategory getItemCategoryById(Long id); //finding a itemCategory by it's primary key
    ItemCategory updateItemCategory(Long id, ItemCategory itemCategory); //finf itemCategory and update
    void deleteItemCategory(Long id); //delete itemCategory
}
