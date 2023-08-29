package com.skillstorm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.skillstorm.dtos.ItemRequestDto;
import com.skillstorm.dtos.ItemResponseDto;
import com.skillstorm.services.ItemService;
//import javax.validation.Valid;

@RestController
public class ItemController {
    
	@Autowired private ItemService itemService;
    
	@GetMapping("/items") // localhost:8080/movies or localhost:8080/movies?title=inception or localhost:8080/movies?firstName=chris 
	public ResponseEntity<List<ItemResponseDto>> findAll() {
		List<ItemResponseDto> dtos = itemService.findAll();
		if (dtos == null || dtos.size() == 0) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(dtos, HttpStatus.OK);
		}
	}
	
	@GetMapping(value = "/items", params = "id")
	public ResponseEntity<ItemResponseDto> getReferenceById(@RequestParam int id) {
		return new ResponseEntity<>(itemService.getReferenceById(id), HttpStatus.OK);
	}

	//edit?
	
    // Save operation
    @PostMapping("/items")
    @PutMapping("/items")
	public ResponseEntity<ItemResponseDto> save(@RequestBody ItemRequestDto dto) {
		return new ResponseEntity<>(itemService.save(dto), HttpStatus.CREATED);
	}

	@DeleteMapping("/items")
	public int delete(@RequestBody ItemRequestDto dto) {
		return itemService.delete(dto);
	}
}
