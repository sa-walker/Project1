package com.skillstorm.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.skillstorm.models.Item;
import com.skillstorm.repositories.ItemRepository;

public class ItemServiceImpl implements ItemService {

	@Autowired
    private ItemRepository itemRepository;
	
	// Save operation
    @Override
    public Item saveItem(Item Item)
    {
        return itemRepository.save(Item);
    }
}
