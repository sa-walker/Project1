package com.skillstorm.services;

import java.util.List;


import com.skillstorm.dtos.WarehouseRequestDto;
import com.skillstorm.dtos.WarehouseResponseDto;

public interface WarehouseService {
	
    // find all
	List<WarehouseResponseDto> findAll();
	WarehouseResponseDto getReferenceById(Integer id);

	//save
	WarehouseResponseDto save(WarehouseRequestDto dto);
	
	//delete
	int delete(int id);
}
