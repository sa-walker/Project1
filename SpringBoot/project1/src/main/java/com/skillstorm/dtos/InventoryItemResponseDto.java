package com.skillstorm.dtos;

import java.util.Objects;

import com.skillstorm.models.Item;
import com.skillstorm.models.Warehouse;

public class InventoryItemResponseDto {
	

	private int id;

	private Item item;
	
	private Warehouse warehouse;
	
	private int quantity;

	
	public InventoryItemResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public InventoryItemResponseDto(int id, Item item, Warehouse warehouse, int quantity) {
		super();
		this.id = id;
		this.item = item;
		this.warehouse = warehouse;
		this.quantity = quantity;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Item getItem() {
		return item;
	}


	public void setItemId(Item item) {
		this.item = item;
	}


	public Warehouse getWarehouse() {
		return warehouse;
	}


	public void setWarehouseId(Warehouse warehouse) {
		this.warehouse = warehouse;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	@Override
	public String toString() {
		return "InventoryItemResponseDto [id=" + id + ", item=" + item + ", warehouse=" + warehouse + ", quantity="
				+ quantity + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(id, item, quantity, warehouse);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InventoryItemResponseDto other = (InventoryItemResponseDto) obj;
		return id == other.id && Objects.equals(item, other.item) && quantity == other.quantity
				&& Objects.equals(warehouse, other.warehouse);
	}


	


	
	
}
