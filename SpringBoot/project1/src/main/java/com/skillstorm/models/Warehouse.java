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
@Table(name = "warehouse")
public class Warehouse {
	
	@Transient
	Logger logger = LoggerFactory.getLogger(getClass());
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	@Column(length = 45, name = "warehouse_loc")
	private String location;
	
	@Column(name = "item_limit")
	private double itemLimit;
	
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

	public Warehouse(String location, double itemLimit) {
		super();
		this.location = location;
		this.itemLimit = itemLimit;
	}

	@Override
	public String toString() {
		return "Warehouse [id=" + id + ", location=" + location + ", itemLimit=" + itemLimit + "]";
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
		Warehouse other = (Warehouse) obj;
		return id == other.id && Double.doubleToLongBits(itemLimit) == Double.doubleToLongBits(other.itemLimit)
				&& Objects.equals(location, other.location);
	}

	
}
