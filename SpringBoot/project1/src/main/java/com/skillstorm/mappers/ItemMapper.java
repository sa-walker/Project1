package com.skillstorm.mappers;

import org.springframework.stereotype.Component;

import com.skillstorm.dtos.ItemRequestDto;
import com.skillstorm.dtos.ItemResponseDto;
import com.skillstorm.models.Item;

@Component
public class ItemMapper {

	// convert a Item Entity into a ItemResponseDto

	public ItemResponseDto convert(Item item) {
		return new ItemResponseDto(item.getId(), 
				item.getItemName(),
				item.getItemDescription());
	}
	
	// convert a ItemRequestDto into a Item Entity
	
	public Item convert(ItemRequestDto itemDto) {
		return new Item(itemDto.getId(),
				itemDto.getItemName(),
				itemDto.getItemDescription());
	}

}