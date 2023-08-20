package com.skillstorm.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.models.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer>{
	
	

}