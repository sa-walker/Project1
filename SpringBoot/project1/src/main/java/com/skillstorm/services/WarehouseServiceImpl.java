package com.skillstorm.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.skillstorm.models.Warehouse;
import com.skillstorm.repositories.WarehouseRepository;

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
