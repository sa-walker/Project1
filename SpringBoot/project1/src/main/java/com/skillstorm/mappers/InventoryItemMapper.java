package com.skillstorm.mappers;

import org.springframework.stereotype.Component;

import com.skillstorm.dtos.InventoryItemRequestDto;
import com.skillstorm.dtos.InventoryItemResponseDto;
import com.skillstorm.models.InventoryItem;

@Component
public class InventoryItemMapper {

	// convert a InventoryItem Entity into a InventoryItemResponseDto

	public InventoryItemResponseDto convert(InventoryItem inventoryItem) {
		return new InventoryItemResponseDto(inventoryItem.getId(), 
				inventoryItem.getItem(), 
				inventoryItem.getWarehouse(),
				inventoryItem.getQuantity());
	}
	
	// convert a InventoryItemRequestDto into a InventoryItem Entity
	
	public InventoryItem convert(InventoryItemRequestDto inventoryItemDto) {
		return new InventoryItem(inventoryItemDto.getId(),
				inventoryItemDto.getItem(),
				inventoryItemDto.getWarehouse(),
				inventoryItemDto.getQuantity());
	}

}