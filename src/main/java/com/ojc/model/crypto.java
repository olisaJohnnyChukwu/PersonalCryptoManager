package com.ojc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="crypto")
public class crypto {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(unique=true)
	private String name;
	double price;
	 @Column(columnDefinition = "double default 0.0")
	double lastprice;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getLastprice() {
		return lastprice;
	}
	public void setLastprice(double lastprice) {
		this.lastprice = lastprice;
	}
	
	 
	
	

}
