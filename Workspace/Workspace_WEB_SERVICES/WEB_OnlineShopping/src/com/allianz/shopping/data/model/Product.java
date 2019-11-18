/**
 * 
 */
package com.allianz.shopping.data.model;

import java.util.Date;

/**
 * @author Allianz3076
 *
 */
public class Product {

	private int id;
	private String name;
	private String description;
	private float price;
	private Date manufactureDate;

	public Product() {
		super();
	}

	public Product(int id, String name, String description, float price, Date manufactureDate) {
		super();
		setId(id);
		setName(name);
		setDescription(description);
		setPrice(price);
		setManufactureDate(manufactureDate);
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the code
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the product to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the price
	 */
	public float getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(float price) {
		this.price = price;
	}

	/**
	 * @return the manufactureDate
	 */
	public Date getManufactureDate() {
		return manufactureDate;
	}

	/**
	 * @param manufactureDate the manufactureDate to set
	 */
	public void setManufactureDate(Date manufactureDate) {
		this.manufactureDate = manufactureDate;
	}

}
