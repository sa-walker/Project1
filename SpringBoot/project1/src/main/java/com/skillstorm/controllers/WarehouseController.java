package com.skillstorm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.skillstorm.dtos.WarehouseRequestDto;
import com.skillstorm.dtos.WarehouseResponseDto;
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
	
	@GetMapping(value = "/warehouses", params = "id")
	public ResponseEntity<WarehouseResponseDto> getReferenceById(@RequestParam int id) {
		return new ResponseEntity<>(warehouseService.getReferenceById(id), HttpStatus.OK);
	}

	//edit?
	
    // Save operation
    @PostMapping("/warehouses")
    @PutMapping("/warehouses")
	public ResponseEntity<WarehouseResponseDto> save(@RequestBody WarehouseRequestDto dto) {
		return new ResponseEntity<>(warehouseService.save(dto), HttpStatus.CREATED);
	}
    

	@DeleteMapping(value = "/warehouses", params = "id")
	public int delete(@RequestParam int id) {
		return warehouseService.delete(id);
	}
}
