package com.skillstorm.models;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

@Entity
@Table(
		name = "inventory_item", 
		uniqueConstraints= @UniqueConstraint(
				columnNames={"item_id", "warehouse_id"})
)

public class InventoryItem {
	
	@Transient
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "item_id")
	private Item item;
	
	@ManyToOne
	@JoinColumn(name = "warehouse_id")
	private Warehouse warehouse;
	
	@Column(name = "quantity")
	private int quantity;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Warehouse getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
	public InventoryItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InventoryItem(Item item, Warehouse warehouse, int quantity) {
		super();
		this.item = item;
		this.warehouse = warehouse;
		this.quantity = quantity;
	}

	public InventoryItem(int id, Item item, Warehouse warehouse, int quantity) {
		super();
		this.id = id;
		this.item = item;
		this.warehouse = warehouse;
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "InventoryItem [id=" + id + ", itemId=" + item.getId() + ", warehouseId=" + warehouse.getId() + ", quantity="
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
		InventoryItem other = (InventoryItem) obj;
		return id == other.id && Objects.equals(item, other.item) && quantity == other.quantity
				&& Objects.equals(warehouse, other.warehouse);
	}
	
	

}
