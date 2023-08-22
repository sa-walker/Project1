package com.skillstorm.dtos;

import java.util.Objects;

public class ItemResponseDto {
	
	private int id;
	
	private String itemName;
	
	private String itemDescription;

	public ItemResponseDto() {
		
	}

	public ItemResponseDto(int id, String itemName, String itemDescription) {
		super();
		this.id = id;
		this.itemName = itemName;
		this.itemDescription = itemDescription;
	}

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

	
	@Override
	public String toString() {
		return "ItemResponseDto [id=" + id + ", itemName=" + itemName + ", itemDescription=" + itemDescription + "]";
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
		ItemResponseDto other = (ItemResponseDto) obj;
		return id == other.id && Objects.equals(itemDescription, other.itemDescription)
				&& Objects.equals(itemName, other.itemName);
	}
	
	

}
