package com.skillstorm.models;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "item")
public class Item {
	
	@Transient
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 45, name = "item_name")
	private String itemName;
	
	@Column(length = 45, name = "item_desc")
	private String itemDescription;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public Item(String itemName, String itemDescription) {
		super();
		this.itemName = itemName;
		this.itemDescription = itemDescription;
	}

	
	@Override
	public String toString() {
		return "Item [id=" + id + ", itemName=" + itemName + ", itemDescription=" + itemDescription + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, itemDescription, itemName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return id == other.id && Objects.equals(itemDescription, other.itemDescription)
				&& Objects.equals(itemName, other.itemName);
	}


}
