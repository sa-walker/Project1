package com.skillstorm.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skillstorm.dtos.ItemRequestDto;
import com.skillstorm.dtos.ItemResponseDto;
import com.skillstorm.mappers.ItemMapper;
import com.skillstorm.models.Item;
import com.skillstorm.repositories.ItemRepository;

@Service
@Transactional 
public class ItemServiceImpl implements ItemService {
    
	@Autowired
	private ItemRepository repo;
	private ItemMapper mapper;
	
	// Inject an instance of the ItemMapper class here - why?


	public ItemServiceImpl(ItemRepository repo, 
			ItemMapper mapper) {
		this.repo = repo;
		this.mapper = mapper;
	}

	@Override
	public List<ItemResponseDto> findAll() {
		return repo.findAll().stream().map(data -> mapper.convert(data)).collect(Collectors.toList());
	}
	
	@Override
	public ItemResponseDto getReferenceById(Integer id) {
		return mapper.convert(repo.getReferenceById(id));

	}
	
	@Override
	public List<ItemResponseDto> findNotInWarehouse(Integer id) {
		return repo.getItemsNotInWarehouse(id).stream().map(data -> mapper.convert(data)).collect(Collectors.toList());
	}

	// JPA projections can do the Director -> DirectorResponseDto for us
	// Jackson custom serializers can do the DirectorRequestDto -> Director and back for us
	@Override
	public ItemResponseDto save(ItemRequestDto dto) {
		// TODO add validation checks
		// dto -> inventory item
		Item item = mapper.convert(dto);
		// save to db
		Item savedItem = repo.save(item);
		// inventory item -> dto
		ItemResponseDto dtoResponse = mapper.convert(savedItem);
		return dtoResponse;
	}

	@Override
	public int delete(ItemRequestDto dto) {
		// dto -> inventory item
		Item item = mapper.convert(dto);
		// save to db
		repo.delete(item);
		return 1;
	}
}
