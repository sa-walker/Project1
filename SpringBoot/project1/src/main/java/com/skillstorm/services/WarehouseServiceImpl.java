package com.skillstorm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.models.Warehouse;
import com.skillstorm.repositories.WarehouseRepository;

@Service
public class WarehouseServiceImpl implements WarehouseService {

	@Autowired
    private WarehouseRepository warehouseRepository;
	
	// Save operation
    @Override
    public Warehouse saveWarehouse(Warehouse warehouse)
    {
        return warehouseRepository.save(warehouse);
    }
}
