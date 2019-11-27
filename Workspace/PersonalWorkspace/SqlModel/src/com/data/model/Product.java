/**
 * 
 */
package com.data.model;

import com.support.database.annotation.sql.Column;
import com.support.database.annotation.sql.Table;
import com.support.database.manager.DatabaseManager;
import com.support.database.model.Model;

/**
 * @author Allianz3076
 *
 */
@Table
public class Product extends Model<Product> {

	public Product(DatabaseManager databaseManager) {
		super(Product.class, databaseManager);
	}

	public Product() {
		this(null);
	}

	@Column
	String name;

	@Column
	String description;

	@Column
	int id;

	String any;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
	 * @return the any
	 */
	public String getAny() {
		return any;
	}

	/**
	 * @param any the any to set
	 */
	public void setAny(String any) {
		this.any = any;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Product [name=" + name + ", description=" + description + ", id=" + id + ", any=" + any + "]";
	}

}
