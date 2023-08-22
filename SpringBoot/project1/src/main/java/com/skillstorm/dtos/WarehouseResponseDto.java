package com.skillstorm.dtos;

import java.util.Objects;


public class WarehouseResponseDto {

	private int id;
	
	private String location;
	
	private double itemLimit;

	public WarehouseResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public WarehouseResponseDto(int id, String location, double itemLimit) {
		super();
		this.id = id;
		this.location = location;
		this.itemLimit = itemLimit;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public double getItemLimit() {
		return itemLimit;
	}

	public void setItemLimit(double itemLimit) {
		this.itemLimit = itemLimit;
	}

	@Override
	public String toString() {
		return "WarehouseResponseDto [id=" + id + ", location=" + location + ", itemLimit=" + itemLimit + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, itemLimit, location);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WarehouseResponseDto other = (WarehouseResponseDto) obj;
		return id == other.id && Double.doubleToLongBits(itemLimit) == Double.doubleToLongBits(other.itemLimit)
				&& Objects.equals(location, other.location);
	}
	
	
	
	
}
