package com.skillstorm.mappers;

import org.springframework.stereotype.Component;

import com.skillstorm.dtos.InventoryItemRequestDto;
import com.skillstorm.dtos.InventoryItemResponseDto;
import com.skillstorm.models.InventoryItem;
import com.skillstorm.models.Item;
import com.skillstorm.models.Warehouse;

@Component
public class InventoryItemMapper {

	// convert a InventoryItem Entity into a InventoryItemResponseDto

	public InventoryItemResponseDto convert(InventoryItem inventoryItem) {
		return new InventoryItemResponseDto(inventoryItem.getId(), 
				inventoryItem.getItem().getId(), 
				inventoryItem.getWarehouse().getId(),
				inventoryItem.getQuantity());
	}
	
	// convert a InventoryItemRequestDto into a InventoryItem Entity
	
	public InventoryItem convert(InventoryItemRequestDto inventoryItemDto) {
		return new InventoryItem(inventoryItemDto.getId(),
				new Item(inventoryItemDto.getItemId()),
				new Warehouse(inventoryItemDto.getWarehouseId()),
				inventoryItemDto.getQuantity());
	}

}