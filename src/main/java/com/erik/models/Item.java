package com.erik.models;

import javax.persistence.*;

@Entity
public class Item {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	private String name, price, type, bin;

	public Item(String name, String price, String type, String bin) {
		super();
		this.name = name;
		this.price = price;
		this.type = type;
		this.bin = bin;
	}
	
	public Item(){}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBin() {
		return bin;
	}

	public void setBin(String bin) {
		this.bin = bin;
	}
	
	

}
