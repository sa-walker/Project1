package com.skillstorm.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skillstorm.dtos.InventoryItemRequestDto;
import com.skillstorm.dtos.InventoryItemResponseDto;
import com.skillstorm.dtos.ItemResponseDto;
import com.skillstorm.mappers.InventoryItemMapper;
import com.skillstorm.models.InventoryItem;
import com.skillstorm.repositories.InventoryItemRepository;
import com.skillstorm.repositories.ItemRepository;
import com.skillstorm.repositories.WarehouseRepository;

@Service
@Transactional 
public class InventoryItemServiceImpl implements InventoryItemService {

	private InventoryItemRepository repo;
	private ItemRepository itemRepo;
	private WarehouseRepository wareRepo;
	private InventoryItemMapper mapper;
	
	// Inject and instance of the DirectorMapper class here

	@Autowired
	public InventoryItemServiceImpl(InventoryItemRepository repo, 
			InventoryItemMapper mapper, 
			ItemRepository itemRepo,
			WarehouseRepository wareRepo) {
		this.repo = repo;
		this.mapper = mapper;
		this.itemRepo = itemRepo;
		this.wareRepo = wareRepo;
	}

	@Override
	public List<InventoryItemResponseDto> findAll() {
		return repo.findAll().stream().map(data -> mapper.convert(data)).collect(Collectors.toList());
	}
	
	@Override
	public InventoryItemResponseDto getReferenceById(Integer id) {
		return mapper.convert(repo.getReferenceById(id));

	}
	
	@Override
	// get all the inventory items in a certain warehouse
	public List<InventoryItemResponseDto> findByWarehouseId(Integer id){
		return repo.getInventoryByWarehouse(id).stream().map(data -> mapper.convert(data)).collect(Collectors.toList());
	}
	
	@Override
	//list stock for each warehouses for a certain item
	public List<InventoryItemResponseDto> findByItemId(Integer id){
		return repo.getInventoryByItem(id).stream().map(data -> mapper.convert(data)).collect(Collectors.toList());
	}

	// JPA projections can do the Director -> DirectorResponseDto for us
	// Jackson custom serializers can do the DirectorRequestDto -> Director and back for us
	@Override
	public InventoryItemResponseDto save(InventoryItemRequestDto dto) {
		// TODO add validation checks
		// dto -> inventory item
		InventoryItem invItem = mapper.convert(dto);
		// save to db
		InventoryItem savedInvItem = repo.save(invItem);
		// inventory item -> dto
		InventoryItemResponseDto dtoResponse = mapper.convert(savedInvItem);
		return dtoResponse;
	}

	@Override
	public int delete(InventoryItemRequestDto dto) {
		// dto -> inventory item
		InventoryItem invItem = mapper.convert(dto);
		// save to db
		repo.delete(invItem);
		return 1;
	}
	
  
}
