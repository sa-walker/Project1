package com.skillstorm.dtos;

import java.util.Objects;

import com.skillstorm.models.Item;
import com.skillstorm.models.Warehouse;

public class InventoryItemResponseDto {
	

	private int id;

private int itemId;
	
	private int warehouseId;
	
	private int quantity;

	
	public InventoryItemResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public InventoryItemResponseDto(int id, int itemId, int warehouseId, int quantity) {
		super();
		this.id = id;
		this.itemId = itemId;
		this.warehouseId = warehouseId;
		this.quantity = quantity;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getItemId() {
		return itemId;
	}


	public void setItemId(int itemId) {
		this.itemId = itemId;
	}


	public int getWarehouseId() {
		return warehouseId;
	}


	public void setWarehouseId(int warehouseId) {
		this.warehouseId = warehouseId;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	@Override
	public String toString() {
		return "InventoryItemResponseDto [id=" + id + ", item=" + itemId + ", warehouse=" + warehouseId + ", quantity="
				+ quantity + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(id, itemId, quantity, warehouseId);
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
		return id == other.id && Objects.equals(itemId, other.itemId) && quantity == other.quantity
				&& Objects.equals(warehouseId, other.warehouseId);
	}
	
	
}
