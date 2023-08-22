package com.skillstorm.mappers;

import org.springframework.stereotype.Component;

import com.skillstorm.dtos.WarehouseRequestDto;
import com.skillstorm.dtos.WarehouseResponseDto;
import com.skillstorm.models.Warehouse;

@Component
public class WarehouseMapper {

	// convert a Warehouse Entity into a WarehouseResponseDto

	public WarehouseResponseDto convert(Warehouse warehouse) {
		return new WarehouseResponseDto(warehouse.getId(), 
				warehouse.getLocation(),
				warehouse.getItemLimit());
	}
	
	// convert a WarehouseRequestDto into a Warehouse Entity
	
	public Warehouse convert(WarehouseRequestDto warehouseDto) {
		return new Warehouse(warehouseDto.getId(),
				warehouseDto.getLocation(),
				warehouseDto.getItemLimit());
	}

}