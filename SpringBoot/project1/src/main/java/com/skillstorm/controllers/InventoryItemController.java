package com.skillstorm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.skillstorm.dtos.InventoryItemRequestDto;
import com.skillstorm.dtos.InventoryItemResponseDto;
import com.skillstorm.dtos.ItemRequestDto;
import com.skillstorm.dtos.ItemResponseDto;
import com.skillstorm.services.InventoryItemService;
import com.skillstorm.services.ItemService;
//import javax.validation.Valid;

@RestController
public class InventoryItemController {
    
	@Autowired private InventoryItemService invItemService;
    
	@GetMapping("/inventory") // localhost:8080/movies or localhost:8080/movies?title=inception or localhost:8080/movies?firstName=chris 
	public ResponseEntity<List<InventoryItemResponseDto>> findAll() {
		List<InventoryItemResponseDto> dtos = invItemService.findAll();
		if (dtos == null || dtos.size() == 0) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(dtos, HttpStatus.OK);
		}
	}
	
	//filter by warehouse
	//filter by itemid
	//filter by item name
	
	
    // Save operation
    @PostMapping("/inventory")
	public ResponseEntity<InventoryItemResponseDto> save(@RequestBody InventoryItemRequestDto dto) {
		return new ResponseEntity<>(invItemService.save(dto), HttpStatus.CREATED);
	}

	@DeleteMapping("/inventory")
	public int delete(@RequestBody InventoryItemRequestDto dto) {
		return invItemService.delete(dto);
	}
}
