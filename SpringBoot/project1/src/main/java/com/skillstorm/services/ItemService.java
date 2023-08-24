package com.skillstorm.services;

import java.util.List;

import com.skillstorm.dtos.ItemRequestDto;
import com.skillstorm.dtos.ItemResponseDto;

public interface ItemService {
    
    // find all
	List<ItemResponseDto> findAll();

	//save
	ItemResponseDto save(ItemRequestDto dto);
	
	//delete
	int delete(ItemRequestDto dto);

}
