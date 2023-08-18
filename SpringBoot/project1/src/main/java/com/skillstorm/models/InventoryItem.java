package com.skillstorm.models;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "inventory_item")
public class InventoryItem {
	
	@Transient
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "item_id")
	private Item itemId;
	
	@ManyToOne
	@JoinColumn(name = "warehouse_id")
	private Warehouse warehouseId;
	
	@Column(name = "quantity")
	private int quantity;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Item getItemId() {
		return itemId;
	}

	public void setItemId(Item itemId) {
		this.itemId = itemId;
	}

	public Warehouse getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(Warehouse warehouseId) {
		this.warehouseId = warehouseId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public InventoryItem(Item itemId, Warehouse warehouseId, int quantity) {
		super();
		this.itemId = itemId;
		this.warehouseId = warehouseId;
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "InventoryItem [id=" + id + ", itemId=" + itemId + ", warehouseId=" + warehouseId + ", quantity="
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
		InventoryItem other = (InventoryItem) obj;
		return id == other.id && Objects.equals(itemId, other.itemId) && quantity == other.quantity
				&& Objects.equals(warehouseId, other.warehouseId);
	}
	
	

}
