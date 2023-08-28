package com.skillstorm.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.dtos.ItemRequestDto;
import com.skillstorm.dtos.ItemResponseDto;
import com.skillstorm.dtos.WarehouseRequestDto;
import com.skillstorm.dtos.WarehouseResponseDto;
import com.skillstorm.mappers.ItemMapper;
import com.skillstorm.mappers.WarehouseMapper;
import com.skillstorm.models.Item;
import com.skillstorm.models.Warehouse;
import com.skillstorm.repositories.ItemRepository;
import com.skillstorm.repositories.WarehouseRepository;

@Service
public class WarehouseServiceImpl implements WarehouseService {

	private WarehouseRepository repo;
	private WarehouseMapper mapper;
	
	// Inject an instance of the ItemMapper class here - why?

	@Autowired
	public WarehouseServiceImpl(WarehouseRepository repo, 
			WarehouseMapper mapper) {
		this.repo = repo;
		this.mapper = mapper;
	}

	@Override
	public List<WarehouseResponseDto> findAll() {
		return repo.findAll().stream().map(data -> mapper.convert(data)).collect(Collectors.toList());
	}
	
	@Override
	public WarehouseResponseDto getReferenceById(Integer id) {
		return mapper.convert(repo.getReferenceById(id));

	}

	// JPA projections can do the Director -> DirectorResponseDto for us
	// Jackson custom serializers can do the DirectorRequestDto -> Director and back for us
	@Override
	public WarehouseResponseDto save(WarehouseRequestDto dto) {
		// TODO add validation checks
		// dto -> inventory item
		Warehouse warehouse = mapper.convert(dto);
		// save to db
		Warehouse savedWarehouse = repo.save(warehouse);
		// inventory item -> dto
		WarehouseResponseDto dtoResponse = mapper.convert(savedWarehouse);
		return dtoResponse;
	}

	@Override
	public int delete(WarehouseRequestDto dto) {
		// dto -> inventory item
		Warehouse warehouse = mapper.convert(dto);
		// save to db
		repo.delete(warehouse);
		return 1;
	}
}
