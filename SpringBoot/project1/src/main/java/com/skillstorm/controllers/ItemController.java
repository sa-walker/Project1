package com.skillstorm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.skillstorm.models.Item;
import com.skillstorm.services.ItemService;
//import javax.validation.Valid;

@RestController
public class ItemController {
    
	@Autowired private ItemService itemService;
    
    // Save operation
    @PostMapping("/items")
    public Item saveItem(
        //@Valid 
        @RequestBody Item item)
    {
        return itemService.saveItem(item);
    }

}
