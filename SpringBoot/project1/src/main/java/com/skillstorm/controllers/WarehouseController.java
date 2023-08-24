package com.skillstorm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.skillstorm.dtos.ItemRequestDto;
import com.skillstorm.dtos.ItemResponseDto;
import com.skillstorm.dtos.WarehouseRequestDto;
import com.skillstorm.dtos.WarehouseResponseDto;
import com.skillstorm.services.ItemService;
//import javax.validation.Valid;
import com.skillstorm.services.WarehouseService;

@RestController
public class WarehouseController {
    
	@Autowired private WarehouseService warehouseService;
    
	@GetMapping("/warehouses") // localhost:8080/movies or localhost:8080/movies?title=inception or localhost:8080/movies?firstName=chris 
	public ResponseEntity<List<WarehouseResponseDto>> findAll() {
		List<WarehouseResponseDto> dtos = warehouseService.findAll();
		if (dtos == null || dtos.size() == 0) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(dtos, HttpStatus.OK);
		}
	}
	
    // Save operation
    @PostMapping("/warehouses")
	public ResponseEntity<WarehouseResponseDto> save(@RequestBody WarehouseRequestDto dto) {
		return new ResponseEntity<>(warehouseService.save(dto), HttpStatus.CREATED);
	}

	@DeleteMapping("/warehouses")
	public int delete(@RequestBody WarehouseRequestDto dto) {
		return warehouseService.delete(dto);
	}
}
