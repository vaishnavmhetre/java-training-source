/**
 * 
 */
package com.allianz.shopping.data.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Allianz3076
 *
 */
public class Category {

	private int id;
	private String code;
	private String description;
	
	private List<Product> products = new ArrayList<Product>();
	
	
	public Category() {
		super();
	}

	public Category(int id, String code, String description) {
		super();
		setId(id);
		setCode(code);
		setDescription(description);
	}

	public Category(String code, String description) {
		super();
		setCode(code);
		setDescription(description);
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
	public String getCode() {
		return code;
	}

	/**
	 * @param code the category to set
	 */
	public void setCode(String code) {
		this.code = code;
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
	 * @return the products
	 */
	public List<Product> getProducts() {
		return products;
	}

	/**
	 * @param products the products to set
	 */
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	public void addProduct(Product product) {
		this.products.add(product);
	}
	
	public void removeProduct(Product product) {
		for (Product listProduct : products) {
			if (product.getId() == listProduct.getId()) {
				this.products.remove(listProduct);
			}
		}
	}
}
