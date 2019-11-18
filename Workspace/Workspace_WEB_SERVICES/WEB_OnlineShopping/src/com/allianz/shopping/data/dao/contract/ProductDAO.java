package com.allianz.shopping.data.dao.contract;

import java.util.List;

import com.allianz.shopping.data.model.Product;

public interface ProductDAO {
	public boolean add(Product product);

	public boolean update(Product productData, int id);

	public boolean delete(Product product);

	public List<Product> getAll();

	public List<Product> getAllByName(String name);

	public List<Product> getAllByPrice(float min, float max);

	public Product find(int id);
}
