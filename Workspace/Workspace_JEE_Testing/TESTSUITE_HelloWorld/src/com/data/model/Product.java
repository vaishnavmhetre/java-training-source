/**
 * 
 */
package com.data.model;

/**
 * @author Allianz3076
 *
 */
public class Product {
	protected int id;
	protected String name;
	protected String category;
	protected float price;

	public Product(int id, String name, String category, float price) {
		setId(id);
		setName(name);
		setCategory(category);
		setPrice(price);
	}
	
	public Product(String name, String category, float price) {
		setName(name);
		setCategory(category);
		setPrice(price);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

}
